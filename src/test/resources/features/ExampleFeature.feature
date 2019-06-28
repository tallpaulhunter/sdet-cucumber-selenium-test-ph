@Google
Feature: Google search

  Scenario Outline: Finding some cheese

    Given I am on the Google search <test>
    When I search for "Cheese!"
    Then the page title should start with "cheese"

Examples:
|test|
|page|
