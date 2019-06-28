package uk.co.costcutter.step_definitions;

import static uk.co.costcutter.pages.StoreFinder.getStoreFinder;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.co.costcutter.pages.StoreFinder;

public class StoreFinderSteps {

  private static final Logger LOG = LoggerFactory.getLogger(StoreFinderSteps.class);

  private StoreFinder storeFinder = getStoreFinder();

  @Given("I navigate to store finder page")
  public void navigateToStoreFinderPage() {

    LOG.info("Executing step: I navigate to the store finder page");
    storeFinder.goToStoreFinder();
  }

  @When("The store finder page is displayed")
  public void theStoreFinderPageIsDisplayed() {

    LOG.info("Executing step: The store finder page is displayed");
    storeFinder.verifyPageTitle();
  }

  @Then("The store finder breadcrumb will be {string}")
  public void storeFinderBreadcrumbWillBe(String trail) {

    LOG.info("Executing step: The store finder breadcrumb will be {}", trail);
    storeFinder.verifyBreadcrumb(trail);
  }

  @And("The store finder {string} will be displayed")
  public void storeFinderItemWillBeDisplayed(String item) {

    LOG.info("Executing step: The store finder {} will be displayed", item);
    storeFinder.verifyItemDisplayed(item);
  }

  @And("The store finder {string} items will be displayed")
  public void storeFinderItemsWillBeDisplayed(String area) {

    LOG.info("Executing step: The store finder {} items will be displayed", area);
    switch (area) {
      case ("Use My Postcode"):
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
      case ("Use My Location"):
        storeFinder.verifyItemDisplayed("my location title")
            .verifyItemText("my location title",
                "Use My Location");

        storeFinder.verifyItemDisplayed("my location description")
            .verifyItemText("my location description",
                "Alternatively, select 'Locate Me' & we will find your nearest store based on your current location.");

        storeFinder.verifyItemDisplayed("my location button")
            .verifyItemText("my location button", "Locate me");
        break;
      default:
        LOG.info("Area specified: '%s' not recognised.");
        break;
    }
  }

  @And("The store finder {string} will be empty")
  public void storeFinderWillBeEmpty(String item) {

    LOG.info("Executing step: The store finder {} will be empty", item);
    storeFinder.verifyItemIsEmpty(item);
  }

  @When("Search is performed for {string}")
  public void searchFor(String searchString) {

    LOG.info("Executing step: Search is performed for {}", searchString);
    storeFinder.searchForString(searchString);
  }

  @Given("I set the default location to {string}")
  public void setDefaultLocation(String location) {

    LOG.info("Executing step: I set the default location to {}", location);
    storeFinder.setCurrentLocation(location);
  }

  @When("I select the Location button")
  public void selectLocationButton() {

    storeFinder.selectLocationButton();
  }
}
