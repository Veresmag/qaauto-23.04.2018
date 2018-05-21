import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LinkedinErrorPage {
    private WebDriver webDriver;
    private WebElement errorMessage;
    private WebElement forgotYorPassword;

    public LinkedinErrorPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        initElements();
    }

    public void initElements() {
        errorMessage = webDriver.findElement(By.xpath("//div [@role='alert']"));
        forgotYorPassword = webDriver.findElement(By.xpath("//div [@class='forgot-password-container'] //a"));
    }

    public String getTextErrorMessage() {
       return errorMessage.getText();
    }

    public String getCurrentUrl (){
        return webDriver.getCurrentUrl();
    }

    public String getCurrentTittle (){
        return webDriver.getTitle();
    }

    public String getforgotYorPassword () {
        return forgotYorPassword.getText();
    }
}
