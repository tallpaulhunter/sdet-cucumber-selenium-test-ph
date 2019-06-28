package uk.co.costcutter.pages;

import static uk.co.costcutter.common.CommonVerification.getCommonVerification;

import org.openqa.selenium.By;
import uk.co.costcutter.common.CommonVerification;

public class RecipeContainer {

  private CommonVerification commonVerification = getCommonVerification();

  private By recipeContainer = By.xpath("/html/body/section[3]");

  private RecipeContainer() {
    // hide it
  }

  public static RecipeContainer getRecipeContainer() {
    return new RecipeContainer();
  }

  public RecipeContainer verifyRecipeContainerIsDisplayed() {
    commonVerification.verifyIsDisplayed(recipeContainer);
    return this;
  }

  public RecipeContainer verifyRecipeContainerIsNotEmpty() {
    commonVerification.verifyItemIsNotEmpty(recipeContainer);
    return this;
  }

}
