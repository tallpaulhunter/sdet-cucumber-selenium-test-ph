@StoreFinder @PostcodeSearches
Feature: Postcode searches

  Background: Navigate to the Costcutter store finder
    Given I navigate to store finder page

  @PostcodeFirstPart
  Scenario: Search using first part of postcode YO1
    When Search is performed for "YO1"
    Then 14 stores are returned near "York YO1, UK"
    And The following stores are returned
      | store                     | miles | expandedcollapsed |
      | 12 - 14 BISHOPTHORPE ROAD | 0.54  | expanded          |
      | YORK HOSPITAL             | 0.72  | collapsed         |
      | 83 HEWORTH ROAD           | 0.95  | collapsed         |
      | 13 - 15 WAINS GROVE       | 2.19  | collapsed         |
      | 137 BECKFIELD LANE        | 2.24  | collapsed         |
      | BRAMHAM ROAD              | 2.55  | collapsed         |
      | 29 YORK STREET            | 3.96  | collapsed         |
      | HARVEST MILLS             | 4.35  | collapsed         |
      | HARVEST MILLS             | 4.35  | collapsed         |
      | 58 MAIN STREET            | 6.33  | collapsed         |
      | 28 MAIN STREET            | 7.73  | collapsed         |
      | 8 WESTFIELD ROAD          | 8.54  | collapsed         |
      | 17 COMMERCIAL STREET      | 8.87  | collapsed         |
      | 60 STUTTON ROAD           | 9.70  | collapsed         |
  # Two instances of Harvest Mills seen - Duplication in DB?

  @PostcodeShort
  Scenario: Search using a valid short postcode YO1 7LZ
    When Search is performed for "YO1 7LZ"
    Then 14 stores are returned near "Shambles, York YO1 7LZ, UK"
    And The following stores are returned
      | store                     | miles | expandedcollapsed |
      | 12 - 14 BISHOPTHORPE ROAD | 0.57  | expanded          |
      | YORK HOSPITAL             | 0.68  | collapsed         |
      | 83 HEWORTH ROAD           | 0.94  | collapsed         |
      | 13 - 15 WAINS GROVE       | 2.21  | collapsed         |
      | 137 BECKFIELD LANE        | 2.22  | collapsed         |
      | BRAMHAM ROAD              | 2.54  | collapsed         |
      | 29 YORK STREET            | 3.98  | collapsed         |
      | HARVEST MILLS             | 4.37  | collapsed         |
      | HARVEST MILLS             | 4.37  | collapsed         |
      | 58 MAIN STREET            | 6.37  | collapsed         |
      | 28 MAIN STREET            | 7.76  | collapsed         |
      | 8 WESTFIELD ROAD          | 8.52  | collapsed         |
      | 17 COMMERCIAL STREET      | 8.88  | collapsed         |
      | 60 STUTTON ROAD           | 9.71  | collapsed         |

  @PostcodeFull
  Scenario: Search using a valid full postcode YO12 6QL
    When Search is performed for "YO12 6QL"
    Then 3 stores are returned near "Scarborough YO12 6QL, UK"
    And The following stores are returned
      | store               | miles | expandedcollapsed |
      | 2 FRANKLIN STREET   | 0.98  | expanded          |
      | 3 RAMSHILL ROAD     | 1.45  | collapsed         |
      | 31-35 RAMSHILL ROAD | 1.47  | collapsed         |

  @PostcodeSymbol
  Scenario: Search using a single symbol
    When Search is performed for "$"
    Then No search results are returned

  @PostcodeSymbols
  Scenario: Search using a number of symbols
    When Search is performed for "!@£"
    Then No search results are returned

  @PostcodeContained
  Scenario: Search using a postcode containing a symbol
    When Search is performed for "Y)1 7LZ"
    Then No search results are returned

  @PostcodeSymbolAddedAtEnd
  Scenario: Search using a valid postcode with a symbol added
    # Given
    When Search is performed for "YO1 7LZ$"
    Then 14 stores are returned near "Shambles, York YO1 7LZ, UK"
    And The following stores are returned
      | store                     | miles | expandedcollapsed |
      | 12 - 14 BISHOPTHORPE ROAD | 0.57  | expanded          |
      | YORK HOSPITAL             | 0.68  | collapsed         |
      | 83 HEWORTH ROAD           | 0.94  | collapsed         |
      | 13 - 15 WAINS GROVE       | 2.21  | collapsed         |
      | 137 BECKFIELD LANE        | 2.22  | collapsed         |
      | BRAMHAM ROAD              | 2.54  | collapsed         |
      | 29 YORK STREET            | 3.98  | collapsed         |
      | HARVEST MILLS             | 4.37  | collapsed         |
      | HARVEST MILLS             | 4.37  | collapsed         |
      | 58 MAIN STREET            | 6.37  | collapsed         |
      | 28 MAIN STREET            | 7.76  | collapsed         |
      | 8 WESTFIELD ROAD          | 8.52  | collapsed         |
      | 17 COMMERCIAL STREET      | 8.88  | collapsed         |
      | 60 STUTTON ROAD           | 9.71  | collapsed         |

  @PostcodeInvalid
  Scenario: Search using a reversed postcode
      # Given
    When Search is performed for "7LZ YO1"
    Then 14 stores are returned near "Shambles, York YO1 7LZ, UK"
    And The following stores are returned
      | store                     | miles | expandedcollapsed |
      | 12 - 14 BISHOPTHORPE ROAD | 0.57  | expanded          |
      | YORK HOSPITAL             | 0.68  | collapsed         |
      | 83 HEWORTH ROAD           | 0.94  | collapsed         |
      | 13 - 15 WAINS GROVE       | 2.21  | collapsed         |
      | 137 BECKFIELD LANE        | 2.22  | collapsed         |
      | BRAMHAM ROAD              | 2.54  | collapsed         |
      | 29 YORK STREET            | 3.98  | collapsed         |
      | HARVEST MILLS             | 4.37  | collapsed         |
      | HARVEST MILLS             | 4.37  | collapsed         |
      | 58 MAIN STREET            | 6.37  | collapsed         |
      | 28 MAIN STREET            | 7.76  | collapsed         |
      | 8 WESTFIELD ROAD          | 8.52  | collapsed         |
      | 17 COMMERCIAL STREET      | 8.88  | collapsed         |
      | 60 STUTTON ROAD           | 9.71  | collapsed         |


  @PostcodeExtraCharacter
  Scenario: Search using a postcode with an extra character
    When Search is performed for "YO1 7LZA"
    Then 14 stores are returned near "York YO1, UK"
    And The following stores are returned
      | store                     | miles | expandedcollapsed |
      | 12 - 14 BISHOPTHORPE ROAD | 0.54  | expanded          |
      | YORK HOSPITAL             | 0.72  | collapsed         |
      | 83 HEWORTH ROAD           | 0.95  | collapsed         |
      | 13 - 15 WAINS GROVE       | 2.19  | collapsed         |
      | 137 BECKFIELD LANE        | 2.24  | collapsed         |
      | BRAMHAM ROAD              | 2.55  | collapsed         |
      | 29 YORK STREET            | 3.96  | collapsed         |
      | HARVEST MILLS             | 4.35  | collapsed         |
      | HARVEST MILLS             | 4.35  | collapsed         |
      | 58 MAIN STREET            | 6.33  | collapsed         |
      | 28 MAIN STREET            | 7.73  | collapsed         |
      | 8 WESTFIELD ROAD          | 8.54  | collapsed         |
      | 17 COMMERCIAL STREET      | 8.87  | collapsed         |
      | 60 STUTTON ROAD           | 9.70  | collapsed         |

  @PostcodeInvalidFormat
  Scenario: Search using a postcode with an extra character
    When Search is performed for "YAB 7LZ"
    Then No search results are returned
