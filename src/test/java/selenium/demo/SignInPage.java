package selenium.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage {

    private WebDriver driver;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }


    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailField;
    @FindBy(xpath = "//input[@type='password']")
    private WebElement passswordField;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement logInSubmit;
}
