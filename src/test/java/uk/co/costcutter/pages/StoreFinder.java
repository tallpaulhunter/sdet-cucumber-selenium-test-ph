package uk.co.costcutter.pages;

import static org.assertj.core.api.Assertions.assertThat;
import static uk.co.costcutter.common.CommonVerification.getCommonVerification;
import static uk.co.costcutter.common.DriverFactory.getChromeDriver;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.co.costcutter.common.CommonVerification;

public class StoreFinder {

  private static final Logger LOG = LoggerFactory.getLogger(StoreFinder.class);
  private WebDriver driver = getChromeDriver();
  private CommonVerification commonVerification = getCommonVerification();

  private By findOptions = By.id("findOptions");

  private By locationSearchButton = By.xpath("//*[@id=\"findOptions\"]/div[2]/a");
  private By locationSearchDescription = By.xpath("//*[@id=\"findOptions\"]/div[2]/p[1]");
  private By locationSearchTitle = By.xpath("//*[@id=\"findOptions\"]/div[2]/h3");

  private By postcodeSearchButton = By.xpath("//*[@id=\"findOptions\"]/div[1]/form/fieldset/button");
  private By postcodeSearchDescription = By.xpath("//*[@id=\"findOptions\"]/div[1]/p");
  private By postcodeSearchInput = By.xpath("//*[@id=\"findOptions\"]/div[1]/form/fieldset/input");
  private By postcodeSearchTitle = By.xpath("//*[@id=\"findOptions\"]/div[1]/h3");

  private By resultsContainer = By.id("results");

  private By titleBanner = By.xpath("/html/body/section[1]/div[2]/div/h2");

  private Map<String, By> objectMap = new HashMap<String, By>();

  private StoreFinder() {
    // hide it
  }

  public static StoreFinder getStoreFinder() {
    return new StoreFinder();
  }

  public StoreFinder goToStoreFinder() {

    driver = getChromeDriver();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.manage().window().fullscreen();
    driver.get("https://www.costcutter.co.uk/location-finder/");
    populateObjectMap();
    return this;
  }

  public StoreFinder populateObjectMap() {
    objectMap.put("find options", findOptions);

    objectMap.put("my location button", locationSearchButton);
    objectMap.put("my location description", locationSearchDescription);
    objectMap.put("my location title", locationSearchTitle);

    objectMap.put("postcode search title", postcodeSearchTitle);
    objectMap.put("postcode search description", postcodeSearchDescription);
    objectMap.put("postcode search input", postcodeSearchInput);
    objectMap.put("postcode search button", postcodeSearchButton);

    objectMap.put("results", resultsContainer);

    objectMap.put("title banner", titleBanner);
    return this;
  }

  public StoreFinder verifyPageTitle() {
    commonVerification.verifyPageTitle("Location Finder");
    return this;
  }

  public StoreFinder verifyBreadcrumb(String trail) {
    List<String> items = Arrays.asList(trail.split("\\s*>\\s*"));
    LOG.info(items.get(0));
    LOG.info(items.get(1));
    List<WebElement> breadcrumbItems = driver.findElements(
        By.cssSelector("body > section.container.store-finder-area > div:nth-child(1) > nav > ul > li")
    );

    assertThat(breadcrumbItems.get(0).getText())
        .as("First part of breadcrumb is not as expected")
        .isEqualTo(items.get(0));
    assertThat(breadcrumbItems.get(1).getText())
        .as("First part of breadcrumb is not as expected")
        .isEqualTo(items.get(1));

    return this;
  }

  public StoreFinder verifyItemPlaceholder(String item, String text){
    commonVerification.verifyItemPlaceholder(objectMap.get(item), text);
    return this;
  }

  public StoreFinder verifyItemDisplayed(String item) {
    commonVerification.verifyIsDisplayed(objectMap.get(item));
    return this;
  }

  public StoreFinder verifyItemText(String item, String text){
    commonVerification.verifyItemText(objectMap.get(item), text);
    return this;
  }

  public StoreFinder verifyItemIsEmpty(String item){
    commonVerification.verifyItemIsEmpty(objectMap.get(item));
    return this;
  }

  public void searchForString(String searchString) {
    driver.findElement(postcodeSearchInput).sendKeys(searchString);
    driver.findElement(postcodeSearchButton).click();
  }
}
