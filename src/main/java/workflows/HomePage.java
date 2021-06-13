package workflows;

import org.openqa.selenium.WebDriver;
import pageUIs.LoginPageUI;
import utils.Commons.AbstractPage;

public class HomePage extends AbstractPage {
    public HomePage(WebDriver driver){
        super(driver);
    }
    public void openLoginPage(){
        clickToElement(LoginPageUI.ACCOUNT_BTN);
    }

}
