import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkedinLoginPage extends LinkedinBasePage {
    private WebElement emailField;
    private WebElement passwordField;
    private WebElement signInButton;
    private WebElement buttonWillJoin;
    private WebElement allertContentMassage;
    private WebElement loginRegistration;
    private WebElement lastNameRegistration;
    private WebElement emailRegistration;
    private WebElement passwordRegistration;

    public LinkedinLoginPage(WebDriver webDriver){
        super(webDriver);
        initElements();
    }

    public void initElements () {
        emailField = webDriver.findElement(By.id("login-email"));
        passwordField = webDriver.findElement(By.id("login-password"));
        signInButton = webDriver.findElement(By.id("login-submit"));
        buttonWillJoin = webDriver.findElement(By.xpath("//input [@class='registration submit-button']"));
        allertContentMassage = webDriver.findElement(By.xpath("//span [@class='alert-content']"));
        loginRegistration = webDriver.findElement(By.id("reg-firstname"));
        lastNameRegistration = webDriver.findElement(By.id("reg-lastname"));
        emailRegistration = webDriver.findElement(By.id("reg-email"));
        passwordRegistration = webDriver.findElement(By.id("reg-password"));
    }

    public void login (String email, String password) {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        signInButton.click();
    }

    public boolean isSighInButtonDisplayed () {
        return signInButton.isDisplayed();
    }


    public void joinButton (){
      buttonWillJoin.click();
    }

    public String getAllertContentMassage (){
        return allertContentMassage.getText();
    }

    public void loginRegistration (String name){
        loginRegistration.sendKeys(name);
        buttonWillJoin.click();
    }

    public void formRegistration (String name, String lastName, String email, String password){
        loginRegistration.sendKeys(name);
        lastNameRegistration.sendKeys(lastName);
        emailRegistration.sendKeys(email);
        passwordRegistration.sendKeys(password);
        buttonWillJoin.click();
    }
}
