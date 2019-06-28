@StoreFinder @StoreFinderPageElements
Feature: Verify the elements that are present on the Search page

  Background: Navigate to store finder page
    Given I navigate to store finder page
    When The store finder page is displayed

  @PageHeaderPresent
  Scenario: Page Header is present
    Then The page header element is displayed

  @CarouselWrapperPresent
  Scenario: Carousel wrapper is empty
    Then The carousel element is displayed
    And The carousel element will be empty

  @StoreFinderElementsPresent
  Scenario: Store finder elements are present
    Then The store finder breadcrumb will be "Home! > Location Finder"
    And The store finder "title banner" will be displayed
    And The store finder "find options" will be displayed
    And The store finder "Use My Postcode" items will be displayed
    And The store finder "Use My Location" items will be displayed

  @StoreFinderResultsEmpty
  Scenario: Store finder results are empty
    Then The store finder "results" will be displayed
    And The store finder "results" will be empty

  @RecipeContainerPresent
  Scenario: Recipe Container is present
    Then The recipe container will be displayed
    And The recipe container will not be empty

  @SignupPresent
  Scenario: Sign up is present
    Then The sign up element is displayed

  @FooterPresent
  Scenario: Footer is present
    Then The footer is displayed
