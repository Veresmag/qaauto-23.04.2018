import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class LinkedinBasePage {
    protected WebDriver webDriver;

    public LinkedinBasePage (WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String getCurrentUrl (){
        return webDriver.getCurrentUrl();
    }

    public String getCurrentTittle (){
        return webDriver.getTitle();
    }

    abstract boolean isPageLoaded();
    
    public WebElement waitUntilElementIsClickable (WebElement webElement, int timeOutinSeconds){
        WebDriverWait wait = new WebDriverWait(webDriver, timeOutinSeconds);
        wait.until(ExpectedCondition.elementToBeClickable(webElement));
        return webElement;
    }
}
