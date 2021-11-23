package PracticeForLesson8.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    @FindBy(id = "twotabsearchtextbox")
    private WebElement amazonSearchField;

    @FindBy(id = "nav-search-submit-button")
    private WebElement amazonSearchButton;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
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
