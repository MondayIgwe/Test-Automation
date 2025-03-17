package org.web.qa.seleniumWithTestNg.page;

import org.apache.logging.log4j.core.util.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.web.qa.seleniumWithTestNg.event.SeleniumEvents;

import java.util.List;

public class LoginPage extends PageFactory {
    private SeleniumEvents seleniumEvents;

    public LoginPage(WebDriver driver) {
        System.out.println(driver);
        Assert.isEmpty(driver);
        seleniumEvents = new SeleniumEvents(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "login")
    private WebElement login;

}
