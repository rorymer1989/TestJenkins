package stepdefs;

import controllers.Controller;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import workflows.OrdersAndReturnsPage;

public class OrdersAndReturnsSteps {

    private final OrdersAndReturnsPage ordersAndReturnsPage;
    private final Controller controller;

    public OrdersAndReturnsSteps(Controller controller){
        this.controller = controller;
        this.ordersAndReturnsPage = new OrdersAndReturnsPage(this.controller.getDriver());
    }

    @Given("^I access to Orders and Returns page$")
    public void accessToOrdersAndReturnsPage() {
        ordersAndReturnsPage.clickOnOrderAndReturn();
    }

    @When("^I order and return by \"([^\"]*)\"$")
    public void orderAndReturn(String orderType){
        ordersAndReturnsPage.inputOrderInformation(orderType);
        ordersAndReturnsPage.clickContinue();
    }

    @Then("^I order successfully$")
    public void assertOrderMessage() {
        ordersAndReturnsPage.assertErrorMessage();
    }
}
