package runner;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;

public class Testing {
    public static void main(String[] args) throws IOException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver= new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.makemytrip.com");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("[id*='notification-frame']")));
        driver.findElement(By.xpath("//i[@class='wewidgeticon we_close']")).click();
        driver.switchTo().defaultContent();
        WebElement roundTrip =driver.findElement(By.cssSelector("[data-cy=roundTrip]"));
        roundTrip.click();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE,5);
        Date date= calendar.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd");
        String FormattedDate=simpleDateFormat.format(date);
        driver.findElement(By.cssSelector("[data-cy='departureDate']")).click();
        driver.findElement(By.xpath("(//div[@class='DayPicker-Week']/div[@class='DayPicker-Day']/div[p[text()="+FormattedDate+"]])[1]")).click();
        Calendar calendar1 = Calendar.getInstance();
        calendar1.add(Calendar.DATE,10);
        Date date1= calendar1.getTime();
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd");
        String FormattedDate1=simpleDateFormat1.format(date1);
        driver.findElement(By.xpath("(//div[@class='DayPicker-Week']/div[@class='DayPicker-Day']/div[p[text()="+FormattedDate1+"]])[1]")).click();
        driver.findElement(By.cssSelector("[class*=widgetSearchBtn]")).click();
        List<WebElement> fareList=driver.findElements(By.cssSelector("[class*='priceInfo']>div>p"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class*='button buttonSecondry']")));
        driver.findElement(By.cssSelector("[class*='button buttonSecondry']")).click();
        List<Integer> list=new ArrayList<>();
        for (WebElement ee:fareList)
        {
            list.add(Integer.valueOf(ee.getText().replaceAll("₹ ","")));
        }
        System.out.println(list);
        Integer minFare= Collections.min(list);
        System.out.println(minFare);
        TakesScreenshot takesScreenshot= (TakesScreenshot) driver;
        File source=takesScreenshot.getScreenshotAs(OutputType.FILE);
        File DestFile=new File(".//target//screenshot.png");
        FileUtils.copyFile(source, DestFile);
        //driver.quit();
    }
}
