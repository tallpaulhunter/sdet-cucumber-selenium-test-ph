package uk.co.costcutter.step_definitions;

import static uk.co.costcutter.pages.Footer.getFooter;

import cucumber.api.java.en.Then;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.co.costcutter.pages.Footer;

public class FooterSteps {

  private static final Logger LOG = LoggerFactory.getLogger(FooterSteps.class);

  private Footer footer = getFooter();

  @Then("The footer is displayed")
  public void theFooterIsDisplayed() {

    LOG.info("Executing step: The footer is displayed");
    footer.verifyFooterUpIsDisplayed();
  }
}
