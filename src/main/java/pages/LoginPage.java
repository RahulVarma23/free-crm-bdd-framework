package pages;

import base.GenericFunctions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends GenericFunctions {

    @FindBy(name = "email")
    WebElement usernameTextBox;

    @FindBy(xpath="//input[@type='password']")
    WebElement passwordTextBox;

    @FindBy(css="[class*='submit']")
    WebElement loginButton;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public void fillUsernameTextBox(String username) {
        enterText(usernameTextBox, username);
    }

    public void fillPasswordTextBox(String password) {
        enterText(passwordTextBox, password);
    }

    public void clickOnLoginButton() {
        clickOnElement(loginButton);
    }

    public String getLoginPageTitle() {
        return getPageTitle();
    }
}
