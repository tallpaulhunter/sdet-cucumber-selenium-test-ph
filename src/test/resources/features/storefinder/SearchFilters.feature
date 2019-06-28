@StoreFinder @FilteredSearches
Feature: Searches utilising filters

  Background: Navigate to the Costcutter store finder
    Given I navigate to store finder page
    When Search is performed for "YO1"
    And 14 stores are returned near "York YO1, UK"

  @IndividualFilters
  Scenario Outline: Individual filters applied
    When The "<filter>" filter is selected
    And The Update stores button is selected
    Then <count> stores are returned near "York YO1, UK"

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
    When The "<first>" filter is selected
    And The "<second>" filter is selected
    And The Update stores button is selected
    Then <count> stores are returned near "York YO1, UK"

    Examples:
      | first  | second          | count |
      | Bakery | Lottery Instant | 4     |

  @StoresReturned
  Scenario: Stores returned for filter
    When The "Cash back" filter is selected
    And The Update stores button is selected
    Then 6 stores are returned near "York YO1, UK"
    And The following stores are returned
      | store                | miles | expandedcollapsed |
      | 83 HEWORTH ROAD      | 0.95  | expanded          |
      | 137 BECKFIELD LANE   | 2.24  | collapsed         |
      | 29 YORK STREET       | 3.96  | collapsed         |
      | 58 MAIN STREET       | 6.33  | collapsed         |
      | 8 WESTFIELD ROAD     | 8.54  | collapsed         |
      | 17 COMMERCIAL STREET | 8.87  | collapsed         |
