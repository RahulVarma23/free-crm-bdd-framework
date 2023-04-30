package base;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public abstract class GenericFunctions {

    protected WebDriver driver;

    @Before
    public void initializeDriver() {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.get("https://ui.cogmento.com/");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    public String getPageTitle() {
        WebDriverManager.chromedriver().browserVersion("112").setup();
        driver= new ChromeDriver();
        driver.get("https://ui.cogmento.com/");
        return driver.getTitle();
    }

    public void clickOnElement(WebElement element){
        element.click();
    }

    public void clickOnElementWithJs(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    public void enterText(WebElement element, String text){
        element.sendKeys(text);
    }

    public String getText(WebElement element){
        return element.getText();
    }

    public void selectValueFromDropdownByVisibleText(WebElement element, String visibleText){
       Select select = new Select(element);
       select.selectByVisibleText(visibleText);
    }

    public void acceptAlert() {
        Alert alert =  driver.switchTo().alert();
        alert.accept();
    }

    public List<String> getAllElementTextFromList(List<WebElement> listOfWebElements) {
        List<String> elementTexts = new ArrayList<>();
        for(WebElement element : listOfWebElements){
            elementTexts.add(element.getText());
        }
        return elementTexts;
    }

    public void mouseHoverOnElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    public void selectValueFromDropdown(List<WebElement> webElementList, String visibleText){
        for(WebElement element : webElementList){
            if(element.getText().equals(visibleText)){
                element.click();
                break;
            }
        }
    }
}
