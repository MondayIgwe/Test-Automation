package services.reqre.post;

import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static utils.Payload.*;

import static io.restassured.RestAssured.*;
import static utils.Commons.REQRES_BASE_URI;

public class Users {
    @BeforeTest
    public void setUp() {
        baseURI = REQRES_BASE_URI;
    }

    @Test
    public void postUser() {
        basePath = "users";
        given()
                .body(createPayload())
                .when()
                .post()
                .then().statusCode(HttpStatus.SC_CREATED).log().all();
        System.out.println("Creating a new user");
    }
}
