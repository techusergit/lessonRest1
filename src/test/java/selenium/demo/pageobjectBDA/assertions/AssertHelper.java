package selenium.demo.pageobjectBDA.assertions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class AssertHelper {
    private AssertHelper() {
    }

    public static void assertContactsMessage(String actual, String expected) {
        Assert.assertEquals(actual, expected);
    }

    public static void assertPageLoadedByTitleText(String actual, String expected) {
        Assert.assertEquals(actual, expected);
    }

}