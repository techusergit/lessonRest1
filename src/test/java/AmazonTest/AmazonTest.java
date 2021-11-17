package AmazonTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AmazonTest {

    WebDriver driver;

    @BeforeClass
    public WebDriver setUpWebDriver() {
        System.setProperty("webdriver.chrome.driver", "/home/user/IdeaProjects/chromedriver");
        // 1. Создать Webdriver:
        driver = new ChromeDriver();

        return driver;
    }

    @Test
    public void findTheBootsOnAmazon() {

        // Open the site
        driver.get("https://www.amazon.com/");

        // Amazon search field
        WebElement amazonSearchField = driver.findElement(By.id("twotabsearchtextbox"));

        amazonSearchField.sendKeys("boots mens");

        // Amazon search button
        WebElement amazonSearchButton = driver.findElement(By.id("nav-search-submit-button"));
        amazonSearchButton.click();

        // Found boots
        WebElement amazonTimberlandBootName = driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]"));

        // Found price for boots
        WebElement amazonTimberlandBootPrice = driver.findElement(By.xpath("//span[@class='a-price-whole'][contains(text(),'56')]"));

        // Get name the boots
        String nameOfBoots = amazonTimberlandBootName.getText();

        // Compare actual and expected names of boots
        Assert.assertEquals(nameOfBoots, "Lugz Men's Convoy Fleece Wr Winter Boot");


        // Get the price of boots
        String priceOfBoots = amazonTimberlandBootPrice.getText();

        // Compare actual and expected prices of boots
        Assert.assertEquals(priceOfBoots, "56");

        // Webdriver quit
        driver.quit();

    }

    @AfterClass(alwaysRun = true)
    public void closeWebDriver() {
        driver.quit();
    }
}