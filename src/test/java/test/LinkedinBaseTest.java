package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page.LinkedinLoginPage;

public class LinkedinBaseTest {
    WebDriver webDriver;
    LinkedinLoginPage linkedinLoginPage;

    @BeforeMethod
    public void before() {
        WebDriverManager.firefoxdriver().setup();
        webDriver = new FirefoxDriver();
        webDriver.get("https://www.linkedin.com/");
        linkedinLoginPage = new LinkedinLoginPage(webDriver);
    }

    @AfterMethod
    public void after() {
        webDriver.close();
    }

    public WebElement waitUntilElementIsClickable(WebElement webElement, int timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(webDriver, timeOutInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        return webElement;
    }

    public WebElement waitUntilElementIsVisible(WebElement webElement, int timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(webDriver, timeOutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(webElement));
        return webElement;
    }
}
