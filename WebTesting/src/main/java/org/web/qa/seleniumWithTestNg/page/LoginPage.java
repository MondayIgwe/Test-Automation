package org.web.qa.seleniumWithTestNg.page;

import org.apache.logging.log4j.core.util.Assert;
import org.openqa.selenium.WebDriver;
import org.web.qa.seleniumWithTestNg.event.SeleniumEvents;

import java.util.List;

public class LoginPage {
    private SeleniumEvents seleniumEvents;

    public LoginPage(WebDriver driver) {
        System.out.println(driver);
        Assert.isEmpty(driver);
        new SeleniumEvents(driver);
    }

    public void selectDateFromWebTable() {
        String rows = "//*[@id='customers']/tbody/tr[2]";
        String columns = "]/td[1]";

//        for (int i = 2; i < 7; i++) {
//            String xpath = rows + i + columns;
//            WebElement element = seleniumEvents.findOne(By.xpath("//table/tbody/tr[2]/td[1]"));
//            System.out.println(element.getText());
//        }
    }
}
