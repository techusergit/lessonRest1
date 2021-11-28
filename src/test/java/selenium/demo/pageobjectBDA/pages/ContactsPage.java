package selenium.demo.pageobjectBDA.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.Assertion;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class ContactsPage extends BasePage {


    private WebDriver driver;
    WebDriverWait wait;

    public ContactsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
        waitElementClickableMethod(callBackBtn, wait);
        callBackBtn.click();
       // waitForLoad(callBackWindow, wait);
        String window = driver.getWindowHandle(); //this will return all open windows
        driver.switchTo().window(window);
        return this;
    }

    public ContactsPage callBackSubmitBtnClick() {
        waitElementClickableMethod(callBackSubmit, wait);
        callBackSubmit.click();
        return this;
    }

    public String getErrorMessage() {
        waitForLoad(errorMessage, wait);
        return errorMessage.getText();
    }

    public String getSignOfPageLoadedTitleText() {
        waitForLoad(signOfPageLoadedTitleText, wait);
        return signOfPageLoadedTitleText.getText();
    }
}
