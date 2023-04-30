package runner;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Testing {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().browserVersion("111").setup();
        WebDriver driver= new ChromeDriver();
        driver.get("https://ui.cogmento.com/");
    }
}
