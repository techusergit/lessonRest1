package selenium.demo.pageobjectBDA.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;


public class LandingPage {

    private WebDriver driver;
    static String baseUrl = "https://elmir.ua/";
    //private final WebDriverWait wait = new WebDriverWait(driver, 10);

    @FindBy(id = "subscribe-deny" )
    private WebElement denyAlert;
    @FindBy(xpath = "//a[@class = 'ml-a pa' and text() = 'Контакты']" )
    private WebElement contactsBtn;
    @FindBy(xpath = "//a[@class='ml-a' and @href='/contacts.html']" )
    private WebElement contactsBtnInsideDropDownMenu;

    public LandingPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public ContactsPage redirectToContactsPage() {
        driver.get(baseUrl);
        denyAlert.click();
        Actions actions = new Actions(driver);
        actions.moveToElement(contactsBtn).build().perform();
        contactsBtnInsideDropDownMenu.click();

  //    wait.until(visibilityOfElementLocated(By.id("page-title"))); //асертим что мы на странице
        return new ContactsPage(driver);
    }



}