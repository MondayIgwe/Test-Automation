package services.reqre.delete;

import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static utils.Commons.REQRES_BASE_URI;
import static utils.Commons.USERS;

public class DeleteOperationsTest {
    String resource = "/2";

    @BeforeTest
    public void setUp() {
        baseURI = REQRES_BASE_URI;
    }

    @Test
    public void getValidatableResponse() {
        ValidatableResponse status = given()
                .header("Content-Type", "application/json")
                .contentType("application/json")
                .when().delete(USERS.concat(resource))
                .then().log().status();
        System.out.println("status:" + status.statusCode(HttpStatus.SC_NO_CONTENT));
    }
}
