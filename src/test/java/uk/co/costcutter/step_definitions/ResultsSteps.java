package uk.co.costcutter.step_definitions;

import static uk.co.costcutter.pages.Results.getResults;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.co.costcutter.pages.Results;

public class ResultsSteps {

  private static final Logger LOG = LoggerFactory.getLogger(ResultsSteps.class);

  private Results results = getResults();

  @Then("{int} stores are returned")
  public void numberOfStoresDisplayedForPostcode(int resultCount) {

    LOG.info("Executing step: {} stores are returned", resultCount);
    results.verifyResultCount(resultCount);
  }

  @And("The following stores are returned")
  public void theFollowingStoresAreReturned(List<Map<String, String>> dataTable) {

    LOG.info("Executing step: The following stores are returned");
    results.verifyResultStores(dataTable);
  }

  @Then("{int} stores are returned near {string}")
  public void storesAreReturnedNear(int resultCount, String locationText) {

    LOG.info("Executing step: {} stores are returned near {}", resultCount, locationText);
    results.verifyResultCountNearLocation(resultCount, locationText);
  }

  @Then("No search results are returned")
  public void noSearchResultsAreReturned() {

    LOG.info("Executing step: No search results are returned");
    results.verifyNoResultsAreReturned();
  }

  @When("The {string} filter is selected")
  public void selectResultsFilter(String filter) {

    LOG.info("Executing step: The {} filter is selected", filter);
    results.selectResultsFilter(filter, true);
  }

  @When("The {string} filter is deselected")
  public void deselectResultsFilter(String filter) {

    LOG.info("Executing step: The {} filter is deselected", filter);
    results.selectResultsFilter(filter, false);
  }

  @And("The Update stores button is selected")
  public void buttonIsSelected() {

    LOG.info("Executing step: The Update stores button is selected");
    results.selectUpdateStores();
  }

  @And("Result item {int} elements will be displayed")
  public void theResultSElementsWillBeDisplayed(int resultItem) {

    LOG.info("Executing step: Result item {} elements will be displayed", resultItem);
    results.elementsDisplayedForResult(resultItem);
  }
}
