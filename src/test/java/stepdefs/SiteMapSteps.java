package stepdefs;

import controllers.Controller;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import workflows.HomePage;
import workflows.LoginPage;
import workflows.RegisterPage;
import workflows.SiteMapPage;

public class SiteMapSteps {

    private SiteMapPage siteMapPage;
    private HomePage homePage;
    private Controller controller;


    public SiteMapSteps(Controller controller){
        this.controller = controller;
        this.siteMapPage = new SiteMapPage(this.controller.getDriver());
        this.homePage = new HomePage(this.controller.getDriver());
    }

    @Given("^I access Login Page$")
    public void accessToLoginPage() {
       // homePage.openLoginPage();
    }

    @Then("^I access HomePage Page$")
    public void accessToHomePage() {
        siteMapPage.openHomePage();
    }

}
