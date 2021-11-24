package ElMirPageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    @FindBy(xpath = "(//li/a[@class='ml-a pa'])[2]")
    private WebElement elMirContactsMenu;

    @FindBy(xpath = "//ul[@class='submenu']/li/a[@href ='/contacts.html']")
    private WebElement getElMirContactsItemInMenuContacts;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void moveToMenuContacts() {
        waitElementClickableMethod(elMirContactsMenu);
        moveToElementMethod(elMirContactsMenu);
    }

    public ContactsPage clickOnElementAndGotoContactsPage() {
        waitElementClickableMethod(getElMirContactsItemInMenuContacts);
        getElMirContactsItemInMenuContacts.click();
        return new ContactsPage(driver);
    }


}
