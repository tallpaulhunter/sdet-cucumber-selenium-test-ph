@StoreFinder @ResultAppearance
Feature: Verify the Results appearance

  Background: Navigate to the Costcutter store finder
    Given I navigate to store finder page
    When Search is performed for "YO1"

  Scenario: Result Items are all present for first result
    Then 14 stores are returned near "York YO1, UK"
    And Result item 1 elements will be displayed

  Scenario: Result Items are all present for second result
    Then 14 stores are returned near "York YO1, UK"
    And Result item 2 elements will be displayed

