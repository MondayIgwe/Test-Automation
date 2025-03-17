package org.api.qa.tests.stepDefinitions;

import com.microsoft.playwright.APIResponse;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.JsonNode;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.io.IOException;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotSame;

public class GetUserStep {
    APIResponse apiResponse;

    @Given("I set the base url {string}")
    public void i_set_the_base_url(String string) {

    }

    @Given("I send a GET request to {string}")
    public void i_send_a_get_request_to(String string) throws IOException {
        System.out.println("GET request to: " + string);
        String statusText = apiResponse.statusText();
        int status = apiResponse.status();
        byte[] body = apiResponse.body();
        System.out.println("Status Text: " + statusText);
        System.out.println("Status: " + status);

        ObjectMapper mapper = new ObjectMapper();
        String bodyAsTxt = mapper.readTree(body).asText();
        System.out.println("Body: " + bodyAsTxt);
    }

    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(Integer int1) throws IOException {
        System.out.println("Response status code is: " + int1);
        String statusText = apiResponse.statusText();
        int status = apiResponse.status();
        byte[] body = apiResponse.body();


        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(body);
        String pretty = jsonNode.toPrettyString();

        System.out.println("Status Text: " + statusText);
        System.out.println("Status: " + status);
        System.out.println("Body: " + pretty);
        String id = jsonNode.path(0).get("id").toPrettyString();
        Map<String, String> headers = apiResponse.headers();

        if (apiResponse.ok()) {
            System.out.println(apiResponse.ok());
            System.out.println("ID: " + id);
            System.out.println("Url: " + apiResponse.url());
            System.out.println("Content Header : " + headers.get("content-type"));
            System.out.println("Headers: " + headers);

            // Verify the response status code and status text
            // Assert
            assertEquals(status, 200);
            assertEquals(statusText, "OK");
            String textBody = apiResponse.text();
            System.out.println("Body response:" + textBody);

            JsonNode j = mapper.readTree(textBody);
            String idasTxt = j.path(0).get("id").asText();

            System.out.println("================================================");
            System.out.println("text: " + idasTxt);
            assertNotSame(id, idasTxt);
            System.out.println("ID: " + id);
        }
    }

    @Given("I send a POST request to {string}")
    public void iSendAPOSTRequestTo(String arg0) {
    }

    @Given("I send a Put request to {string}")
    public void iSendAPutRequestTo(String arg0) {
    }
}
