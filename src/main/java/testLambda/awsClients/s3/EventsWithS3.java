package testLambda.awsClients.s3;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

import java.io.File;
import java.io.IOException;

import static testLambda.Constants.*;


public class EventsWithS3 {
     ClientS3 s3 = new ClientS3();
    AmazonS3 clientS3 = s3.s3ClientBuilder();

    public EventsWithS3() throws IOException {

    }

    public void uploadFile() throws IOException {
         PutObjectRequest request = new PutObjectRequest(BUCKET_NAME, FILE_OBJ_NAME, new File(FILE_PATH_TO_UPLOAD));
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentType(CONTENT_TYPE_TO_WRITE);
        metadata.addUserMetadata(USER_METADATA_KEY, USER_METADATA_VALUE);//??????
        request.setMetadata(metadata);
        clientS3.putObject(request);

    }


    public void deleteFile() {
             clientS3.deleteObject(BUCKET_NAME, FILE_OBJ_NAME);
    }


}
