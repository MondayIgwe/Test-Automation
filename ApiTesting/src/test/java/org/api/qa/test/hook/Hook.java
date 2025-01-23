package org.api.qa.test.hook;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.RequestOptions;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;

import static org.api.qa.helpers.IPayloads.Payloads.setPayload;

public class Hook {
    private static Playwright playwright;
    private static APIResponse apiResponse;
    private static APIRequestContext apiRequestContext;

    @Before
    public static void setUp() {
        // Initialize the API client
        playwright = Playwright.create();
        APIRequest apiRequest = playwright.request();

        APIRequest.NewContextOptions context = new APIRequest.NewContextOptions();
        String BASE_URL = "https://gorest.co.in/public/v2/";
        context.setBaseURL(BASE_URL);
        context.ignoreHTTPSErrors = true;
        context.setExtraHTTPHeaders(setPayload());

        apiRequestContext = apiRequest.newContext(context);
        apiResponse = apiRequestContext.get("users",
                RequestOptions.create()
                        .setHeader("content-Type", "application/json")
                        .setMaxRetries(3).setFailOnStatusCode(false)
                        .setIgnoreHTTPSErrors(true));
        System.out.println("API client initialized");
    }

    @BeforeStep
    public void beforeStep() {
        System.out.println("Run Before each step in cucumber scenario step");
    }

    public static APIResponse getApiResponse() {
        return apiResponse;
    }

    @AfterStep
    public void afterStep() {
        System.out.println("Run After each step in cucumber scenario step");
    }

    @After
    public static void tearDown() {
        // Close the API client
        try {
            System.out.println("Closing API client");
            apiRequestContext.dispose(new APIRequestContext.DisposeOptions()
                    .setReason("API client closed"));
            apiResponse.dispose();
            playwright.close();
        } catch (PlaywrightException e) {
            System.out.println("api response body is disposed");
        }
    }
}
