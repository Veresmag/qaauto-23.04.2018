import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkedinLoginPage {
    private WebDriver webDriver;

    private WebElement emailField;
    private WebElement passwordField;
    private WebElement signInButton;
    private WebElement buttonWillJoin;
    private WebElement allertContentMassage;
    private WebElement loginRegistration;

    public LinkedinLoginPage(WebDriver webDriver){
        this.webDriver=webDriver;
        initElements();
    }

    public void initElements () {
        emailField = webDriver.findElement(By.id("login-email"));
        passwordField = webDriver.findElement(By.id("login-password"));
        signInButton = webDriver.findElement(By.id("login-submit"));
        buttonWillJoin = webDriver.findElement(By.xpath("//input [@class='registration submit-button']"));
        allertContentMassage = webDriver.findElement(By.xpath("//span [@class='alert-content']"));
        loginRegistration = webDriver.findElement(By.id("reg-firstname"));
    }

    public void login (String email, String password) {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        signInButton.click();
    }

    public boolean isSighInButtonDisplayed () {
        return signInButton.isDisplayed();
    }

    public String getCurrentUrl (){
        return webDriver.getCurrentUrl();
    }

    public String getCurrentTittle (){
        return webDriver.getTitle();
    }

    public void joinButton (){
      buttonWillJoin.click();
    }

    public String getAllertContentMassage (){
        return allertContentMassage.getText();
    }

    public void loginRegistration (String name) {
        loginRegistration.sendKeys();
    }
}
