package ElMirPageObject.pages;

import ElMirPageObject.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactsPage extends BasePage {

    protected String winHandleBefore;
    WebDriverWait wait;

    @FindBy(id = "hphone")
    private WebElement iconOfSupportNumber;

    @FindBy(xpath = "//input[@class='button mw-submit']")
    private WebElement buttonMakeACallIntoAlert;

    @FindBy(xpath = "//div[@class='mw_error_text']")
    private WebElement validationErrorIntoAlert;


    public ContactsPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void clickTheButtonCallToSupport() {
        iconOfSupportNumber.click();
    }

    public void switchToAlert() throws Exception {
        winHandleBefore = driver.getWindowHandle();

        // Switch to new window opened
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
    }

    public void clickOnTheCallButtonIntoAlert() {
        waitElementClickableMethod(buttonMakeACallIntoAlert, wait);
        buttonMakeACallIntoAlert.click();
    }

    public String getValidationErrorIntoAlert() {
        waitElementClickableMethod(validationErrorIntoAlert, wait);
        return validationErrorIntoAlert.getText();
    }
}
