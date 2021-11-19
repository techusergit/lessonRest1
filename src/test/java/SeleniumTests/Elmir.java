package SeleniumTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Elmir {
    public WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\MyPrograms\\WebDriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void elmirTest() {
        driver.get("https://elmir.ua/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);
        WebElement deny = driver.findElement(By.xpath("//div[@id=\"subscribe-deny\"]"));
        deny.click();
        WebElement contacts = driver.findElement(By.xpath("//a[@class = \"ml-a pa\" and contains(text(),'Контакты')]"));
        contacts.click();
        WebElement goToContacts = driver.findElement(By.xpath("//a[@class = \"ml-a\" and contains(text(),'Контакты')]"));
        goToContacts.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://elmir.ua/contacts.html");

    }
}
