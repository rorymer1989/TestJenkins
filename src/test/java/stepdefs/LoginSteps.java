package stepdefs;

import controllers.Controller;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import workflows.LoginPage;

public class LoginSteps {
    private final Controller controller;
    private final LoginPage loginPage;

    public LoginSteps(Controller controller){
        this.controller = controller;
        this.loginPage = new LoginPage(this.controller.getDriver());
    }

    @When("^I access to Login Function$")
    public void goToLoginPage(){
        loginPage.clickOnAccountDropdown();
        loginPage.clickOnLoginButton();
    }

    @Then("^I login$")
    public void login(){

    }
}
