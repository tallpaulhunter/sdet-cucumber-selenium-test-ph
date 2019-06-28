package uk.co.costcutter.step_definitions;

import static uk.co.costcutter.pages.Header.getHeader;

import cucumber.api.java.en.Then;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.co.costcutter.pages.Header;

public class HeaderSteps {
  private static final Logger LOG = LoggerFactory.getLogger(HeaderSteps.class);

  Header header = getHeader();

  @Then("The page header element is displayed")
  public void thePageHeaderElementIsDisplayed() {
    LOG.info("The page header element is dsplayed");
    header.verifyHeaderExists();

  }
}
