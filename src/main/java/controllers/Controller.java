package controllers;

import cucumber.api.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import utils.Commons.Constans;
import utils.Commons.Property;


import java.io.File;

public class Controller {
    private WebDriver driver;
    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void setupController() {
        String url = Property.getPropertyValue("base_path");
          switch (Property.getDefaultBrowser()) {
                case "firefox":
                    System.setProperty("webdriver.gecko.driver", Constans.DRIVER_LOCATION + "geckodriver.exe");
                    System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"true");
                    System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, Constans.ROOT_LOCATION + "\\FireFoxLogs.txt");
                    driver = new FirefoxDriver();
                    break;
                case "ie":
                    System.setProperty("webdriver.ie.driver", Constans.DRIVER_LOCATION + "IEDriverServer.exe");
                    driver= new InternetExplorerDriver();
                    break;
                case "chrome":
                    System.setProperty("webdriver.chrome.driver", Constans.DRIVER_LOCATION + "chromedriver.exe");
                    driver = new ChromeDriver();
                    break;
            }
        driver.get(url);
        driver.manage().window().maximize();
    }

    public void teardownController(Scenario scenario) throws Exception {
        if (scenario.isFailed()){
          try {
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                File screenshot_with_scenario_name = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(screenshot_with_scenario_name, new File(Constans.REPORT_FAILD_LOCATION + scenario.getSourceTagNames() + " " + scenario.getName() + ".png"));
                System.out.println(scenario.getSourceTagNames());
                scenario.embed(screenshot, "image/pgn");
            } catch (WebDriverException somePlatformDontSupportScreenshots) {
                System.out.println(somePlatformDontSupportScreenshots.getMessage());
            }


        }
        if (driver != null) {
            driver.quit();
        }
    }
}
