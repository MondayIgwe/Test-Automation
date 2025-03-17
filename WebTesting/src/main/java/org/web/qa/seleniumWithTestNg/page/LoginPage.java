package org.web.qa.seleniumWithTestNg.page;

import org.apache.logging.log4j.core.util.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.web.qa.seleniumWithTestNg.event.SeleniumEvents;

import java.util.List;

public class LoginPage extends PageFactory {
    private final SeleniumEvents seleniumEvents;

    public LoginPage(WebDriver driver) {
        System.out.println(driver);
        Assert.isEmpty(driver);
        seleniumEvents = new SeleniumEvents(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "input[name='username']")
    private WebElement username;

    @FindBy(xpath = "input[name='password']")
    private WebElement password;

    @FindBy(xpath = "button[type='submit']")
    private WebElement submitButton;

    public void login(String usernameTxt, String passwordTxt) {
        seleniumEvents.sendKeyz(username, usernameTxt);
        seleniumEvents.sendKeyz(password, passwordTxt);
        seleniumEvents.clickElement(submitButton);
    }
}
