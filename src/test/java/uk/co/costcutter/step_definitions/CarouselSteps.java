package uk.co.costcutter.step_definitions;

import static uk.co.costcutter.pages.Carousel.getCarousel;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.co.costcutter.pages.Carousel;

public class CarouselSteps {

  private static final Logger LOG = LoggerFactory.getLogger(CarouselSteps.class);

  private Carousel carousel = getCarousel();

  @Then("The carousel element is displayed")
  public void theCarouselElementIsDisplayed() {

    LOG.info("Executing step: The carousel element is displayed");
    carousel.verifyCarouselIsDisplayed();
  }

  @And("The carousel element will be empty")
  public void theCarouselElementWillBeEmpty() {

    LOG.info("Executing step: The carousel element will be empty");
    carousel.verifyCarouselIsEmpty();
  }
}
