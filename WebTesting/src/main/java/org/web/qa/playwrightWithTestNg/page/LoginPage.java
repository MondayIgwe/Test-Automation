package org.web.qa.playwrightWithTestNg.page;

import com.microsoft.playwright.Page;
import org.web.qa.playwrightWithTestNg.Events.CommonEvents;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginPage {
    CommonEvents events;
    private final String userEmailByXpath = "xpath=//input[@name='email1']";
    private final String userEmailByCSS = "css=input[name='email1']";
    private final String passwordPlaceHolder = "Enter Password";
    private final String signInTxt = "Sign in";
    private final String submitButton = "xpath=//button[@type='submit']";
    private final String loginSuccessMessage = "xpath=//div[contains(text(), 'Login successful')]";
    private final String errorMessage = "xpath=//h2[@class='errorMessage']";

    public LoginPage(Page page) {
        this.events = new CommonEvents(page);
    }

    public void enterUsername(String username) {
        events.typeByLocator(userEmailByCSS, username);
    }

    public void enterPassword(String password) {
        events.typeByPlaceHolder(passwordPlaceHolder, password);
    }

    public void clickLogin() {
        //events.clickByText(signInTxt);
        events.clickByLocator(submitButton);
    }

    public void validateEmailError() {
        events.clickByLocator(submitButton);
        assertThat(events.findLocator(errorMessage))
                .containsText("Email and Password is required");
    }
}
