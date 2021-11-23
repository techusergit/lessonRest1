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

    public WebDriver driver;

    @BeforeClass
    public WebDriver setUpWebDriver() {
        System.setProperty("webdriver.chrome.driver", "/home/user/IdeaProjects/chromedriver");
        // Create a WebDriver
        driver = new ChromeDriver();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        return driver;
    }

    @AfterClass(alwaysRun = true)
    public void closeWebDriver() {
        driver.quit();
    }

    public WebElement waitElementVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }
}
