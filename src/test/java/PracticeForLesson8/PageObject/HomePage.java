package PracticeForLesson8.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseTest {

    private WebDriver driver;

    @FindBy(id = "twotabsearchtextbox")
    private WebElement amazonSearchField;

    @FindBy(id = "nav-search-submit-button")
    private WebElement amazonSearchButton;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public HomePage enterNameOfBoots(String nameOfBoots) {
        amazonSearchField.clear();
        amazonSearchField.sendKeys(nameOfBoots);
        return this;
    }

    public SearchResultPage clickTheButtonSearch() {
        amazonSearchButton.click();
        return new SearchResultPage(driver);
    }


}
