package testLambda.awsClients.s3;

import testLambda.awsClients.CredentialsForAWS;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

import java.io.IOException;

import static testLambda.Constants.AWS_REGION;

public class ClientS3 {
    CredentialsForAWS credentials = new CredentialsForAWS();

    public AmazonS3 s3ClientBuilder() throws IOException {
        return AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials.setAWSCredentials()))
                .withRegion(AWS_REGION)
                .build();
    }
}
