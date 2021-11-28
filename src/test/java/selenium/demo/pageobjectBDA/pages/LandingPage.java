package selenium.demo.pageobjectBDA.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;


public class LandingPage extends BasePage{

    private WebDriver driver;
    static String baseUrl = "https://elmir.ua/";
    Actions actions;
    WebDriverWait wait;
    //private final WebDriverWait wait = new WebDriverWait(driver, 10);
    @FindBy(xpath = "//*[@id='basket-prompt']")
    private WebElement alert;
    @FindBy(id = "subscribe-deny" )
    private WebElement denyAlert;
    @FindBy(xpath = "//a[@class = 'ml-a pa' and text() = 'Контакты']" )
    private WebElement contactsBtn;
    @FindBy(xpath = "//a[@class='ml-a' and @href='/contacts.html']" )
    private WebElement contactsBtnInsideDropDownMenu;
    @FindBy(xpath = "//*[@id='page-title']")
    private WebElement title;


    public LandingPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.actions = new Actions(driver);
    }


    public void clickDenyAlert() {
        waitForLoad(alert, wait);
         denyAlert.click();
    }

    public void moveToContactsBtn() {
        waitForLoad(contactsBtn, wait);
        actions.moveToElement(contactsBtn).build().perform();
        //    wait.until(visibilityOfElementLocated(By.id("page-title"))); //асертим что мы на странице
    }

    public void clickContactsBtnInsideDropDownMenu() {
        waitElementClickableMethod(contactsBtnInsideDropDownMenu, wait);
        contactsBtnInsideDropDownMenu.click();
    }

}