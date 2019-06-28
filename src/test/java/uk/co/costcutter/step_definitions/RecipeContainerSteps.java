package uk.co.costcutter.step_definitions;

import static uk.co.costcutter.pages.RecipeContainer.getRecipeContainer;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import uk.co.costcutter.pages.RecipeContainer;

public class RecipeContainerSteps {

  RecipeContainer recipeContainer = getRecipeContainer();

  @Then("The recipe container will be displayed")
  public void theRecipeContainerWillBeDisplayed() {
    recipeContainer.verifyRecipeContainerIsDisplayed();
  }

  @And("The recipe container will not be empty")
  public void theRecipeContainerWillNotBeEmpty() {
    recipeContainer.verifyRecipeContainerIsNotEmpty();
  }
}
