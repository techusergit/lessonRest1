package SeleniumAndrew.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPageElmir extends BasePage {

    public MainPageElmir(WebDriver driver) {
        super(driver);
    }

    public static final String MAIN_PAGE_URL = "https://elmir.ua/";

    @FindBy(xpath = "//div[@id=\"subscribe-deny\"]")
    private WebElement denyAlert;
    @FindBy(xpath = "//a[@class = \"ml-a pa\" and contains(text(),'Контакты')]")
    private WebElement contactsBtn;
    @FindBy(xpath = "//a[@class = \"ml-a\" and contains(text(),'Контакты')]")
    private WebElement contactsBtnDropDown;

    public MainPageElmir clickDenyAlert() {
        denyAlert.click();
        return this;
    }

    public void clickContactsBtn() {
        contactsBtn.click();
    }
    //TODO: wait!!!
    public ContactsPageElmir clickContactsBtnDropDown() {
        contactsBtnDropDown.click();
        return PageFactory.initElements(driver, ContactsPageElmir.class);
    }


}