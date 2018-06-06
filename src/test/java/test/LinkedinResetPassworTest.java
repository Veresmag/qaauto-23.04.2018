package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.*;

public class LinkedinResetPassworTest extends LinkedinBaseTest{

    @Test
    public void successfullPasswordResetTest(){
        String userEmail = "testeverad2@gmail.com";
        String newUserPassword = "everad123";

        LinkedinRequestPasswordReset linkedinRequestPasswordReset = linkedinLoginPage.setForgotYourPassword();
        Assert.assertTrue(linkedinRequestPasswordReset.isPageLoaded(), "RequestPasswordResetPage is not loaded!");

        LinkedinRequestPasswordResetSubmitPage linkedinRequestPasswordResetSubmitPage =
                linkedinRequestPasswordReset.inputEmailOrPhone(userEmail);

//        Assert.assertTrue(linkedinRequestPasswordResetSubmitPage.isPageLoaded(),
//                "RequestPasswordResetSubmitPage is not loaded!");

        LinkedinSetNewPasswordPage linkedinSetNewPasswordPage = linkedinRequestPasswordResetSubmitPage.navigateToLinkFromEmail();
//        Assert.assertTrue(linkedinSetNewPasswordPage.isPageLoaded, "SetNewPasswordPage is not loaded!");

        LinkedinSuccesfulPasswordResetPage linkedinSuccesfulPasswordResetPage = linkedinSetNewPasswordPage.submitNewPassword(newUserPassword);
//        Assert.assertTrue(linkedinSuccesfulPasswordResetPage.isPageLoaded, "SuccesfulPasswordResetPage is not loaded!");

        LinkedinHomePage linkedinHomePage = linkedinSuccesfulPasswordResetPage.clickOnGoToHomeButton();
//        Assert.assertTrue(linkedinHomePage.isPageLoaded, "HomePage is not loaded!");
    }
}
