package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinRequestPasswordReset extends LinkedinBasePage {

    @FindBy(id ="username")
    private WebElement inputEmail;

    @FindBy(id = "reset-password-submit-button")
    private WebElement buttonSendEmail;

    public LinkedinRequestPasswordReset (WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public LinkedinRequestPasswordResetSubmitPage inputEmailOrPhone (String email) {
        gMailService.connect();
        inputEmail.sendKeys(email);
        buttonSendEmail.click();
        return new LinkedinRequestPasswordResetSubmitPage(webDriver);
    }

    public boolean isPageLoaded () {
        return inputEmail.isDisplayed() && buttonSendEmail.isDisplayed();
    }
}
