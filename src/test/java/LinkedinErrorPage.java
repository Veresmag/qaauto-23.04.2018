import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LinkedinErrorPage extends LinkedinBasePage {

    @FindBy (xpath ="//div [@role='alert']")
    private WebElement errorMessage;

    @FindBy (xpath ="//div [@class='forgot-password-container'] //a" )
    private WebElement forgotYorPassword;

    public LinkedinErrorPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    boolean isPageLoaded() {
        return false;
    }

    public String getTextErrorMessage() {
       return errorMessage.getText();
    }


    public String getforgotYorPassword () {
        return forgotYorPassword.getText();
    }


}
