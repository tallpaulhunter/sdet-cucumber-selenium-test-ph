package uk.co.costcutter.common;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.html5.Location;
import org.openqa.selenium.html5.LocationContext;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverFactory {

    private static WebDriver driver;
    private static WebDriverWait wait;

    private DriverFactory(){
        // prevent instantiation
    }

    public static WebDriver getChromeDriver(){

        if(driver == null){
            System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver/chromedriver");
            driver = new ChromeDriver();
        }
        return driver;
    }

    public static WebDriverWait getWebDriverWait(int duration){
        if(wait == null){
            wait = new WebDriverWait(getChromeDriver(), duration);
        }
        return wait;
    }

    public static WebDriver quitWebDriver(){
      driver.quit();
      driver = null;
      return driver;
    }

    public static WebDriver getChromeDriverWithLocation(double latitude, double longitude){
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.geolocation", 1);

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);

        getChromeDriver();

        ((LocationContext)driver).setLocation(new Location(latitude, longitude, 0));
        return driver;
    }
}
