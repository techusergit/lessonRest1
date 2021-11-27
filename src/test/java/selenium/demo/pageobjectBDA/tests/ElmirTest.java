package selenium.demo.pageobjectBDA.tests;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.demo.pageobjectBDA.pages.ContactsPage;
import selenium.demo.pageobjectBDA.pages.LandingPage;

public class ElmirTest extends TestBase {



    @Test
    public void getToContactsPage() {
        LandingPage LandingPage = new LandingPage(driver);
        ContactsPage contactsPage = LandingPage.redirectToContactsPage();

    }

    @Test
    public void checkTheCallBackEmptyFieldValidation() {
        ContactsPage contactsPage = new ContactsPage(driver);
        contactsPage.openTheCallBackWindow();
        contactsPage.triggerTheCallBackEmptyFieldValidation();

    }
}
