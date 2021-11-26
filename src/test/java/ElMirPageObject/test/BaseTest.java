package ElMirPageObject.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;

    @BeforeClass
    public WebDriver setUpWebDriver() {
        System.out.println("BeforeClass");
        System.setProperty("webdriver.chrome.driver", "/home/user/IdeaProjects/chromedriver");
        // Create a WebDriver
        if (driver == null) {
            driver = new ChromeDriver();
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        }
        driver.manage().window().maximize();
        return driver;
    }

    @AfterClass(alwaysRun = true)
    public void closeWebDriver() {
        System.out.println("AfterClass");
        driver.quit();
    }
}
