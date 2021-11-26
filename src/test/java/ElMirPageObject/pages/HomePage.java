package ElMirPageObject.pages;

import ElMirPageObject.pages.BasePage;
import ElMirPageObject.pages.ContactsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {

    WebDriverWait wait;

    @FindBy(xpath = "(//li/a[@class='ml-a pa'])[2]")
    private WebElement elMirContactsMenu;

    @FindBy(xpath = "//ul[@class='submenu']/li/a[@href ='/contacts.html']")
    private WebElement getElMirContactsItemInMenuContacts;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void moveToMenuContacts() {
        waitElementClickableMethod(elMirContactsMenu, wait);
        moveToElementMethod(elMirContactsMenu);
    }

    public ContactsPage clickOnElementAndGotoContactsPage() {
        waitElementClickableMethod(getElMirContactsItemInMenuContacts, wait);
        getElMirContactsItemInMenuContacts.click();
        return new ContactsPage(driver);
    }

    public void waitForPageLoad(){
        waitForLoad(elMirContactsMenu, wait);
    }

}
