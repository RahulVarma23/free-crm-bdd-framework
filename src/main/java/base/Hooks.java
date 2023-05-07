package base;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Hooks {

    private static final Logger LOGGER = LogManager.getLogger(Hooks.class);
    private WebDriver driver;

    @Before
    public void initializeDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--remote-allow-origins=*");
        driver= new ChromeDriver(options);
        driver.manage().window().maximize();
        LOGGER.info("Launching app url");
        driver.get("https://ui.cogmento.com/");
    }

    @After(order=1)
    public void tearDown() {
        driver.quit();
    }


    @AfterStep
    public void addScreenshotAfterStep(Scenario scenario) {
            TakesScreenshot tc = (TakesScreenshot) driver;
            final byte [] screenshot = tc.getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot , "image/png", scenario.getName());
    }

    public WebDriver getDriver() {
        return driver;
    }
}
