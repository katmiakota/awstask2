package testLambda;

import testLambda.properties.PropertiesReader;

import static testLambda.properties.PropertiesReader.loadProperties;

public class Constants {


    public final static String PRIMARY_KEY = loadProperties("db.primaryKey");
    public final static String FILE_OBJ_NAME = loadProperties("s3.newFileName");
    public final static String BUCKET_NAME = loadProperties("s3.bucketName");
    public final static String SORT_KEY = loadProperties("db.sortKey");
    public final static String DB_TABLE_NAME = loadProperties("db.tableName");
    public final static String AWS_REGION = loadProperties("aws.region");

    public final static String FILE_PATH_TO_UPLOAD = loadProperties("s3.filePath");
    public final static String CONTENT_TYPE_TO_WRITE = loadProperties ("s3.contentTypeToWrite");
    public final static String  USER_METADATA_KEY = loadProperties("s3.UserMetadataKey") ;
    public final static String USER_METADATA_VALUE = loadProperties ("s3.UserMetadataValue") ;
    public final static String AWS_ACCESS_KEY = loadProperties("aws.accessKey");
    public final static String AWS_SECRET_KEY = loadProperties("aws.secretKey");

    public final static String PROPERTIES_FILE_PATH = "src/test/resources/build.properties";
    public final static String PACKAGE_ID = "packageId";
    public final static String ORIGIN_TIME_STAMP = "originTimeStamp";

}
