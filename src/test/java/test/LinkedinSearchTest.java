package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.LinkedinHomePage;
import page.LinkedinSearchResualts;

import java.util.List;

public class LinkedinSearchTest extends LinkedinBaseTest{

    @Test
    public void basicSearchTest () {
        String searchTerm = "HR";

        LinkedinHomePage linkedinHomePage = linkedinLoginPage.login(
                "testeverad2@gmail.com","Veresmag14");
        Assert.assertTrue(linkedinHomePage.isPageLoaded(),
                "Login Page is not Loaded");

        LinkedinSearchResualts linkedinSearchResualts = linkedinHomePage.search(searchTerm);
        Assert.assertTrue(linkedinSearchResualts.isPageLoaded(),
                "Login Page is not Loaded");

        List<String> searchResualtsList = linkedinSearchResualts.getSearchResualts();
        Assert.assertEquals(searchResualtsList.size(), 10, "Count of search result items is wrong.");

        for (String searchResualt:searchResualtsList) {
            Assert.assertTrue(searchResualt.toLowerCase().contains(searchTerm.toLowerCase()),"Searchterm "+searchTerm+" was not found in: \n"+searchResualt);
        }

    }
}
