package services.reqre.get;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import io.restassured.http.Headers;
import org.apache.http.HttpStatus;
import io.restassured.response.Response;

import static org.testng.Assert.*;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static utils.Commons.*;

import com.github.javafaker.Faker;

import java.util.HashMap;
import java.util.Map;

public class UsersTest {

    Faker faker = new Faker();

    @BeforeTest
    public void setUp() {
        baseURI = REQRES_BASE_URI;
        basic(faker.address().firstName(), faker.address().lastName());
    }

    @Test
    public void getUser() {
        basePath = "Users?page=2";
        String[] params = new String[]{"Eve"};
        when().get().then().extract().response().then().body("data.first_name", hasItems(params));

    }


    @Test
    public void getUsers() {
        basePath = USERS;

        // Information for server processing
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");

        Response response = given().headers(headers).when().get().then().extract().response();

        // Assertions
        System.out.println(response.getBody().asString());
        assertThat(response.jsonPath().get("data.size()"), is(greaterThan(0)));
        assertThat(response.jsonPath().get("data[0].first_name"), is("George"));
        assertThat(response.jsonPath().get("data[0].first_name"), oneOf("George"));

        int statusCode = response.getStatusCode();
        assertThat(statusCode, is(HttpStatus.SC_OK));
        assertEquals(statusCode, OK);
        assertNotEquals(statusCode, CREATED);
    }
}
