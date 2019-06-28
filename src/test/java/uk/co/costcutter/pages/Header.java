package uk.co.costcutter.pages;

import static org.assertj.core.api.Assertions.assertThat;
import static uk.co.costcutter.common.DriverFactory.getChromeDriver;
import static uk.co.costcutter.common.DriverFactory.getWebDriverWait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Header {

  private WebDriver driver = getChromeDriver();
  private WebDriverWait wait = getWebDriverWait(5);

  private Header() {

  }

  public static Header getHeader() {
    return new Header();
  }

  public Header verifyHeaderExists() {

    assertThat(driver.findElement(By.className("page-header")).isDisplayed())
        .as("Page header is not displayed")
        .isTrue();
    return this;
  }

}
