@StoreFinder @FilteredSearches
Feature: Searches utilising filters

  Background: Navigate to the Costcutter store finder
    Given I navigate to store finder page

  @IndividualFilters
  Scenario Outline: Individual filters applied
    Given Search is performed for "YO1"
    When The <filter> filter is selected
    And The "Update stores" button is selected
    Then There are <count> results returned

    Examples:
      | filter          | count |
      | Bakery          | 4     |
      | Cash Machine    | 6     |
      | Cash back       | 6     |
      | Deli Counter    | 1     |
      | Hermes          | 1     |
      | Hot Food        | 4     |
      | Local Produce   | 3     |
      | Lottery Instant | 8     |
      | News Delivery   | 1     |
      | Parking         | 3     |
      | Payzone         | 1     |
      | Photocopying    | 1     |
      | Recycle         | 1     |

  @MultipleFilters
  Scenario Outline: Multiple filters
    Given Search is performed for "YO1"
    When The "<first>" filter is selected
    And The "<second>" filter is selected
    And The "Update stores" button is selected
    Then There are <count> results returned

    Examples:
      | first  | second          | count |
      | Bakery | Lottery Instant | 4     |

  @StoresReturned
  Scenario: Stores returned for filter
    Given Search is performed for "YO1"
    When The "Cash back" filter is selected
    Then The following stores will be returned
      | store                           | miles | expanded or collapsed |
      | 83 HEWORTH ROAD, YORK           | 0.95  | expanded              |
      | 137 BECKFIELD LANE, YORK        | 2.24  | collapsed             |
      | 29 YORK STREET, DUNNINGTON      | 3.96  | collapsed             |
      | 58 MAIN STREET, WHELDRAKE       | 6.33  | collapsed             |
      | 8 WESTFIELD ROAD, YORK          | 8.54  | collapsed             |
      | 17 COMMERCIAL STREET, TADCASTER | 8.87  | collapsed             |
