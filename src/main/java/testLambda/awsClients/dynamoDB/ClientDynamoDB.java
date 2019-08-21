package testLambda.awsClients.dynamoDB;

import testLambda.awsClients.CredentialsForAWS;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;

import java.io.IOException;

import static testLambda.Constants.AWS_REGION;

public class ClientDynamoDB {
    CredentialsForAWS credentials = new CredentialsForAWS();

   public AmazonDynamoDB dynamoDBBuilder() throws IOException {
             return AmazonDynamoDBClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials.setAWSCredentials()))
                .withRegion(AWS_REGION)
                .build();
    }

}
