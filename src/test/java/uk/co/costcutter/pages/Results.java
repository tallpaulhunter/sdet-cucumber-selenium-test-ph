package uk.co.costcutter.pages;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import static uk.co.costcutter.common.CommonVerification.getCommonVerification;
import static uk.co.costcutter.common.DriverFactory.getChromeDriver;
import static uk.co.costcutter.common.DriverFactory.getWebDriverWait;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.co.costcutter.common.CommonVerification;

public class Results {

  private static final Logger LOG = LoggerFactory.getLogger(Results.class);
  private WebDriver driver = getChromeDriver();
  private WebDriverWait wait;

  private CommonVerification commonVerification = getCommonVerification();

  private By resultsBanner = By.xpath(("//*[@id=\"totals\"]/div/h3"));
  private By resultsWrapper = By.xpath("//*[@id=\"results\"]/div[1]/div/div");

  private By bakeryFilter = By.xpath("//*[@id=\"filters\"]/div[2]/form/fieldset/div/span[1]/label");
  private By cashMachineFilter = By.xpath("//*[@id=\"filters\"]/div[2]/form/fieldset/div/span[2]/label");
  private By cashBackFilter = By.xpath("//*[@id=\"filters\"]/div[2]/form/fieldset/div/span[3]/label");
  private By deliCounterFilter = By.xpath("//*[@id=\"filters\"]/div[2]/form/fieldset/div/span[4]/label");
  private By hermesFilter = By.xpath("//*[@id=\"filters\"]/div[2]/form/fieldset/div/span[5]/label");
  private By hotFoodFilter = By.xpath("//*[@id=\"filters\"]/div[2]/form/fieldset/div/span[6]/label");
  private By localProduceFilter = By.xpath("//*[@id=\"filters\"]/div[2]/form/fieldset/div/span[7]/label");
  private By lotteryInstantFilter = By.xpath("//*[@id=\"filters\"]/div[2]/form/fieldset/div/span[8]/label");
  private By newsDeliveryFilter = By.xpath("//*[@id=\"filters\"]/div[2]/form/fieldset/div/span[9]/label");
  private By parkingFilter = By.xpath("//*[@id=\"filters\"]/div[2]/form/fieldset/div/span[10]/label");
  private By payzoneFilter = By.xpath("//*[@id=\"filters\"]/div[2]/form/fieldset/div/span[11]/label");
  private By photocopyingFilter = By.xpath("//*[@id=\"filters\"]/div[2]/form/fieldset/div/span[12]/label");
  private By recycleFilter = By.xpath("//*[@id=\"filters\"]/div[2]/form/fieldset/div/span[13]/label");

  private By updateStoresButton = By.xpath("//*[@id=\"filters\"]/div[2]/form/button");

  private By map = By.className("map-canvas");

  private Map<String, By> filterMap = new HashMap<>();

  private Results() {
    // hide it
  }

  public static Results getResults() {
    return new Results();
  }

  public Results verifyResultCount(int decendentCount) {

    commonVerification.verifyDecendentItemCount(resultsWrapper, decendentCount);
    return this;
  }

  public Results verifyResultStores(List<Map<String, String>> dataTable) {

    int index = 0;
    List<WebElement> resultsList = driver.findElements(resultsWrapper);
    for (Map<String, String> rowData : dataTable) {
      WebElement itemToTest = resultsList.get(index);
      String addressLineAttrib = itemToTest.getAttribute("data-addressline2");
      String milesAttrib = itemToTest.getAttribute("data-distance");
      String expandedCollapsedAttrib = itemToTest.getAttribute("class");

      assertThat(addressLineAttrib)
          .as("Address was not as expected ('%s') for row.")
          .isEqualTo(rowData.get("store"));
      LOG.info("Address was as expected");

      assertThat(milesAttrib)
          .as("Distance for '%s' was not as expected.")
          .isEqualTo(rowData.get("miles") + " miles");
      LOG.info("Distance was as expected");

      if (rowData.get("expandedcollapsed").equals("expanded")) {
        assertThat(expandedCollapsedAttrib)
            .as("Expected item '%s' to be expanded, but was collapsed.", rowData.get("store"))
            .isEqualTo("accordion-item open");
        LOG.info("Item was expanded, as expected");
      } else if (rowData.get("expandedcollapsed").equals("collapsed")) {
        assertThat(expandedCollapsedAttrib)
            .as("Expected item '%s' to be collapsed, but was expanded.")
            .isEqualTo("accordion-item");
        LOG.info("Item was collapsed, as expected");
      } else {
        fail("option specified '%s' not valid. Must be 'expanded' or 'collapsed.'");
      }

      index++;
    }
    return this;
  }

