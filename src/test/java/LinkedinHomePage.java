import org.openqa.selenium.WebDriver;

import java.awt.*;

public class LinkedinHomePage {
    WebDriver webDriver;

    public LinkedinHomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String getCurrentUrl (){
        return webDriver.getCurrentUrl();
    }

    public String getCurrentTittle (){
        return webDriver.getTitle();
    }
}
