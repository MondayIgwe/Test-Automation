package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "user-name")
    WebElement username;
    @FindBy(id = "password")
    WebElement password;
    @FindBy(id = "login-button")
    WebElement loginButton;

    public void enterLoginDetails(String username, String password) {
        this.username.sendKeys(username);
        this.password.sendKeys(password);
    }

    public void clickLogin(){
        loginButton.click();
    }

}
