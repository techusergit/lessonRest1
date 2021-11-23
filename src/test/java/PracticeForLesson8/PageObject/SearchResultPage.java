package PracticeForLesson8.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage extends BaseTest {

    public String nameOfBoots;
    public String priceOfBoots;

    @FindBy(xpath = "(//a//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]")
    private WebElement amazonTimberlandBootName;

    @FindBy(xpath = "(//span[@class='a-price-whole'])[1]")
    private WebElement amazonTimberlandBootPrice;


    public SearchResultPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String getNameOfBoots() {
        waitElementVisible(amazonTimberlandBootName);
        nameOfBoots = amazonTimberlandBootName.getText();
        return nameOfBoots;
    }

    public String getPriceOfBoots() {
        waitElementVisible(amazonTimberlandBootPrice);
        priceOfBoots = amazonTimberlandBootPrice.getText();
        return priceOfBoots;
    }
}
