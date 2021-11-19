package SeleniumTests;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Amazon {
    public WebDriver driver;

    @BeforeTest
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "/home/user/projects/common/study_plan/workspace/lessonRest1/src/test/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterTest()
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void amazonTest(){
        driver.get("https://www.amazon.com");
        WebElement element = driver.findElement(By.id("twotabsearchtextbox"));
        element.sendKeys("Man shoes");
        element.submit();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.amazon.com/s?k=Man+shoes&ref=nb_sb_noss");

        List<WebElement> list = driver.findElements(By.xpath("//div[@class='a-section a-spacing-medium']"));
        List<Shoe> shoes = new ArrayList<>();

        //driver.getPageSource();

        list.forEach(el -> {
            try {
                Shoe shoe = new Shoe(el.findElement(By.xpath(".//span[contains(@class,'a-text-normal')]")).getText(),
                        el.findElement(By.xpath(".//span[contains(@class,'a-price')]/span")).getAttribute("innerText"));
                shoes.add(shoe);
            } catch (NoSuchElementException e) {
                e.printStackTrace();
            }
        });

        System.out.println(shoes);



//        list.get(0).findElement(By.xpath(".//span[contains(@class,'a-text-normal')]")).getText();
//        list.get(0).findElement(By.xpath(".//span[contains(@class,'a-price')]/span")).getAttribute("innerText");


/*        List<WebElement> shoes = driver.findElements(By.xpath("//span[@class =\"a-price-whole\"]"));
        Map <String, String> map = new HashMap<String, String>();
//           for (WebElement elem : shoes){
//               map.put(elem.getText(), )
//            }
         int i = Integer.parseInt(shoes.get(0).getText());
         System.out.println(i);
*/

//        for (int i= 0; i < shoes.size(); i++){
//            System.out.println(shoes.get(i).getText());
//        }
        //span[@class ="a-size-base-plus a-color-base a-text-normal"]
////span[@class ="a-price-whole"]/../../../../../..//span[@class ="a-size-base-plus a-color-base a-text-normal"]

    }

    class Shoe {
        private String name;
        private String price;

        public Shoe(String name, String price) {
            this.name = name;
            this.price = price;
        }
    }

}
