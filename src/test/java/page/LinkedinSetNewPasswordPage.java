package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

public class LinkedinSetNewPasswordPage extends LinkedinBasePage {


    public boolean isPageLoaded;


    @FindBy (id = "newPassword")
    private WebElement newPassword;

    @FindBy (id = "confirmPassword")
    private WebElement confimNewPassword;

    @FindBy (id = "reset-password-submit-button")
    private WebElement submitResetPasswordButton;

    public LinkedinSetNewPasswordPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public boolean isPageLoaded() throws InterruptedException {
        sleep (5000);
//        waitUntilElementIsVisible(newPassword,50);
        return newPassword.isDisplayed();
    }

    public LinkedinSuccesfulPasswordResetPage submitNewPassword(String newUserPassword) {
        newPassword.sendKeys(newUserPassword);
        confimNewPassword.sendKeys(newUserPassword);
        submitResetPasswordButton.click();
        return new LinkedinSuccesfulPasswordResetPage (webDriver);
    }
}
