package PracticeForLesson8.PageObject;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PageObjectAmazonTests extends BaseTest {

    @Test
    public void testAmazonSearch() {

        // Open the site
        driver.get("https://www.amazon.com/");

        // Create a Home Page - Page Object instance
        HomePage homePage = new HomePage(driver);

        //Use a HomePage instance method
        homePage.enterNameOfBoots("boots men");

        // Return the searchResultPage instance
        SearchResultPage searchResultPage = homePage.clickTheButtonSearch();

        // Compare actual and expected names of boots
        Assert.assertEquals(searchResultPage.getNameOfBoots(), "Amazn Essentials Men's Round Toe Lace-up Boot Hiking Shoe");

        // Compare actual and expected prices of boots
        Assert.assertEquals(searchResultPage.getPriceOfBoots(), "44");

    }

}
