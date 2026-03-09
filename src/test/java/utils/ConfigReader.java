package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties prob;

    static {

        try{

            String FilePath = System.getProperty("user.dir")+"/src/test/resources/config.properties";

            FileInputStream fis = new FileInputStream(FilePath);

            prob = new Properties();
            prob.load(fis);

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }


    public static String readproperty(String value){
        return prob.getProperty(value);
    }
}
