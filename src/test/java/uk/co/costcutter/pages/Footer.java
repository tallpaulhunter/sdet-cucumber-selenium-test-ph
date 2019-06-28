package uk.co.costcutter.pages;

import static uk.co.costcutter.common.CommonVerification.getCommonVerification;

import org.openqa.selenium.By;
import uk.co.costcutter.common.CommonVerification;

public class Footer {

  private CommonVerification commonVerification = getCommonVerification();

  private By footer = By.className("page-footer");

  private Footer() {
    // hide it
  }

  public static Footer getFooter() {
    return new Footer();
  }

  public Footer verifyFooterUpIsDisplayed() {

    commonVerification.verifyIsDisplayed(footer);
    return this;
  }

}
