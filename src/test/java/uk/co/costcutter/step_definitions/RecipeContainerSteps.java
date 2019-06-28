package uk.co.costcutter.step_definitions;

import static uk.co.costcutter.pages.RecipeContainer.getRecipeContainer;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.co.costcutter.pages.RecipeContainer;

public class RecipeContainerSteps {

  private static final Logger LOG = LoggerFactory.getLogger(RecipeContainerSteps.class);

  private RecipeContainer recipeContainer = getRecipeContainer();

  @Then("The recipe container will be displayed")
  public void theRecipeContainerWillBeDisplayed() {

    LOG.info("Executing step: The recipe container will be displayed");
    recipeContainer.verifyRecipeContainerIsDisplayed();
  }

  @And("The recipe container will not be empty")
  public void theRecipeContainerWillNotBeEmpty() {

    LOG.info("Executing step: The recipe container will not be empty");
    recipeContainer.verifyRecipeContainerIsNotEmpty();
  }
}
