package stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import pages.LoginPage;

public class LoginPageSteps {

    private static final Logger LOGGER = LogManager.getLogger(LoginPageSteps.class);
    LoginPage loginPage;
    public LoginPageSteps (LoginPage loginPage){
        this.loginPage = loginPage;
    }

    @Given("I am on login page")
    public void i_am_on_login_page() {
        String title = loginPage.getLoginPageTitle();
        Assert.assertEquals(title , "Cogmento CRM");
        LOGGER.debug("Login page is validation");
    }

    @When("I enter username as {string} and password as {string}")
    public void i_enter_username_as_and_password_as(String username, String password) {
        LOGGER.info("Entering username: "+username);
        loginPage.fillUsernameTextBox(username);
        LOGGER.info("Entering password: "+password);
        loginPage.fillPasswordTextBox(password);
    }

    @And("I click on login button")
    public void i_click_on_login_button() {
        LOGGER.info("Clicking on login button");
        loginPage.clickOnLoginButton();
    }
}
