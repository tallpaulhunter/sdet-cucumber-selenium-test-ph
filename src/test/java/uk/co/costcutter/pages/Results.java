package uk.co.costcutter.pages;

import static org.assertj.core.api.Assertions.fail;
import static uk.co.costcutter.common.CommonVerification.getCommonVerification;
import static uk.co.costcutter.common.DriverFactory.getChromeDriver;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import uk.co.costcutter.common.CommonVerification;

public class Results {

  protected WebDriver driver = getChromeDriver();

  private CommonVerification commonVerification = getCommonVerification();

  private By results = By.id("results");
  private By resultsWrapper = By.xpath("//*[@id=\"results\"]/div[1]/div/div");

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

  public void verifyResultStores(List<Map<String, String>> dataTable) {
    int index = 0;
    List<WebElement> resultsList = driver.findElements(resultsWrapper);
    for (Map<String, String> rowData : dataTable) {
      WebElement itemToTest = resultsList.get(index);
      String addressLineAttrib = itemToTest.getAttribute("data-addressline2");
      String milesAttrib = itemToTest.getAttribute("data-distance"); // '0.54 miles'
      String expandedCollapsedAttrib = itemToTest.getAttribute("class"); // 'accordion-item open' or 'accordion item'

      assertThat(addressLineAttrib)
          .as("Address was not as expected ('%s') for row.")
          .isEqualTo(rowData.get("store"));

      assertThat(milesAttrib)
          .as("Expected distance for '%s' was not as expected.")
          .isEqualTo(rowData.get("miles") + " miles");

      if (rowData.get("expandedcollapsed").equals("expanded")) {
        assertThat(expandedCollapsedAttrib)
            .as("Expected item '%s' to be expanded, but was collapsed.", rowData.get("store"))
            .isEqualTo("accordion-item open");
      } else if (rowData.get("expandedcollapsed").equals("collapsed")) {
        assertThat(expandedCollapsedAttrib)
            .as("Expected item '%s' to be collapsed, but was expanded.")
            .isEqualTo("accordion-item");
      } else {
        fail("option specified '%s' not valid. Must be 'expanded' or 'collapsed.'");
      }

      index++;
    }
  }
}
