package stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginPage;

public class LoginSteps {

    LoginPage loginPage = new LoginPage();

    @Given("I am on login page")
    public void i_am_on_login_page() {
        String title = loginPage.getLoginPageTitle();
        Assert.assertEquals(title , "Cogmento CRM");
    }

    @When("I enter username as {string} and password as {string}")
    public void i_enter_username_as_and_password_as(String username, String password) {
        loginPage.fillUsernameTextBox(username);
        loginPage.fillPasswordTextBox(password);
    }

    @And("I click on login button")
    public void i_click_on_login_button() {
        loginPage.clickOnLoginButton();
    }
}
