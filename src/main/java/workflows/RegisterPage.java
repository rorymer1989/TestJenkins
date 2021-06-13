package workflows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {
    private final WebDriver driver;
    WebElement accountBtn;
    WebElement registerBtn;

    public RegisterPage(WebDriver driver){
        this.driver = driver;
        this.accountBtn = driver.findElement(By.xpath("//span[contains(text(),'Account')]"));
        this.registerBtn = driver.findElement(By.xpath("//a[contains(text(),'Register')]"));
    }

    public void clickOnAccountDropdown(){
        accountBtn.click();
    }

    public void clickOnRegisterButton(){
        registerBtn.click();
    }
}
