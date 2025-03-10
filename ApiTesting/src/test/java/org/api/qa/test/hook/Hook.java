package org.api.qa.test.hook;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.RequestOptions;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;

import static com.qa.main.utils.Utility.timeOut;
import static com.qa.main.utils.Utility.GO_REST_API_BASE_URI;
import static com.qa.main.payload.IPayloads.Payloads.setPayload;

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
        context.setBaseURL(GO_REST_API_BASE_URI);
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
        System.out.println("Run Before each step in cucumber scenario step" + timeOut);
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
