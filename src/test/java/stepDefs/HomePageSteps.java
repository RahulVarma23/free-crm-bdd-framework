package stepDefs;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.HomePage;

public class HomePageSteps {

    HomePage homePage;

    public HomePageSteps(HomePage homePage) {
          this.homePage= homePage;
    }

    @Then("I should be navigated to home page")
    public void i_should_be_navigated_to_home_page() {
        System.out.println(homePage.getHomePageHeaderText());
        Assert.assertTrue(homePage.getHomePageHeaderText().contains("COGMENTO"));
    }
}
