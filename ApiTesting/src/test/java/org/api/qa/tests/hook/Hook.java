package org.api.qa.tests.hook;

import com.microsoft.playwright.*;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;

public class Hook {

    private static APIRequestContext request;

    @Before
    public void setUp() {
        String petStoreApiBaseUri = System.getenv("PET_STORE_API_BASE_URI");
    }

    @BeforeStep
    public void beforeStep() {
        System.out.println("Run Before each step in cucumber scenario step");
    }


    @AfterStep
    public void afterStep() {
        System.out.println("Run After each step in cucumber scenario step");
    }

    @After
    public void tearDown() {
        // Close the API client
        try {
            System.out.println("Closing API client");
            request.dispose(new APIRequestContext.DisposeOptions()
                    .setReason("API client closed"));
        } catch (PlaywrightException e) {
            System.out.println("api response body is disposed");
        }
    }
}
