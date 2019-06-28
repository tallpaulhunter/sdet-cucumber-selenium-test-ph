package uk.co.costcutter.step_definitions;

import static uk.co.costcutter.pages.SignUp.getSignUp;

import cucumber.api.java.en.Then;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.co.costcutter.pages.SignUp;

public class SignUpSteps {

  private static final Logger LOG = LoggerFactory.getLogger(SignUpSteps.class);

  private SignUp signUp = getSignUp();

  @Then("The sign up element is displayed")
  public void theSignUpElementIsDisplayed() {

    LOG.info("Executing step: The sign up element is displayed");
    signUp.verifySignUpIsDisplayed();
  }
}
