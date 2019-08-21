package testLambda.awsClients;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import java.io.IOException;

import static testLambda.Constants.AWS_ACCESS_KEY;
import static testLambda.Constants.AWS_SECRET_KEY;

public class CredentialsForAWS {
       private AWSCredentials credentials;

    public AWSCredentials setAWSCredentials() throws IOException {
        credentials = new BasicAWSCredentials(
                AWS_ACCESS_KEY,
                AWS_SECRET_KEY);
        return credentials;
    }


}
