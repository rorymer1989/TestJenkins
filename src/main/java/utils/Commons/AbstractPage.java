package utils.Commons;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;

/**
 *
 */
public class AbstractPage {
    By by;
    Select select;
    Actions action;
    WebDriver driver;
    WebElement element;
    List<WebElement>elements;
    WebDriverWait waitExplixit;
    JavascriptExecutor jsExecutor;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        this.jsExecutor = (JavascriptExecutor) driver;
        this.waitExplixit = new WebDriverWait(driver, Property.getDefaultWait());
        this.action = new Actions(driver);
    }

    /**
     * It is used to find element on UI based on locator
     * @param locator
     * @return WebElement
     */
    public WebElement findElement(String locator) {
        return driver.findElement(By.xpath(locator));
    }

    /**
     * It is used to find the list of elements on UI based on locator
     * @param locator
     * @return The list of WebElement
     */
    public List<WebElement> findElements(String locator) {
        return driver.findElements(By.xpath(locator));
    }

    /**
     * It is used to open URL on browser
     * @param URL
     */
    public void openURL(String URL) {
        driver.get(URL);
    }

    /**
     * It is used to get title of page
     * @return the title of page as String
     */
    public String getTitle() {
        return driver.getTitle();
    }

    /**
     * It is used to get current URL of page
     * @return URL of page as String
     */
    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    /**
     * It is used to get page source code of page. Page source code is all the HTML in DOM
     * @return source code of page
     */
    public String getPageSourceCode() {
        return driver.getPageSource();
    }

    /**
     * It is used to go back to previous page (like back button on browser)
     */
    public void backToPage() {
        driver.navigate().back();
    }

    /**
     * It is used to go to the next page (like next button on browser)
     */
    public void forwardToPage() {
        driver.navigate().forward();
    }

    /**
     * It is used to refresh page (like F5 on keyboard)
     */
    public void refreshPage() {
        driver.navigate().refresh();
    }

    /**
     * It is used to click on OK/Accept/Agree button on alert
     */
    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    /**
     * It is used to click on Cancel/Dismiss button on alert
     */
    public void cancelAlert() {
        driver.switchTo().alert().dismiss();
    }

    /**
     * It is used to send text to input element on alert
     * @param value Value to input to alert
     */
    public void senkeyToAlert(String value) {
        driver.switchTo().alert().sendKeys(value);
    }

    /**
     * It is used to get text on alert
     * @return text on alert as String
     */
    public String getTextAlert() {
        return driver.switchTo().alert().getText();
    }

    /**
     * It is used to click on Element that found by locator
     * @param locator
     */
    public void clickToElement(String locator) {
        element = findElement(locator);
        element.click();
    }

    /**
     * It is used to input text into textbox/textarea element
     * @param locator
     * @param value
     */
    public void sendkeyToElement(String locator, String value) {
        element = findElement(locator);
        element.clear();
        element.sendKeys(value);
    }

    /**
     * It is used to select value from dropdown list
     * @param locator locator of dropdown list
     * @param value selected value from dropdown list
     */
    public void selectItemInDropdown(String locator, String value) {
        element = findElement(locator);
        select = new Select(element);
        select.selectByVisibleText(value);
    }

    /**
     * It is used to select value from dropdown list by Java Script
     * @param parentLocator locator of dropdown list
     * @param allItemsLocator the list of all items in dropdown list
     * @param expectedItem selected value from dropdown list
     */
    public void selectItemInDropdownJS(String parentLocator, String allItemsLocator, String expectedItem) {
        element = driver.findElement(By.xpath(parentLocator));
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
        sleepInSecond(1);
        jsExecutor.executeScript("arguments[0].click();", element);
        sleepInSecond(1);
        waitExplixit.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(allItemsLocator)));
        elements = driver.findElements(By.xpath(allItemsLocator));
        for (WebElement item : elements) {
            System.out.println(item.getText());
            if (item.getText().equalsIgnoreCase(expectedItem)) {
                jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
                sleepInSecond(1);
                item.click();
                sleepInSecond(2);
                break;
            }
        }
    }

    /**
     * Sleep page in period time (count be second)
     * @param numberInSecond priod time of sleeping
     */
    public void sleepInSecond(long numberInSecond) {
        try {
            Thread.sleep(numberInSecond * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * It is used to get value of attribute in DOM
     * @param locator locator that user want to get attribute's value
     * @param attributeName name of attribute that user want to get value
     * @return return attribute name as String
     */
    public String getAttributeValue(String locator, String attributeName) {
        element = findElement(locator);
        return element.getAttribute(attributeName);
    }

    /**
     * Is is used to get text of element. It usually use for element which contains text
     * @param locator locator that user want to get text
     * @return return text as String
     */
    public String getTextElement(String locator) {
        element = findElement(locator);
        return element.getText();
    }

    /**
     * Is is used to count total element matched provided locator
     * @param locator locator that user want to find
     * @return total matched elements
     */
    public int countTotalElements(String locator) {
        elements = findElements(locator);
        return elements.size();
    }

    /**
     * It is used to check checkbox. Check status of checkbox first. If unchecked -> check. It checked -> ignore
     * @param locator locator of checkbox
     */
    public void checkToCheckBox(String locator) {
        element = findElement(locator);
        if (element.isSelected() == false) {
            element.click();
        }
    }

    /**
     * It is used to uncheck checkbox. Check status of checkbox first. If unchecked -> ingore. It checked -> uncheck
     * @param locator locator of checkbox
     */
    public void uncheckToCheckBox(String locator) {
        element = findElement(locator);
        if (element.isSelected() == true) {
            element.click();
        }
    }

    /**
     * It is used to check Display Status of element
     * @param locator location which user want to check
     * @return return result as boolean (true/false)
     */
    public boolean isElementDisplayed(String locator) {
        element = findElement(locator);
        return element.isDisplayed();
    }

    /**
     * It is used to check Selected Status of element (for checkbox)
     * @param locator location which user want to check
     * @return return result as boolean (true/false)
     */
    public boolean isElementSelected(String locator) {
        element = findElement(locator);
        return element.isSelected();
    }

    /**
     * It is used to check Enabled Status of element (displayed and able to touch)
     * @param locator location which user want to check
     * @return return result as boolean (true/false)
     */
    public boolean isElementEnabled(String locator) {
        element = findElement(locator);
        return element.isEnabled();
    }

    /**
     * It is used to switch to child window by ID. Get ID of window then compare with parent window. If diff, switch to
     * @param parent ID of parent window
     */
    public void switchToChildWindowByID(String parent) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindow : allWindows) {
            if (!runWindow.equalsIgnoreCase(parent)) {
                driver.switchTo().window(runWindow);
                break;
            }
        }
    }

    /**
     * It is used to switch to window which has specific title. Switch to all window until window has title which equal provided title
     * @param title title of window
     */
    public void switchToWindowByTitle(String title) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindows : allWindows) {
            driver.switchTo().window(runWindows);
            String currentWindow = driver.getTitle();
            if (currentWindow.equalsIgnoreCase(title)) {
                break;
            }
        }
    }

    /**
     * It is used to close all child window and keep parent window only. Switch to the all window. If the ID is diff to parent's ID, close it
     * @param parentWindow ID of parent window
     * @return return boolean (true/false). Return true if there is only 1 window otherwise return false.
     */
    public boolean closeAllWindowsWithoutParent(String parentWindow) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindows : allWindows) {
            if (!runWindows.equalsIgnoreCase(parentWindow)) {
                driver.switchTo().window(runWindows);
                driver.close();
            }
        }
        driver.switchTo().window(parentWindow);
        return driver.getWindowHandles().size() == 1;
    }

    /**
     * It is used to switch to new Frame or Iframe by locator
     * @param locator locator of Frame or Iframe
     */
    public void switchToFrameOrIframe(String locator) {
        element = findElement(locator);
        driver.switchTo().frame(element);
    }

    /**
     * It is used to back to parent page ( of frame of iframe)
     */
    public void switchToParentPage() {
        driver.switchTo().defaultContent();
    }

    /**
     * It is used to hover mouse to element
     * @param locator locator of element
     */
    public void hoverToElement(String locator) {
        element = findElement(locator);
        action.moveToElement(element).perform();
    }

    /**
     * It is used to double click to element
     * @param locator locator of element
     */
    public void doubleClickToElement(String locator) {
        element = findElement(locator);
        action.doubleClick(element).perform();
    }

    /**
     * It is used to send key from keyboard to element
     * @param locator locator of element
     */
    public void sendKeyboardToElement(String locator, Keys key) {
        element = findElement(locator);
        action.sendKeys(element, key).perform();
    }

    /**
     * It is used to right click to element
     * @param locator locator of element
     */
    public void rightClickToElement(String locator) {
        element = findElement(locator);
        action.contextClick(element).perform();
    }

    /**
     * It is used to drag from source element to destination element
     * @param sourceLocator
     * @param desLocator
     */
    public void dragAndDropToElement (String sourceLocator, String desLocator){
        WebElement source = findElement(sourceLocator);
        WebElement des = findElement(desLocator);
        action.dragAndDrop(source,des).perform();
    }

    /**
     * It is used to upload single file
     * @param locator locator of upload button
     * @param fileName name of file that user want to upload. Please copy this file to folder of project
     */
    public void uploadFile(String locator, String fileName) {
        element = findElement(locator);
        element.sendKeys(System.getProperty("user.dir") + "\\resources\\drivers\\" + fileName);
    }

    /**
     * It is used to wait until element visible
     * @param locator locator of element
     */
    public void waitToElementVisible(String locator) {
        by = By.xpath(locator);
        waitExplixit.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    /**
     * It is used to wait until element presence
     * @param locator locator of element
     */
    public void waitToElementPresence(String locator) {
        by = By.xpath(locator);
        waitExplixit.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    /**
     * It is used to wait until element can be clicked
     * @param locator locator of element
     */
    public void waitToElementClickable(String locator) {
        by = By.xpath(locator);
        waitExplixit.until(ExpectedConditions.elementToBeClickable(by));
    }

    /**
     * It is used to wait until alert presence
     */
    public void waitToAlertPresence() {
        waitExplixit.until(ExpectedConditions.alertIsPresent());
    }
}
