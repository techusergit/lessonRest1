package ElMirPageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected Actions action;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        action = new Actions(driver);
    }

    public void waitElementClickableMethod(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void moveToElementMethod(WebElement element) {
        action.moveToElement(element).build().perform();
    }


}
