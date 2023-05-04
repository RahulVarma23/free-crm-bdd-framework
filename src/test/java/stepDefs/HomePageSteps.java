package stepDefs;

import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import pages.HomePage;

public class HomePageSteps {

    private static final Logger LOGGER = LogManager.getLogger(HomePageSteps.class);

    HomePage homePage;

    public HomePageSteps(HomePage homePage) {
          this.homePage= homePage;
    }

    @Then("I should be navigated to home page")
    public void i_should_be_navigated_to_home_page() {
        LOGGER.info("Verifying if home page icon is displayed");
        Assert.assertTrue(homePage.isHomeIconDisplayed());
    }
}
