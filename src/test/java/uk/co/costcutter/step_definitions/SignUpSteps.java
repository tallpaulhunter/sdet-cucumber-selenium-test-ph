package uk.co.costcutter.step_definitions;

import static uk.co.costcutter.pages.SignUp.getSignUp;

import cucumber.api.java.en.Then;
import uk.co.costcutter.pages.SignUp;

public class SignUpSteps {

  SignUp signUp = getSignUp();

  @Then("The sign up element is displayed")
  public void theSignUpElementIsDisplayed() {
    signUp.verifySignUpIsDisplayed();
  }
}
