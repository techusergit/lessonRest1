package selenium.demo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
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
import java.util.concurrent.TimeUnit;


public class FirstSeleniumDBA {

    public List<WebElement> keys;
    public List<WebElement> values;
    WebDriver driver;


    @BeforeTest
    public void setup() {
      /*
        System.setProperty("webdriver.chrome.driver",
                "chromedriver.exe");
        driver = new ChromeDriver();
       */
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }


    @AfterTest(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }



    @Test
    public void elmirTest()  {

        // System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        driver.get("https://elmir.ua/");

        driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    //  WebDriverWait wait = new WebDriverWait(driver,4);
        driver.manage().window().maximize();
       // WebElement alert = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("subscribe-deny")));
        WebElement alert = driver.findElement(By.id("subscribe-deny"));
        alert.click();
        Actions actions = new Actions(driver);

      //  WebElement Contacts = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class = 'ml-a pa' and text() = 'Контакты']")));
        WebElement Contacts = driver.findElement(By.xpath("//a[@class = 'ml-a pa' and text() = 'Контакты']"));
        // Contacts.click();
        actions.moveToElement(Contacts).build().perform();
        WebElement contacts2 = driver.findElement(By.xpath("//a[@class='ml-a' and @href='/contacts.html']"));
        contacts2.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://elmir.ua/contacts.html");
        /*
          driver.get("https://elmir.ua/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);
        WebElement deny = driver.findElement(By.xpath("//div[@id=\"subscribe-deny\"]"));
        deny.click();
        WebElement contacts = driver.findElement(By.xpath("//a[@class = \"ml-a pa\" and contains(text(),'Контакты')]"));
        contacts.click();
        WebElement goToContacts = driver.findElement(By.xpath("//a[@class = \"ml-a\" and contains(text(),'Контакты')]"));
        goToContacts.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://elmir.ua/contacts.html");
         */

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
