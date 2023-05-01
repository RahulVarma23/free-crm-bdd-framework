package pages;

import base.GenericFunctions;
import base.Hooks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends GenericFunctions {

    @FindBy(name = "email")
    private WebElement usernameTextBox;

    @FindBy(xpath="//input[@type='password']")
    private WebElement passwordTextBox;

    @FindBy(css="[class*='submit']")
    private WebElement loginButton;

    WebDriver driver;

    public LoginPage(Hooks hooks) {
        super(hooks);
        driver = hooks.getDriver();
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
