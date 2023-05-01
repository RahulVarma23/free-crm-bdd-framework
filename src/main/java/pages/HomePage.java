package pages;

import base.GenericFunctions;
import base.Hooks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends GenericFunctions {

    @FindBy(xpath = "//div[@class='header item']")
    private WebElement homePageHeader;

    WebDriverWait wait;
    WebDriver driver;

    public HomePage(Hooks hooks) {
        super(hooks);
        driver = hooks.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public String getHomePageHeaderText() {
        wait.until(ExpectedConditions.urlToBe("https://ui.cogmento.com/"));
        return getElementText(homePageHeader);
    }
}
