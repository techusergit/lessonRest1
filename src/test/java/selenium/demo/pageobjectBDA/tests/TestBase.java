package selenium.demo.pageobjectBDA.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public WebDriver driver;

    @BeforeTest
    public void setup() {
      //  WebDriverManager.firefoxdriver().setup();
     //   WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
     //   driver = new FirefoxDriver();
        if (driver == null) {
            driver = new ChromeDriver();
        }
       // driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
        driver = null;
    }
}
