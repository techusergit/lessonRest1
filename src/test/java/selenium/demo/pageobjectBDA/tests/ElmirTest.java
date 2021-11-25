package selenium.demo.pageobjectBDA.tests;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.demo.pageobjectBDA.assertions.AssertHelper;
import selenium.demo.pageobjectBDA.pages.ContactsPage;
import selenium.demo.pageobjectBDA.pages.LandingPage;

public class ElmirTest extends TestBase {



    @Test
    public void getToContactsPage() {
        LandingPage LandingPage = new LandingPage(driver);
        ContactsPage contactsPage = LandingPage.redirectToContactsPage();

    //  Assert.assertEquals(driver.getCurrentUrl(), "https://elmir.ua/contacts.html");
    }

    @Test
    public void checkTheCallBackEmptyFieldValidation() {
        ContactsPage contactsPage =
                new ContactsPage(driver).openTheCallBackWindow().callBackSubmitBtnClick();
        //contactsPage.openTheCallBackWindow();
        //contactsPage.triggerTheCallBackEmptyFieldValidation();
        //contactsPage.callBackSubmitBtnClick();
        AssertHelper.assertContactsMessage(contactsPage.getErrorMessage(), "Введите номер полностью, например,\n057-728-38-48");

    }
}
