package PracticeForLesson8;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class ElMirTest {

    WebDriver driver;
    WebDriverWait wait;


    @BeforeClass
    public WebDriver setUpWebDriver() {
        System.setProperty("webdriver.chrome.driver", "/home/user/projects/common/study_plan/workspace/lessonRest1/src/test/resources/chromedriver");
        // Create a WebDriver
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();

        return driver;
    }

    @Test
    public void goToContactsOnElMirSite() throws InterruptedException {
        Actions action = new Actions(driver);

        // Open ElMir site
        driver.get("https://elmir.ua/");
        //Thread.sleep(2000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//li/a[@class='ml-a pa'])[2]")));
        System.out.println("Size: "+driver.manage().window().getSize());
        //Find the Contacts item of menu
        WebElement contactsHover = driver.findElement(By.xpath("(//li/a[@class='ml-a pa'])[2]"));

        // Move to the hover element: "Contacts"
        action.moveToElement(contactsHover).build().perform();

        //Click on the Contacts element
        wait.until(ExpectedConditions.elementToBeClickable(contactsHover)).click();

        // Find the Contacts item of menu into menu: "Contacts"
        WebElement contactsMenuIntoMenuContacts = driver.findElement(By.xpath("//ul[@class='submenu']/li/a[@href ='/contacts.html']"));
        wait.until(ExpectedConditions.elementToBeClickable(contactsMenuIntoMenuContacts)).click();

        // Find the required text on Contacts page
        WebElement callCentreText = driver.findElement(By.xpath("//span[text()='Колл-центр']"));

        Assert.assertEquals(callCentreText.getText(), "Колл-центр");

    }

    @AfterClass(alwaysRun = true)
    public void closeWebDriver() {
        driver.quit();
    }
}
