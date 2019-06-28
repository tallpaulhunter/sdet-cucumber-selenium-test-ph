@StoreFinder @StoreFinderCurrentLocation
Feature: Verify that the current location search works as expected

  Background: Navigate to the Costcutter store finder
    Given I navigate to store finder page

  Scenario: Local Location Based search returns expected results
    When I set the default location to "Leeds"
    And I select the Location button
    Then 14 stores are returned near "The Headrow"
    And The following stores are returned
      | store                    | miles | expandedcollapsed |
      | LEEDS GENERAL INFIRMARY  | 0.36  | expanded          |
      | LEEDS GENERAL INFIRMARY  | 0.36  | collapsed         |
      | 3-5 BLENHEIM VIEW        | 0.83  | collapsed         |
      | BEXLEY WING              | 1.09  | collapsed         |
      | CHANCELLOR WING ENTRANCE | 1.09  | collapsed         |
      | GLEDHOW WING             | 1.09  | collapsed         |
      | 199/203 CHAPELTOWN ROAD  | 1.28  | collapsed         |
      | 1 TONG APPROACH          | 3.26  | collapsed         |
      | 478 BROAD LANE           | 4.15  | collapsed         |
      | 3/5 DUDLEY AVENUE        | 6.10  | collapsed         |
      | 194 BARKEREND ROAD       | 8.01  | collapsed         |
      | 10 BRUNSWICK STREET      | 8.26  | collapsed         |
      | 196-198 LEEDS ROAD       | 9.17  | collapsed         |
      | 48 HOLROYD HILL          | 9.37  | collapsed         |

  Scenario: Foreign Location Based search returns 0 results
    When I set the default location to "Paris"
    And I select the Location button
    Then 0 stores are returned near "Rue de Rivoli Paris"
