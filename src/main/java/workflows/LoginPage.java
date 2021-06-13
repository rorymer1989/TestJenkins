package workflows;

import org.openqa.selenium.WebDriver;
import pageUIs.LoginPageUI;
import utils.Commons.AbstractPage;


public class LoginPage extends AbstractPage{

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public void clickOnAccountDropdown(){
        clickToElement(LoginPageUI.ACCOUNT_BTN);
    }
    public void clickOnLoginButton(){
        clickToElement(LoginPageUI.LOGIN_BTN);
    }

}
