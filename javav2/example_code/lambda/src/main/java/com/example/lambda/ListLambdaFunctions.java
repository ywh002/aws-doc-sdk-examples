// snippet-comment:[These are tags for the AWS doc team's sample catalog. Do not remove.]
// snippet-sourcedescription:[ListLambdaFunctions.java demonstrates how to list all functions specific to the account by using the LambdaClient object.]
// snippet-service:[Lambda]
// snippet-keyword:[Java]
// snippet-keyword:[Amazon Lambda]
// snippet-keyword:[Code Sample]
// snippet-sourcetype:[full-example]
// snippet-sourcedate:[2020-10-02]
// snippet-sourceauthor:[AWS-scmacdon]

/**
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * This file is licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License. A copy of
 * the License is located at
 *
 * http://aws.amazon.com/apache2.0/
 *
 * This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

// snippet-start:[lambda.java2.ListLambdaFunctions.complete]
package com.example.lambda;

// snippet-start:[lambda.java2.list.import]
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.lambda.LambdaClient;
import software.amazon.awssdk.services.lambda.model.LambdaException;
import software.amazon.awssdk.services.lambda.model.ListFunctionsResponse;
import software.amazon.awssdk.services.lambda.model.FunctionConfiguration;
import java.util.Iterator;
import java.util.List;
// snippet-end:[lambda.java2.list.import]


public class ListLambdaFunctions {

    public static void main(String[] args) {

        Region region = Region.US_WEST_2;
        LambdaClient awsLambda = LambdaClient.builder()
                .region(region)
                .build();

        listFunctions(awsLambda);
    }

    // snippet-start:[lambda.java2.list.main]
    public static void listFunctions(LambdaClient awsLambda) {

        try {
            // Get a list of all functions
            ListFunctionsResponse functionResult = awsLambda.listFunctions();
            List<FunctionConfiguration> list = functionResult.functions();

            for (FunctionConfiguration config: list) {
                System.out.println("The function name is "+config.functionName());
            }

        } catch(LambdaException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
        // snippet-end:[lambda.java2.list.main]
    }
}
// snippet-end:[lambda.java2.ListLambdaFunctions.complete]
