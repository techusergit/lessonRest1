package selenium.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {

    private WebDriver driver;
    private String baseUrl = "chess.com";

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }


     @FindBy(xpath = "//a[@class='button auth login ui_v5-button-component ui_v5-button-primary']" )
        private WebElement signInPage;


    public void redirectingToSignIn() {
        driver.get(baseUrl);
      //  driver.findElement(signInPage).click();
    }





}
