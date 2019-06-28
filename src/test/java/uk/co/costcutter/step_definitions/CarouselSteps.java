package uk.co.costcutter.step_definitions;

import static uk.co.costcutter.pages.Carousel.getCarousel;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import uk.co.costcutter.pages.Carousel;

public class CarouselSteps {

  Carousel carousel = getCarousel();

  @Then("The carousel element is displayed")
  public void theCarouselElementIsDisplayed() {
    carousel.verifyCarouselIsDisplayed();
  }

  @And("The carousel element will be empty")
  public void theCarouselElementWillBeEmpty() {
    carousel.verifyCarouselIsEmpty();
  }
}
