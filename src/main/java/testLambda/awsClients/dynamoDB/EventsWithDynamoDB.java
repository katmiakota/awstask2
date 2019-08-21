package testLambda.awsClients.dynamoDB;

import com.amazonaws.services.dynamodbv2.document.DeleteItemOutcome;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.GetItemSpec;

import java.io.IOException;
import java.math.BigInteger;

import static testLambda.Constants.*;

public class EventsWithDynamoDB {
      ClientDynamoDB dynamoDBClient = new ClientDynamoDB();
    DynamoDB dynamoDB = new DynamoDB(dynamoDBClient.dynamoDBBuilder());
    Table table = dynamoDB.getTable(DB_TABLE_NAME);
    BigInteger sortKey = new BigInteger(SORT_KEY);
    public EventsWithDynamoDB() throws IOException {
    }


    public Item createItemInDB() {
        GetItemSpec spec = new GetItemSpec()
                .withPrimaryKey(PACKAGE_ID, PRIMARY_KEY, ORIGIN_TIME_STAMP, sortKey);
        Item item = table.getItem(spec);
        return item;

    }

    public DeleteItemOutcome deleteItemFromDB() {
        DeleteItemOutcome outcome = table
                .deleteItem(PACKAGE_ID, PRIMARY_KEY, ORIGIN_TIME_STAMP,  sortKey);
        return outcome;
    }

}
