package ElMirPageObject.test.elmir;

import ElMirPageObject.pages.ContactsPage;
import ElMirPageObject.pages.HomePage;
import ElMirPageObject.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidationMobileNumberTest extends BaseTest {

    @Test
    public void openContactsItemMenu() throws Exception {

        driver.get("https://elmir.ua/");

        // Create a HomePage instance
        HomePage homePage = new HomePage(driver);
        homePage.waitForPageLoad();
        homePage.moveToMenuContacts();

        // Call the ContactPage instance
        ContactsPage contactsPage = homePage.clickOnElementAndGotoContactsPage();

        // Click the button: 'Call' on Contacts page
        contactsPage.clickTheButtonCallToSupport();

        // Switch focus to the Contacts Alert
        contactsPage.switchToAlert();
        contactsPage.clickOnTheCallButtonIntoAlert();

        Assert.assertEquals(contactsPage.getValidationErrorIntoAlert(), "Введите номер полностью, например,\n" +
                "057-728-38-41");

    }
}
