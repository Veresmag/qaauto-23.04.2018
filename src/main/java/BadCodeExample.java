import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

import static java.lang.Thread.sleep;

public class BadCodeExample {

    public static void main(String args[]) throws InterruptedException {
        System.out.println("Hello world!!!");

        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("https://www.google.com/");

        WebElement searchFeald = webDriver.findElement(By.id("lst-ib"));
        searchFeald.sendKeys("Selenium");

        sleep (1000) ;

//        WebElement searchButtom =
//                webDriver.findElement(By.xpath("//input[@type='button' and contains (@value, 'Google')]"));
//
//            searchButtom.click();

        searchFeald.sendKeys(Keys.ENTER);

        sleep(4000);

        List<WebElement> searchResults = webDriver.findElements(By.xpath("//div [@class='srg'] /div [@class='g']"));

        System.out.println(searchResults.size());

        for (WebElement searchResult : searchResults) {
           String searchResultText = searchResult.getText();
            if (searchResultText.contains("Selenium")) {
                System.out.println("SearchTerm found!!");
            }
            System.out.println(searchResultText);
        }

//        for (int i = 1; i<=10; i++) {
//            WebElement searchResult = webDriver.findElement(By.xpath("//div [@class='srg'] /div [" + i + "]"));
//            String searchResultText = searchResult.getText();
//            if (searchResultText.contains("Selenium")) {
//                System.out.println("SearchTerm found!!");
//            }
//            System.out.println(searchResultText);
//        }

        webDriver.navigate().back();

        sleep (3000) ;
        webDriver.close();
    }
}

//div [@class='srg'] //div [@class='g']

//        By.ByXPath driver = null;
//        WebElement userName = driver.findElement((SearchContext) By.xpath("//div [@class='srg'] //div [@class='g']*[text()='Selenium']/.."));
//        By.ByClassName driver = null;
//        List elementList = driver.findElements ((SearchContext) By.xpath("//div [@class='srg'] //div [@class='g']"));
//        By.ByClassName driver = null;
//        List<WebElement> imagesWithAlt = driver.findElements((SearchContext) By.xpath ("//div [@class='srg'] //div [@class='g']"));
//        By.ByClassName driver = null;
//        List<WebElement> elements =
//                driver.findElements((SearchContext) By.xpath("//div [@class='srg'] //div [@class='g']"));
//        WebElement searchGoogle =
//                ((FirefoxDriver) webDriver).findElementByXPath("//div [@class='srg'] //div [@class='g']");