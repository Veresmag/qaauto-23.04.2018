import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LinkedinErrorPage extends LinkedinBasePage {

    @FindBy (xpath ="//div [@role='alert']")
    private WebElement errorMessage;

    @FindBy (xpath ="//div [@class='forgot-password-container'] //a" )
    private WebElement forgotYorPassword;

    @FindBy (id = "session_key-login")
    private WebElement emailInput;

    @FindBy (id ="session_password-login" )
    private WebElement passwordInput;

    @FindBy (id ="btn-primary" )
    private WebElement buttonSignIn;

    public LinkedinErrorPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public void loginSubmitForm (String email, String password) {
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        buttonSignIn.click();
    }

    public String getTextErrorMessage() {
       return errorMessage.getText();
    }


    public String getforgotYorPassword () {
        return forgotYorPassword.getText();
    }


}
