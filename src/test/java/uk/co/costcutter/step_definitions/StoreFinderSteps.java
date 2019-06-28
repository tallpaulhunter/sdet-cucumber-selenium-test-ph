package uk.co.costcutter.step_definitions;

import static uk.co.costcutter.pages.StoreFinder.getStoreFinder;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.Arrays;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.co.costcutter.pages.StoreFinder;

public class StoreFinderSteps {
  private static final Logger LOG = LoggerFactory.getLogger(StoreFinderSteps.class);

  StoreFinder storeFinder = getStoreFinder();

  @Given("I navigate to store finder page")
  public void navigateToStoreFinderPage() {
    LOG.info("I navigate to the store finder page");
    storeFinder.goToStoreFinder();
  }

  @When("The store finder page is displayed")
  public void theStoreFinderPageIsDisplayed() {
    LOG.info("Verify that the page title is displayed");
    storeFinder.verifyPageTitle();
  }

  @Then("The store finder breadcrumb will be {string}")
  public void storeFinderBreadcrumbWillBe(String trail) {
    storeFinder.verifyBreadcrumb(trail);
  }

  @And("The store finder {string} will be displayed")
  public void storeFinderItemWillBeDisplayed(String item) {
    storeFinder.verifyItemDisplayed(item);
  }

  @And("The store finder {string} items will be displayed")
  public void storeFinderItemsWillBeDisplayed(String area) {
    switch (area){
      case("Use My Postcode"):
        storeFinder.verifyItemDisplayed("postcode search title")
            .verifyItemText("postcode search title",
            "Use My Postcode");

        storeFinder.verifyItemDisplayed("postcode search description")
            .verifyItemText("postcode search description",
            "To find your nearest store, simply enter a town name, city or postcode "
                + "into the search box below and hit the 'Find Store' button.");

        storeFinder.verifyItemDisplayed("postcode search input")
            .verifyItemPlaceholder("postcode search input", "Your town, city or postcode");

        storeFinder.verifyItemDisplayed("postcode search button")
            .verifyItemText("postcode search button",
            "Find my store");
        break;
      case("Use My Location"):
        storeFinder.verifyItemDisplayed("my location title")
            .verifyItemText("my location title",
            "Use My Location");

        storeFinder.verifyItemDisplayed("my location description")
            .verifyItemText("my location description",
            "Alternatively, select 'Locate Me' & we will find your nearest store based on your current location.");

        storeFinder.verifyItemDisplayed("my location button")
            .verifyItemText("my location button","Locate me");
        break;
      default:
        LOG.info("Area specified: '%s' not recognised.");
        break;
    }
  }

  @And("The store finder {string} will be empty")
  public void theStoreFinderWillBeEmpty(String item) {
    storeFinder.verifyItemIsEmpty(item);
  }

  @When("Search is performed for {string}")
  public void searchIsPerformedFor(String searchString) {
    storeFinder.searchForString(searchString);
  }
}
