package PracticeForLesson8.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;

    public BaseTest() {
        System.out.println("Constructor");
    }

    @BeforeClass
    public WebDriver setUpWebDriver() {
        System.out.println("BeforeClass");
        System.setProperty("webdriver.chrome.driver", "/home/user/projects/common/study_plan/workspace/lessonRest1/src/test/resources/chromedriver");
        // Create a WebDriver
        if(driver == null) {
            driver = new ChromeDriver();
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        }
        return driver;
    }

    @AfterClass(alwaysRun = true)
    public void closeWebDriver() {
        System.out.println("AfterClass");
        driver.quit();
    }


}
