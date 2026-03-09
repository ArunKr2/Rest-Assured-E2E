package Base;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import utils.ConfigReader;

public class baseTest {

    @BeforeClass
    public void setUp(){
        RestAssured.baseURI = ConfigReader.readproperty("url");
    }
}
