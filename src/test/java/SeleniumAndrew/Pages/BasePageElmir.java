package SeleniumAndrew.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePageElmir {

    public WebDriver driver;

    public BasePageElmir(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
}
