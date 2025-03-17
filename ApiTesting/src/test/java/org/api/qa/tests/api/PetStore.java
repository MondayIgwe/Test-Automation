package org.api.qa.tests.api;

import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.RequestOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import static org.api.qa.tests.helpers.IPayloads.ParseBody;
import static org.api.qa.tests.helpers.IPayloads.createBody;

public class PetStore {
    APIRequestContext requestContext;
    Playwright playwright;
    APIResponse response;
    final String API_RESOURCE = "v2/pet/findByStatus?status=available";

    @BeforeClass
    public void beforeClass() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("Accept", "application/json");

        playwright = Playwright.create();
        requestContext = playwright.request().newContext(
                new APIRequest.NewContextOptions()
                        .setBaseURL("https://petstore.swagger.io/")
                        .setExtraHTTPHeaders(headers));
    }

    @Test
    public void getSwaggerJsonTest() throws IOException {
        response = requestContext.get("v2/swagger.json");
        String bodyString = ParseBody(response.body());
        System.out.println(bodyString);
    }

    @Test
    public void getUserApiTest() throws IOException {
        response = requestContext.get("v2/pet/findByStatus?status=available");

        Assert.assertNotNull(response);
        byte[] body = response.body();
        Assert.assertEquals(response.status(), 200);
        Assert.assertTrue(response.ok());
        String bodyString = ParseBody(body);
        System.out.println(bodyString);

        try {
            Map<String, String> map = response.headers();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
            System.out.println("Status Code: " + response.status());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void postPetTest() throws IOException {
        // url, body, headers, method
        response = requestContext.post("v2/pet", RequestOptions.create().setData(createBody()));
        if (response.ok()) {
            System.out.println(response.text());
        }
    }

    @Test
    public void putPetTest() throws IOException {
        // url, body, headers, method
        response = requestContext.put("v2/pet", RequestOptions.create().setData(createBody()));
        if (response.ok()) {
            System.out.println(response.text());
        }
    }

    @Test
    public void deletePetTest() throws IOException {
        // url, body, headers, method
        response = requestContext.delete("v2/pet/9223372036854775807");
        System.out.println(response.statusText());

    }

    @AfterClass
    public void afterClass() {
        playwright.close();
    }
}
