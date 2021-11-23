package selenium.demo;

import org.checkerframework.checker.units.qual.K;
import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.test.web.servlet.htmlunit.webdriver.WebConnectionHtmlUnitDriver;
import org.testng.Assert;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.time.Duration;
import java.util.*;


public class dba_firstSelenium {

    public List<WebElement> keys;
    public List<WebElement> values;
    WebDriver driver;


    @BeforeTest
    public void setup() throws IOException {
        System.setProperty("webdriver.chrome.driver",
                "chromedriver.exe");
        driver = new ChromeDriver();
    }


    @AfterTest(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }



    @Test
    public void elmirTest() {
        // System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        WebDriverWait wait = new WebDriverWait(driver, 10);

        driver.get("https://elmir.ua/");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("basket-prompt")));
        WebElement elementAlert = driver.findElement(By.id("subscribe-deny"));
        Assert.assertTrue(elementAlert.isDisplayed());
        elementAlert.click();
        Actions mouse = new Actions(driver);
        //локатор на кнопку Контакты
        WebElement element = driver.findElement(By.xpath("//a[@class = 'ml-a pa' and text() = 'Контакты']"));
        //локатор на кнопку контактс в всплывающем меню
        WebElement submenu1 =  driver.findElement(By.xpath("//a[@class='ml-a' and @href='/contacts.html']"));
        mouse.moveToElement(element).perform();
        //локатор на всплывающее меню
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[2]/ul[@class='submenu']")));

       // mouse.moveToElement(submenu1).perform();
        submenu1.click();
        wait.until(ExpectedConditions.urlToBe("https://elmir.ua/contacts.html"));



    }


    @Test
    public void amazonTest() {

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver,5);

        driver.get("https://amazon.com");
        WebElement element = driver.findElement(By.id("twotabsearchtextbox"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));
        element.click();
        element.sendKeys("shoes");
        element.submit();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.amazon.com/s?k=shoes&ref=nb_sb_noss" );
        List<WebElement> element1 = driver.findElements(By.xpath("//span[@class='a-offscreen']"));
        List<String> sortedList = new ArrayList<>();
        for(WebElement k : element1){
            sortedList.add(k.getAttribute("innerText"));
        }
        //  sortedList.sort(String::compareTo);
        sortedList.sort(Comparator.comparing(String::length));
        System.out.println(sortedList);
        WebElement element3 = driver.findElement(By.xpath("//span[text()='" + sortedList.get(10) +"']/ancestor::div[@data-asin]/div/span/div/div/div[2]/div[1]"));
        element3.getAttribute("innerText");
        System.out.println(element3.getAttribute("innerText").toString());
        System.out.println(element1.size());
        driver.quit();
    }



}
