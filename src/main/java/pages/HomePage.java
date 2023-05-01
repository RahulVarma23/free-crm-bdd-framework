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

    @FindBy(css = "[class='home icon']")
    private WebElement homeIcon;

    WebDriverWait wait;
    WebDriver driver;

    public HomePage(Hooks hooks) {
        super(hooks);
        driver = hooks.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public boolean isHomeIconDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(homeIcon));
        return homeIcon.isDisplayed();
    }
}
