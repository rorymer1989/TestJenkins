package stepdefs;

import controllers.Controller;
import workflows.HomePage;
import workflows.LoginPage;

public class HomeSteps {
    private final Controller controller;
    private final HomePage homePage;

    public HomeSteps(Controller controller){
        this.controller = controller;
        this.homePage = new HomePage(this.controller.getDriver());
    }
}
