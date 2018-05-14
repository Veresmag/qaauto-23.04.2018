import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class LinkedinLoginTest {

    @Test
    public void successfulLoginTest() throws InterruptedException {
        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("https://www.linkedin.com/");

//        Assert.assertEquals("a","b","Probably 'a' is not equal to 'b' ");

        Assert.assertEquals(webDriver.getTitle(),
                "LinkedIn: Войти или зарегистрироваться",
                "Login page Title is wrong");

        Assert.assertEquals(webDriver.getCurrentUrl(),
                "https://www.linkedin.com/",
                "The link is not correct");

//        WebElement formLog = webDriver.findElement(By.xpath("//section"));
//        Assert.assertEquals(true, formLog.isDisplayed());


        WebElement emailField = webDriver.findElement(By.xpath("//form [@class = 'login-form'] /input [@type = 'text']"));
        emailField.sendKeys("Veresmag@yandex.ru");

        WebElement fieldPassword = webDriver.findElement(By.xpath("//form [@class = 'login-form'] /input [@type = 'password']"));
        fieldPassword.sendKeys("Veresmag14");

        WebElement signInButton =
                webDriver.findElement(By.xpath("//form [@class = 'login-form'] /input [@id = 'login-submit']"));

        signInButton.click();

//        Assert.assertTrue(emailField.isDisplayed(),
//                "Sign button is not Displayed");

        sleep(5000);
        Assert.assertEquals(webDriver.getTitle(),
                "LinkedIn",
                "Login page Title is wrong");
        sleep(5000);
        Assert.assertEquals(webDriver.getCurrentUrl(),
                "https://www.linkedin.com/feed/",
                "The link is not correct");

//        Assert.assertEquals(By.xpath("//li [@id ='profile-nav-item']"),"Tru", "Не тру");

        WebElement elementProf = webDriver.findElement(By.xpath("//li [@id ='profile-nav-item']"));
        Assert.assertEquals(true, elementProf.isDisplayed());

        sleep(5000);
        webDriver.close();
    }



//div [@class ='dropdown closed ember-view']

// Домашня работа на 14.05.2018

     @Test
    public void reversesuccessfulLoginTest() throws InterruptedException {

    WebDriver webDriver = new FirefoxDriver();
    webDriver.get("https://www.linkedin.com/");

            webDriver.findElement(By.id("login-submit")).click();

    Assert.assertEquals(webDriver.getCurrentUrl(),
            "https://www.linkedin.com/",
            "Incorrect activation of the login form.");

         webDriver.navigate() .refresh();

         WebElement emailField2 = webDriver.findElement(By.id("login-email"));
         emailField2.sendKeys("Veresmag@yandex.ru");

         webDriver.findElement(By.id("login-submit")).click();

            sleep(3000);

         Assert.assertEquals(webDriver.getCurrentUrl(),
                 "https://www.linkedin.com/",
                 "Incorrect activation of the login form.");

         webDriver.navigate() .refresh();

         WebElement fieldPassword = webDriver.findElement (By.id("login-password"));
         fieldPassword.sendKeys("Veresmag14");

         webDriver.findElement(By.id("login-submit")).click();

         sleep(3000);

         Assert.assertEquals(webDriver.getCurrentUrl(),
                 "https://www.linkedin.com/",
                 "Incorrect activation of the login form.");

         sleep(3000);
         webDriver.navigate() .refresh();

         WebElement emailField3 = webDriver.findElement(By.id("login-email"));
         emailField3.sendKeys("Veresmag14");

         WebElement fieldPassword2 = webDriver.findElement (By.id("login-password"));
         fieldPassword2.sendKeys("Veresmag@yandex.ru");

         webDriver.findElement(By.id("login-submit")).click();

         Assert.assertEquals(webDriver.getCurrentUrl(),
                 "https://www.linkedin.com/uas/login-submit",
                 "Incorrect activation of the login form.");

    sleep(5000);
    webDriver.close();
    }
}