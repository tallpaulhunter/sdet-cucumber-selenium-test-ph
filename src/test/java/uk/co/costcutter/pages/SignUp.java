package uk.co.costcutter.pages;

import static uk.co.costcutter.common.CommonVerification.getCommonVerification;

import org.openqa.selenium.By;
import uk.co.costcutter.common.CommonVerification;

public class SignUp {

  private CommonVerification commonVerification = getCommonVerification();

  private By signUp = By.className("sign-up");

  private SignUp() {
    // hide it
  }

  public static SignUp getSignUp() {
    return new SignUp();
  }

  public SignUp verifySignUpIsDisplayed() {
    commonVerification.verifyIsDisplayed(signUp);
    return this;
  }
}
