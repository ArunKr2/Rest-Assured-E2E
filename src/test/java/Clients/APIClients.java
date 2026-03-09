package Clients;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.File;

import static io.restassured.RestAssured.given;

public class APIClients {

    public static Response get(String endpoints){
      return  given()
                .contentType(ContentType.JSON)
                .when().get(endpoints)
                .then().extract().response();
    }

    public static Response post(String endpoints , File bodyV){
        return given()
                .contentType(ContentType.JSON)
                .body(bodyV)
                .when().post(endpoints)
                .then().extract().response();
    }
}
