package selenium.demo.pageobjectBDA.assertions;

import org.testng.Assert;

public class AssertHelper {
    private AssertHelper() {
    }

    public static void assertContactsMessage(String actual, String expected){
        Assert.assertEquals(actual, expected);
    }
}
