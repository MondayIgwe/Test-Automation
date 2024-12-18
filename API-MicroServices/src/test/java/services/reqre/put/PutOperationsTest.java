package services.reqre.put;

import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;
import static utils.Commons.REQRES_BASE_URI;
import static utils.Commons.USERS;
import static utils.Payload.*;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PutOperationsTest {
    @BeforeTest
    public void setUp() {
        baseURI = REQRES_BASE_URI;
    }

    @Test
    public void updateUser() {
        given().header("Content-Type", "application/json")
                .contentType("application/json")
                .body(putPayload())
                .when().put(USERS.concat("/2"))
                .then().log().body();
    }

    @Test
    public void patchUser() {
      ValidatableResponse validatableResponse = given().header("Content-Type", "application/json")
                .contentType("application/json")
                .body(putPayload())
                .when().patch(USERS.concat("/2"))
                .then().log().body();

        System.out.println(validatableResponse);
    }
}
