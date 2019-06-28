package uk.co.costcutter.step_definitions;

import static uk.co.costcutter.pages.Results.getResults;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import io.cucumber.datatable.DataTable;
import java.util.List;
import java.util.Map;
import uk.co.costcutter.pages.Results;

public class ResultsSteps {

  Results results = getResults();

  @Then("{int} stores are returned")
  public void numberOfStoresDisplayedForPostcode(int resultCount) {
    results.verifyResultCount(resultCount);
  }

  @And("The following stores are returned")
  public void theFollowingStoresAreReturned(List<Map<String, String>> dataTable) {
    results.verifyResultStores(dataTable);
  }
}
