package SeleniumAndrew.Test;

import SeleniumAndrew.Pages.ContactsPageElmir;
import SeleniumAndrew.Pages.MainPageElmir;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ContactsTestElmir extends BaseTestElmir {

    MainPageElmir mainPageElmir;
    ContactsPageElmir contactsPageElmir;

    @BeforeTest
    public void prepereData() {
        mainPageElmir = new MainPageElmir(driver);
    }

    @Test
    public void testContactBtn() {
        contactsPageElmir = mainPageElmir.goToContactsPage();
        Assert.assertEquals(driver.getCurrentUrl(), "https://elmir.ua/contacts.html");
//        contactsPageElmir.phoneBtn.click();
//        Assert.assertTrue(contactsPageElmir.callBackBtn.isDisplayed());
//        contactsPageElmir.callBackBtn.click();
//        Assert.assertTrue(contactsPageElmir.alertText.isDisplayed());
//        System.out.println(contactsPageElmir.alertText.getText());
        Assert.assertEquals(contactsPageElmir.clickCallBack(), "Введите номер полностью, например,\n" +
                "057-728-38-48");
    }
}
