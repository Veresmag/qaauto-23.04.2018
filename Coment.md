//        Assert.assertEquals("a","b","Probably 'a' is not equal to 'b' ");

//        Assert.assertTrue(linkedinHomePage.getCurrentTittle().contains("Linkedian"),
//                "Home page Title is wrong");

//        WebElement formLog = webDriver.findElement(By.xpath("//section"));
//        Assert.assertEquals(true, formLog.isDisplayed());

//         Мой код 10.05.2018
//        WebElement emailField = webDriver.findElement(By.xpath("//form [@class = 'login-form'] /input [@type = 'text']"));
//        emailField.sendKeys("Veresmag@yandex.ru");
//
//        WebElement fieldPassword = webDriver.findElement(By.xpath("//form [@class = 'login-form'] /input [@type = 'password']"));
//        fieldPassword.sendKeys("Veresmag14");
//
//        WebElement signInButton =
//                webDriver.findElement(By.xpath("//form [@class = 'login-form'] /input [@id = 'login-submit']"));
//
//        signInButton.click();

Неправильній код по версии препода:
//        WebElement elementProf = webDriver.findElement(By.xpath("//li [@id ='profile-nav-item']"));
//        Assert.assertEquals(true, elementProf.isDisplayed());

//div [@class ='dropdown closed ember-view']

Нужно выяснить лишнее это или нет:

        sleep(5000);
        Assert.assertEquals(webDriver.getTitle(),
                "Проверка безопасности | LinkedIn",
                "Login page Title is wrong");
        sleep(5000);
        Assert.assertEquals(webDriver.getCurrentUrl(),
                "https://www.linkedin.com/feed/",
                "The link is not correct");



Старое ДЗ на негативные тесты:

  @Test
    public void reversesuccessfulLoginTest() throws InterruptedException {

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
    }
