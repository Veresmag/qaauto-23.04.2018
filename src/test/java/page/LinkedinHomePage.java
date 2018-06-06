package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinHomePage extends LinkedinBasePage {

    public boolean isPageLoaded;
    @FindBy (xpath = "//li[@id='profile-nav-item']")
    private WebElement profileNavItem;

    @FindBy(xpath = "//input[@role='combobox']")
    private WebElement searchField;

    public LinkedinHomePage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
        waitUntilElementIsVisible(profileNavItem, 10);
        waitUntilElementIsClickable(searchField, 20);
    }

    public boolean isPageLoaded() {
        return profileNavItem.isDisplayed();
    }

    public LinkedinSearchResualts search(String searchTerm){
        searchField.sendKeys(searchTerm);
        searchField.sendKeys(Keys.ENTER);
        return new LinkedinSearchResualts(webDriver);
    }
}
