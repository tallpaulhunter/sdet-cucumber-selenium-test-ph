package uk.co.costcutter.step_definitions;

import static uk.co.costcutter.pages.Footer.*;

import cucumber.api.java.en.Then;
import uk.co.costcutter.pages.Footer;

public class FooterSteps {

  Footer footer = getFooter();

  @Then("The footer is displayed")
  public void theFooterIsDisplayed() {
    footer.verifyFooterUpIsDisplayed();
  }
}
