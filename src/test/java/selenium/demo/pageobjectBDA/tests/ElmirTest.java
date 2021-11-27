package selenium.demo.pageobjectBDA.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.demo.pageobjectBDA.assertions.AssertHelper;
import selenium.demo.pageobjectBDA.pages.ContactsPage;
import selenium.demo.pageobjectBDA.pages.LandingPage;



public class ElmirTest extends TestBase {

    private static final Logger LOG = LogManager.getLogger(ElmirTest.class.getName());


    @Test
    public void getToContactsPage() {
        driver.get("https://elmir.ua/");
        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickDenyAlert();
        landingPage.moveToContactsBtn();
        landingPage.clickContactsBtnInsideDropDownMenu();
        ContactsPage contactsPage = new ContactsPage(driver);

        AssertHelper.assertPageLoadedByTitleText(contactsPage.getSignOfPageLoadedTitleText(), "Контакты");

    //  Assert.assertEquals(driver.getCurrentUrl(), "https://elmir.ua/contacts.html");
        LOG.debug("Перехожу на Контакты страницу");
        LOG.info("тест пройден");
    }

    @Test
    public void checkTheCallBackEmptyFieldValidation() {
        driver.get("https://elmir.ua/contacts.html");
        ContactsPage contactsPage =
                new ContactsPage(driver).openTheCallBackWindow().callBackSubmitBtnClick();
        //contactsPage.openTheCallBackWindow();
        //contactsPage.triggerTheCallBackEmptyFieldValidation();
        //contactsPage.callBackSubmitBtnClick();
        AssertHelper.assertContactsMessage(contactsPage.getErrorMessage(), "Введите номер полностью, например,\n057-728-38-48");
        System.out.println("id 1 негативный тест на колбек филд - PASSED");
    }
}
