package org.api.qa.tests.api;

import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Base {
    Playwright playwright;
    APIResponse response;
    APIRequestContext apiRequestContext;

    @BeforeClass
    public void setup() {
        // Request => url, method, headers, body
        playwright = Playwright.create();
        APIRequest request = playwright.request();
        apiRequestContext = request.newContext(new APIRequest.NewContextOptions()
                .setBaseURL("https://gorest.co.in/").setIgnoreHTTPSErrors(true)
                .setUserAgent("java"));
    }

    @AfterClass
    public void teardown() {
        apiRequestContext.dispose();
        playwright.close();
    }
}
