package selenium.demo.pageobjectBDA.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.demo.pageobjectBDA.assertions.AssertHelper;
import selenium.demo.pageobjectBDA.pages.BasePage;
import selenium.demo.pageobjectBDA.pages.ContactsPage;
import selenium.demo.pageobjectBDA.pages.LandingPage;



public class ElmirTest extends TestBase {

  //  private static final Logger LOG = LogManager.getLogger(ElmirTest.class.getName());


    @Test
    public void getToContactsPage() {
        driver.get("https://elmir.ua/");
        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickDenyAlert();
        landingPage.moveToContactsBtn();
        landingPage.clickContactsBtnInsideDropDownMenu();
        ContactsPage contactsPage = new ContactsPage(driver);

        AssertHelper.assertPageLoadedByTitleText(contactsPage.getSignOfPageLoadedTitleText(), "Контакты");


        System.out.println("id 0 позитивный тест на переход на страницу контакты с LP страницы - PASSED");

        //что-то в потенциале касающееся логинга
    /*
        LOG.debug("Перехожу на Контакты страницу");
       LOG.info("тест пройден");
     */
    }

    @Test
    public void checkTheCallBackEmptyFieldValidation() throws InterruptedException {
        driver.get("https://elmir.ua/contacts.html");
        ContactsPage contactsPage = new ContactsPage(driver);
        contactsPage.openTheCallBackWindow();
        contactsPage.callBackSubmitBtnClick();
        AssertHelper.assertContactsMessage(contactsPage.getErrorMessage(), "Введите номер полностью, например,\n057-728-38-48");

        System.out.println("id 1 негативный тест на колбек филд - PASSED");
    }
}
