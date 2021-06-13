package workflows;

import org.openqa.selenium.WebDriver;
import pageUIs.LoginPageUI;
import utils.Commons.AbstractPage;

public class SiteMapPage extends AbstractPage {
    public SiteMapPage(WebDriver driver) {super(driver); }
    public void openHomePage(){ clickToElement(LoginPageUI.LOGIN_BTN); }
}
