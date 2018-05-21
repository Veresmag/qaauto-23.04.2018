import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class LinkedinLoginTest {
    WebDriver webDriver;

    @BeforeMethod
    public void before (){
        webDriver = new FirefoxDriver();
        webDriver.get("https://www.linkedin.com/");
    }

    @Test
    public void successfulLoginTest() throws InterruptedException {

        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);

        Assert.assertEquals(linkedinLoginPage.getCurrentTittle(),
                "LinkedIn: Войти или зарегистрироваться",
                "Login page Title is wrong");

        Assert.assertEquals(linkedinLoginPage.getCurrentUrl(),
                "https://www.linkedin.com/",
                "The link is not correct");

        Assert.assertTrue(linkedinLoginPage.isSighInButtonDisplayed(),
                "Sign button is not Displayed");

        linkedinLoginPage.login("Veresmag@yandex.ru","Veresmag14");

        LinkedinHomePage linkedinHomePage = new  LinkedinHomePage (webDriver);

        Assert.assertEquals(linkedinHomePage.getCurrentTittle(),
                "Проверка безопасности | LinkedIn",
                "Login page Title is wrong");

    }


    @Test
    public void negativeLoginTest() throws InterruptedException {

        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);

        Assert.assertEquals(linkedinLoginPage.getCurrentTittle(),
                "LinkedIn: Войти или зарегистрироваться",
                "Login page Title is wrong");

        Assert.assertTrue(linkedinLoginPage.isSighInButtonDisplayed(),
                "Sign button is not Displayed");

        linkedinLoginPage.login("Veresmag@yandex.ru","1");

        sleep(3000);

        LinkedinErrorPage linkedinErrorPage = new LinkedinErrorPage(webDriver);

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
    public void negativeRegistrationTest(){
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
        linkedinLoginPage.login("Veresmag@yandex.ru","1");

        LinkedinErrorPage linkedinErrorPage = new LinkedinErrorPage(webDriver);
        Assert.assertEquals(linkedinErrorPage.getforgotYorPassword(),
                "Забыли пароль?",
                "Missing 'Forgot Password' button");
    }

    @Test
    public void negativWillJoinTestName(){
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
        linkedinLoginPage.joinButton();

        Assert.assertEquals(linkedinLoginPage.getAllertContentMassage(),
                "Укажите имя",
                "There is no inscription about incorrect filling in the registration form" );

    }

    @Test
    public void negativWillJoinTest() {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
        linkedinLoginPage.loginRegistration("Zorro");

        Assert.assertEquals(linkedinLoginPage.getAllertContentMassage(),
                "Укажите фамилию",
                "There is no inscription about incorrect filling in the registration form" );
    }

    @Test
    public void negativInputForm () {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
        linkedinLoginPage.login("Veresmag14","Veresmag@yandex.ru");

        Assert.assertEquals(linkedinLoginPage.getCurrentUrl(),
                "https://www.linkedin.com/uas/login-submit",
                "The link is not correct");
    }

    @AfterMethod
    public void after () {
        webDriver.close();
    }
}