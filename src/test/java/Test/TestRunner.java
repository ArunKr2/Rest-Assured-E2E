package Test;

import Base.baseTest;
import Clients.APIClients;
import Endpoints.Routes;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestRunner extends baseTest {

    @Test
    public void getUser(){
        Response response = APIClients.get(Routes.UserPath);

        response.prettyPrint();

        Assert.assertEquals(response.getStatusCode(),200);
    }
}
