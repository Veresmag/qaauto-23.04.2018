import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LinkedinErrorPage extends LinkedinBasePage {
    private WebElement errorMessage;
    private WebElement forgotYorPassword;

    public LinkedinErrorPage(WebDriver webDriver) {
        super(webDriver);
        initElements();
    }

    public void initElements() {
        errorMessage = webDriver.findElement(By.xpath("//div [@role='alert']"));
        forgotYorPassword = webDriver.findElement(By.xpath("//div [@class='forgot-password-container'] //a"));
    }

    public String getTextErrorMessage() {
       return errorMessage.getText();
    }


    public String getforgotYorPassword () {
        return forgotYorPassword.getText();
    }
}
