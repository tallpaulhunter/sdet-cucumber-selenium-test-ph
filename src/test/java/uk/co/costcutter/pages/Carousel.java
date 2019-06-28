package uk.co.costcutter.pages;

import static uk.co.costcutter.common.CommonVerification.getCommonVerification;

import org.openqa.selenium.By;
import uk.co.costcutter.common.CommonVerification;

public class Carousel {

  private CommonVerification commonVerification = getCommonVerification();

  private By carouselWrapper = By.className("carousel-wrapper");

  private Carousel() {
    // hide it
  }

  public static Carousel getCarousel() {
    return new Carousel();
  }

  public Carousel verifyCarouselIsDisplayed() {
    commonVerification.verifyIsDisplayed(carouselWrapper);
    return this;
  }

  public Carousel verifyCarouselIsEmpty() {
    commonVerification.verifyItemIsEmpty(carouselWrapper);
    return this;
  }
}
