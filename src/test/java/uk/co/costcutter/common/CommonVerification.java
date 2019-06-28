package uk.co.costcutter.common;

import static org.assertj.core.api.Assertions.assertThat;
import static uk.co.costcutter.common.DriverFactory.getChromeDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CommonVerification {

  private WebDriver driver = getChromeDriver();

  private CommonVerification() {
    // hide it
  }

  public static CommonVerification getCommonVerification() {
    return new CommonVerification();
  }

  public CommonVerification verifyIsDisplayed(By element) {

    assertThat(driver.findElement(element).isDisplayed()).isTrue();
    return this;
  }

  public CommonVerification verifyItemIsEmpty(By element) {

    assertThat(driver.findElement(element).findElements(By.xpath(".//*")).size())
        .as("Item is not empty")
        .isEqualTo(0);
    return this;
  }

  public CommonVerification verifyItemIsNotEmpty(By element) {

    assertThat(driver.findElement(element).findElements(By.xpath(".//*")).size())
        .as("Item is empty")
        .isGreaterThanOrEqualTo(1);
    return this;
  }

  public CommonVerification verifyDecendentItemCount(By element, int numberOfItems) {

    assertThat(driver.findElement(element).findElements(By.xpath(".//*")).size())
        .as("Item is empty")
        .isGreaterThanOrEqualTo(numberOfItems);
    return this;
  }

  public CommonVerification verifyPageTitle(String title) {

    assertThat(driver.getTitle())
        .as("Title is not as expected")
        .isEqualTo(title);
    return this;
  }

  public CommonVerification verifyItemText(By element, String text) {

    assertThat(driver.findElement(element).getText())
        .as("Text is not as expected")
        .isEqualTo(text);
    return this;
  }

  public CommonVerification verifyItemPlaceholder(By element, String text) {

    assertThat(driver.findElement(element).getAttribute("placeholder"))
        .as("Placeholder is not as expected")
        .isEqualTo(text);
    return this;
  }
}
