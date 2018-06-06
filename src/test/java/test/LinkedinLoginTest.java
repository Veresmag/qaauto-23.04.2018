package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.LinkedinErrorPage;
import page.LinkedinHomePage;
import page.LinkedinLoginPage;
import page.LinkedinRequestPasswordReset;
import util.GMailService;


public class LinkedinLoginTest extends LinkedinBaseTest {

    @DataProvider
    public Object[][] validDataProvider() {
        return new Object[][]{
                {"Veresmag@yandex.ru", "Veresmag14"},
//                {"VERESMAG@YANDEX.RU", "Veresmag14"},
        };
    }

    @Test(dataProvider = "validDataProvider")
    public void successfulLoginTest(String email, String password) {
        Assert.assertEquals(linkedinLoginPage.getCurrentTittle(),
                "LinkedIn: Войти или зарегистрироваться",
                "Login page Title is wrong");

        Assert.assertEquals(linkedinLoginPage.getCurrentUrl(),
                "https://www.linkedin.com/",
                "The link is not correct");

        Assert.assertTrue(linkedinLoginPage.isPageLoaded(),
                "Login Page is not Loaded");

        LinkedinHomePage linkedinHomePage = linkedinLoginPage.login(email, password);

        Assert.assertEquals(linkedinHomePage.getCurrentTittle(),
                "LinkedIn",
                "Login page Title is wrong");

        Assert.assertEquals(linkedinHomePage.getCurrentUrl(),
                "https://www.linkedin.com/feed/",
                "The link is not correct");
    }

    @Test
    public void negativeReturnedToLoginSubmitTest() {

        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);

        Assert.assertEquals(linkedinLoginPage.getCurrentTittle(),
                "LinkedIn: Войти или зарегистрироваться",
                "Login page Title is wrong");

        Assert.assertTrue(linkedinLoginPage.isPageLoaded(),
                "Login Page is not Loaded");

        LinkedinErrorPage linkedinErrorPage = linkedinLoginPage.loginSubmitPage("Veresmag@yandex.ru", "1");

        Assert.assertEquals(linkedinErrorPage.getCurrentUrl(),
                "https://www.linkedin.com/uas/login-submit",
                "Login-Sumbit page url is wrong");
        Assert.assertEquals(linkedinErrorPage.getCurrentTittle(),
                "Войти в LinkedIn",
                "Login-Sumbit page title is wrong");

        Assert.assertEquals(linkedinErrorPage.getTextErrorMessage(),
                "При заполнении формы были допущены ошибки. Проверьте и исправьте отмеченные поля.",
                "Wrong error message text displayed");
    }

    @Test
    public void negativeRegistrationTest() {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
        LinkedinErrorPage linkedinErrorPage = linkedinLoginPage.loginSubmitPage("Veresmag@yandex.ru", "1");
        Assert.assertEquals(linkedinErrorPage.getforgotYorPassword(),
                "Забыли пароль?",
                "Missing 'Forgot Password' button");
    }

    @Test
    public void negativWillJoinNameTest() {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
        linkedinLoginPage.joinButton();

        Assert.assertEquals(linkedinLoginPage.getAllertContentMassage(),
                "Укажите имя",
                "There is no inscription about incorrect filling in the registration form");

    }

    @Test
    public void negativWillJoinTest() {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
        linkedinLoginPage.loginRegistration("Zorro");

        Assert.assertEquals(linkedinLoginPage.getAllertContentMassage(),
                "Укажите фамилию",
                "There is no inscription about incorrect filling in the registration form");
    }

    @Test
    public void negativInputFormTest() {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
        linkedinLoginPage.login("Veresmag14", "Veresmag@yandex.ru");

        Assert.assertEquals(linkedinLoginPage.getCurrentUrl(),
                "https://www.linkedin.com/uas/login-submit",
                "The link is not correct");
    }

    @DataProvider
    public Object[][] validNegativLoginProvider() {
        return new Object[][]{
                {"", "Veresmag14"},
                {"Veresmag@yandex.ru", ""},
                {"", ""}
        };
    }

    @Test(dataProvider = "validNegativLoginProvider")
    public void negativeLoginSubmitTest(String email, String password) {

        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);

        Assert.assertEquals(linkedinLoginPage.getCurrentTittle(),
                "LinkedIn: Войти или зарегистрироваться",
                "Login page Title is wrong");

        Assert.assertTrue(linkedinLoginPage.isPageLoaded(),
                "Login Page is not Loaded");

        linkedinLoginPage.login(email, password);

        Assert.assertEquals(linkedinLoginPage.getCurrentUrl(),
                "https://www.linkedin.com/",
                "This link is not correct");
    }

    @DataProvider
    public Object[][] validNegativRegistrationProvider() {
        return new Object[][]{
                {"Ярослав", "","Veresmag@yandex.ru",""},
                {"", "Козик","","666666"},
                {"Ярослав", "","","666666"},
                {"","Козик","Veresmag@yandex.ru","666666"},
                {"Ярослав", "","Veresmag@yandex.ru","666666"},
                {"","","",""}
        };
    }

    @Test (dataProvider = "validNegativRegistrationProvider")
    public void negativeRegistrationTest2(String name, String lastName, String email, String password ) {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
        linkedinLoginPage.formRegistration(name, lastName, email, password);

        Assert.assertEquals(linkedinLoginPage.getCurrentUrl(),
                "https://www.linkedin.com/",
                "The link is not correct");
    }

    @DataProvider
    public Object[][] validLoginSubmitProvider() {
        return new Object[][]{
                {"", "Veresmag"},
                {"Veresmag@yandex.ru", ""},
                {"", ""}
        };
    }

    @Test (dataProvider = "validLoginSubmitProvider")
    public void negativLoginSubmitForm (String email, String password){
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);

        LinkedinErrorPage linkedinErrorPage = linkedinLoginPage.loginSubmitPage(email, password);

        Assert.assertEquals(linkedinErrorPage.getCurrentUrl(),
                "https://www.linkedin.com/",
                "The link is not correct");
    }

    @Test
    public void successResetPasswordTest () {
        LinkedinRequestPasswordReset linkedinRequestPasswordReset = linkedinLoginPage.setForgotYourPassword();

        GMailService gMailService = new GMailService("testeverad2@gmail.com","everad123");
        gMailService.connect();

        linkedinRequestPasswordReset.inputEmailOrPhone("testeverad2@gmail.com");

    }

}