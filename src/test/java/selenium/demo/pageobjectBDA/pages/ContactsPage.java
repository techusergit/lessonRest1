package selenium.demo.pageobjectBDA.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.Assertion;

import java.util.List;
import java.util.Set;

public class ContactsPage {


    private WebDriver driver;

    public ContactsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "hphone" )
    private WebElement callBackBtn;
    @FindBy(id = "mw-window" )
    private WebElement callBackWindow;
    @FindBy(xpath = "//input[@class='button mw-submit']" )
    private WebElement callBackSubmit;
    @FindBy(xpath = "//div[@class='mw_error_text']" )
    private WebElement errorMessage;
    @FindBy(xpath = "//*[@id='page-title']")
    //полный кспас для тайтла - "//*[@id='page-title' and text()='Контакты']"
    private WebElement signOfPageLoadedTitleText;

    public ContactsPage openTheCallBackWindow() {

        callBackBtn.click();
        String window = driver.getWindowHandle(); //this will return all open windows
        driver.switchTo().window(window);
        return this;

    }

    public ContactsPage callBackSubmitBtnClick() {
        callBackSubmit.click();
        return this;
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public String getSignOfPageLoadedTitleText() {

        return signOfPageLoadedTitleText.getText();
    }

    /*    public ContactsPage triggerTheCallBackEmptyFieldValidation() {
        callBackSubmit.click();
        errorMessage.getText();
        Assert.assertEquals(errorMessage.getText(), "Введите номер полностью, например,\n057-728-38-48" );
        return this;
    }*/
}
