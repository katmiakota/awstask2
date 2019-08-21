package testLambda;

import com.amazonaws.services.dynamodbv2.document.*;
import com.amazonaws.services.s3.AmazonS3;
import org.junit.jupiter.api.*;
import testLambda.awsClients.dynamoDB.ClientDynamoDB;
import testLambda.awsClients.dynamoDB.EventsWithDynamoDB;
import testLambda.awsClients.s3.ClientS3;
import testLambda.awsClients.s3.EventsWithS3;

import java.io.*;
import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;
import static testLambda.Constants.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class S3TriggerLambdaToDynamoDBTest {
    private static EventsWithDynamoDB eventsWithDynamoDB;
    private static ClientDynamoDB dynamoDBClient;
    private static EventsWithS3 eventsWithS3;
    private static ClientS3 s3;
    private static BigInteger sortKey = new BigInteger(SORT_KEY);

    @BeforeAll
    public static void setUp() throws Exception {
        eventsWithDynamoDB = new EventsWithDynamoDB();
        dynamoDBClient = new ClientDynamoDB();
        eventsWithS3 = new EventsWithS3();
        s3 = new ClientS3();
    }

    @Test
    @Order(1)
    public void uploadToS3AndCheckLambda() throws IOException, InterruptedException {
         eventsWithS3.uploadFile();
        AmazonS3 s3Client = s3.s3ClientBuilder();
       Item item = eventsWithDynamoDB.createItemInDB();
        Thread.sleep(10000);
        System.out.println(item);
        assertEquals(PRIMARY_KEY, eventsWithDynamoDB.createItemInDB().get(PACKAGE_ID));
        assertEquals(SORT_KEY, eventsWithDynamoDB.createItemInDB().get(ORIGIN_TIME_STAMP).toString());
        assertTrue(s3Client.doesObjectExist(BUCKET_NAME, FILE_OBJ_NAME));
    }


    @Test
    @Order(2)
    public void removeFromS3AndCheckLambda() throws IOException, InterruptedException {
        eventsWithDynamoDB.deleteItemFromDB();
        DynamoDB dynamoDB = new DynamoDB(dynamoDBClient.dynamoDBBuilder());
        AmazonS3 s3Client = s3.s3ClientBuilder();
        Table table = dynamoDB.getTable(DB_TABLE_NAME);
               eventsWithS3.deleteFile();
        Thread.sleep(2000);
        assertNull(table.getItem(PACKAGE_ID, PRIMARY_KEY,ORIGIN_TIME_STAMP,sortKey ));
        assertFalse(s3Client.doesObjectExist(BUCKET_NAME, FILE_OBJ_NAME));
    }


}
