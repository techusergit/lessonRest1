package SeleniumAndrew.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPageElmir extends BasePageElmir {

    public MainPageElmir(WebDriver driver) {
        super(driver);
    }

    static String pageUrl = "https://elmir.ua/";

    @FindBy(xpath = "//div[@id=\"subscribe-deny\"]")
    private WebElement denyAlert;
    @FindBy(xpath = "//a[@class = \"ml-a pa\" and contains(text(),'Контакты')]")
    private WebElement contactsBtn;
    @FindBy(xpath = "//a[@class = \"ml-a\" and contains(text(),'Контакты')]")
    private WebElement contactsBtnDropDown;


    public ContactsPageElmir goToContactsPage() {
        driver.get(pageUrl);
        denyAlert.click();
        contactsBtn.click();
        contactsBtnDropDown.click();

        return new ContactsPageElmir(driver);
    }


}