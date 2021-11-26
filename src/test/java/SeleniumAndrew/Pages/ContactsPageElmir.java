package SeleniumAndrew.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactsPageElmir extends BasePage {

    static String pageUrl = "https://elmir.ua/contacts.html";

    public ContactsPageElmir(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "hphone")
    public WebElement phoneBtn;
    @FindBy(xpath = "//input[@class=\"button mw-submit\"]")
    public WebElement callBackBtn;
    @FindBy(xpath = "//div[@class=\"mw_error_text\"]")
    public WebElement alertText;

    public void clickPhoneBtn() {
        if(phoneBtn.isDisplayed())
            phoneBtn.click();
    }

    public void clickCallBackBtn() {
        if(callBackBtn.isDisplayed())
            callBackBtn.click();
    }

    public String getAlertText() {
        return alertText.getText();
    }

/*    public String clickCallBack() {

//        String parentHandle = driver.getWindowHandle();


//        String newHandle = driver.getWindowHandle();
//        driver.switchTo().window(newHandle);
        callBackBtn.isDisplayed();
        callBackBtn.click();
        alertText.isDisplayed();
        return alertText.getText();
    }*/
}
