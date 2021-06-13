package controllers;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;


public class SetupSteps {
    Controller controller;

    public SetupSteps(Controller controller) {
        this.controller = controller;
    }

    @Before
    public void setup() {
        controller.setupController();
    }




    @After
    public void teardown(Scenario scenario) throws Exception {
        controller.teardownController(scenario);
    }
}