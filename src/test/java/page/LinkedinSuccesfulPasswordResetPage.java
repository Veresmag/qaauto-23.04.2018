package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinSuccesfulPasswordResetPage extends LinkedinBasePage{
    public boolean isPageLoaded;

    @FindBy(id = "reset-password-submit-button")
    private WebElement goHomeButton;

    public LinkedinSuccesfulPasswordResetPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public LinkedinHomePage clickOnGoToHomeButton() {
        goHomeButton.click();
        return new LinkedinHomePage(webDriver);
    }
}
