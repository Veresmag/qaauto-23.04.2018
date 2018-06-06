package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class LinkedinSearchResualts extends LinkedinBasePage{

    @FindBy (xpath = "//li[contains(@class, 'search-result__occluded-item')]")
    private List<WebElement> searchResults;

    @FindBy (xpath = "//ul[@class='search-vertical-filter__filters-list list-style-none display-flex']" )
    private WebElement searchVerticalFilter;


    public LinkedinSearchResualts(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
        waitUntilElementIsVisible(searchVerticalFilter, 5);
    }

    public List<String> getSearchResualts() {
        List<String> searchResultsList = new ArrayList();
        for (WebElement searchResult:searchResults) {
            ((JavascriptExecutor)webDriver).executeScript(
                    "arguments[0].scrollIntoView();", searchResult);

            String searchResultText = searchResult.getText();
            searchResultsList.add(searchResultText);
        }
        System.out.println(searchResultsList);
        System.out.println(searchResultsList.size());
        return searchResultsList;
    }

    public boolean isPageLoaded() {
        return searchVerticalFilter.isDisplayed();
    }
}


