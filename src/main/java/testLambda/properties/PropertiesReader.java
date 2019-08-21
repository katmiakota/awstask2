package testLambda.properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import static testLambda.Constants.PROPERTIES_FILE_PATH;

public class PropertiesReader {

      public static String loadProperties(String key){
        Properties properties = new Properties();
          FileInputStream input = null;
          try {
              input = new FileInputStream(PROPERTIES_FILE_PATH);
          } catch (FileNotFoundException e) {
              e.printStackTrace();
          }
          try {
              properties.load(input);
          } catch (IOException e) {
              e.printStackTrace();
          }
          return properties.getProperty(key);
    }
}
