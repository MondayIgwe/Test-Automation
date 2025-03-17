package org.api.qa.tests.api;

import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.HttpHeader;
import com.microsoft.playwright.options.RequestOptions;
import org.api.qa.tests.helpers.IPayloads;

import static org.testng.Assert.*;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class GoRest {

    Playwright playwright;
    APIResponse response;
    APIRequestContext apiRequestContext;

    @Test
    public void getUsersApiTest() throws IOException {
        //Response
        RequestOptions requestOptions = RequestOptions.create();
        requestOptions.setQueryParam("gender","male");

        response = apiRequestContext.get("public/v2/users", requestOptions);

        assertEquals(response.status(), 200);
        assertTrue(response.ok());
        assertNotNull(response.headers());
        List<HttpHeader> httpHeaderList = response.headersArray();

        for (HttpHeader httpHeader : httpHeaderList) {
            System.out.println("Header: " + httpHeader.name + ":" + httpHeader.value);

            Map<String, String> stringMap = response.headers();
            assertEquals(stringMap.get("content-type"), "application/json; charset=utf-8");
            assertEquals(stringMap.get("vary"), "Origin");
        }

        String responseBody = IPayloads.ParseBody(response.body());
        System.out.println(responseBody);

    }

}