  public Results verifyResultCountNearLocation(int resultCount, String locationText) {

    wait = getWebDriverWait(5);
    wait.until(visibilityOfElementLocated(resultsBanner));
    wait.until(ExpectedConditions
        .textToBe(resultsBanner, resultCount + " stores found near " + locationText));
    assertThat(driver.findElement(resultsBanner).getText())
        .as("The expected number of stores for {} is not as expected", locationText)
        .isEqualTo(resultCount + " stores found near " + locationText);
    LOG.info("Number of stores was as expected: {}", resultCount);
    return this;
  }

  public Results verifyNoResultsAreReturned() {

    wait = getWebDriverWait(5);
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    assertThat(driver.findElement(resultsBanner).isDisplayed())
        .as("Results are displayed unexpectedly")
        .isFalse();
    LOG.info("No results returned, as expected.");
    return this;
  }

  private Results populateObjectMap() {

    filterMap.put("Bakery", bakeryFilter);
    filterMap.put("Cash Machine", cashMachineFilter);
    filterMap.put("Cash back", cashBackFilter);
    filterMap.put("Deli Counter", deliCounterFilter);
    filterMap.put("Hermes", hermesFilter);
    filterMap.put("Hot Food", hotFoodFilter);
    filterMap.put("Local Produce", localProduceFilter);
    filterMap.put("Lottery Instant", lotteryInstantFilter);
    filterMap.put("News Delivery", newsDeliveryFilter);
    filterMap.put("Parking", parkingFilter);
    filterMap.put("Payzone", payzoneFilter);
    filterMap.put("Photocopying", photocopyingFilter);
    filterMap.put("Recycle", recycleFilter);
    return this;
  }

  public Results selectResultsFilter(String filter, Boolean selected) {

    populateObjectMap();
    WebElement element = driver.findElement(filterMap.get(filter));
    if ((!element.isSelected() && selected) || (element.isSelected() && !selected)) {
      element.click();
    }
    return this;
  }

  public Results selectUpdateStores() {

    driver.findElement(updateStoresButton).click();
    return this;
  }

  public void elementsDisplayedForResult(int resultItem) {

    List<WebElement> resultsList = driver.findElements(resultsWrapper);
    WebElement itemToTest = resultsList.get(resultItem - 1);
    if (resultItem > 1) {
      itemToTest.click();
      wait.until(ExpectedConditions.attributeContains(itemToTest, "class", "accordion-item open"));
    }

    String locatorString = "//*[@id=\"results\"]/div[1]/div/div[" + resultItem + "]/div[2]";
    commonVerification.verifyIsDisplayed(By.xpath(locatorString + "/div[1]/address[1]"));
    LOG.info("Result {} address line 1 is displayed", resultItem);

    commonVerification.verifyIsDisplayed(By.xpath(locatorString + "/div[1]/address[2]"));
    LOG.info("Result {} address line 2 is displayed", resultItem);

    commonVerification.verifyIsDisplayed(By.xpath(locatorString + "/div[1]/p"));
    LOG.info("Result {} phone number is displayed", resultItem);

    commonVerification.verifyIsDisplayed(By.xpath(locatorString + "/div[1]/div/p"));
    LOG.info("Result {} operating title is displayed", resultItem);

    commonVerification.verifyIsDisplayed(By.xpath(locatorString + "/div[1]/div/time"));
    LOG.info("Result {} operating time is displayed", resultItem);

    commonVerification.verifyIsDisplayed(By.xpath(locatorString + "/div[1]/a[1]"));
    LOG.info("Result {} set As Local Store Button is displayed", resultItem);

    commonVerification.verifyIsDisplayed(By.xpath(locatorString + "/div[1]/a[2]"));
    LOG.info("Result {} store Home Button is displayed", resultItem);

    commonVerification.verifyIsDisplayed(By.xpath(locatorString + "/div[2]/h2"));
    LOG.info("Result {} opening Hours Title is displayed", resultItem);

    // cycle through all seven days of the week
    for (int i = 1; i <= 7; i++) {
      String day = setDay(i);

      commonVerification.verifyIsDisplayed(By.xpath(locatorString + "/div[2]/div/p[" + i + "]"));
      LOG.info("Result {} day title is displayed {}", resultItem, day);

      commonVerification.verifyIsDisplayed(By.xpath(locatorString + "/div[2]/div/p[" + i + "]/span"));
      LOG.info("Result {} day hours is displayed", resultItem);
    }
  }

  private String setDay(int i) {

    switch (i) {
      case 1:
        return "Monday";
      case 2:
        return "Tuesday";
      case 3:
        return "Wednesday";
      case 4:
        return "Thursday";
      case 5:
        return "Friday";
      case 6:
        return "Saturday";
      case 7:
      default:
        return "Sunday";
    }
  }
}
