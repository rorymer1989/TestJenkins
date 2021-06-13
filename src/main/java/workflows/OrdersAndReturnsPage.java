package workflows;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrdersAndReturnsPage {

    private final String ERROR_MESSAGE = "Entered data is incorrect. Please try again.";
    private final WebDriver driver;
    private final WebElement ordersAndReturnsBtn;
    private final WebElement orderIDInput;
    private final WebElement billingLastNameInput;
    private final WebElement findOrderByDrop;
    private final WebElement emailAddressInput;
    private final WebElement billingZipCodeInput;
    private final WebElement continueBtn;
    private final WebElement errorMessage;

    public OrdersAndReturnsPage (WebDriver driver){
        this.driver = driver;
        this.ordersAndReturnsBtn = driver.findElement(By.xpath("//a[text() = 'Orders and Returns']"));
        this.orderIDInput = driver.findElement(By.id("oar_order_id"));
        this.billingLastNameInput = driver.findElement(By.id("oar_billing_lastname"));
        this.findOrderByDrop = driver.findElement(By.id("quick_search_type_id"));
        this.emailAddressInput = driver.findElement(By.id("oar_email"));
        this.billingZipCodeInput = driver.findElement(By.id("oar_zip"));
        this.continueBtn = driver.findElement(By.xpath("//span[text() = 'Continue']"));
        this.errorMessage = driver.findElement(By.cssSelector(".error-msg"));
    }

    public void clickOnOrderAndReturn() {
        ordersAndReturnsBtn.click();
    }

    public void inputOrderInformation(String orderType){
        orderIDInput.clear();
        orderIDInput.sendKeys("123123");
        billingLastNameInput.clear();
        billingLastNameInput.sendKeys("billing last");
        findOrderByDrop.click();
        if ("email".equalsIgnoreCase(orderType)) {
            WebElement orderByType = driver.findElement(By.cssSelector("[aria-label=\"Email Address\"]"));
            orderByType.click();
            emailAddressInput.clear();
            emailAddressInput.sendKeys("dangnh007@gmail.com");
        }
            WebElement orderByType = driver.findElement(By.cssSelector("[aria-label=\"ZIP Code\"]"));
            orderByType.click();
            billingZipCodeInput.clear();
            billingZipCodeInput.sendKeys("900000");
        }

     public void clickContinue(){
        continueBtn.click();
     }

     public void assertErrorMessage(){
         Assert.assertEquals(ERROR_MESSAGE,errorMessage.getText());
     }
}
