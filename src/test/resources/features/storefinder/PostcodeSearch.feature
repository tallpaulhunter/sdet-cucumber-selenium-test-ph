@StoreFinder @PostcodeSearches
Feature: Postcode searches

  Background: Navigate to the Costcutter store finder
    Given I navigate to store finder page

  @PostcodeFirstPart
  Scenario: Search using first part of postcode YO1
    When Search is performed for "YO1"
    Then 14 stores are returned
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

  @PostcodeShort
  Scenario: Search using a valid short postcode YO1 7LZ
    # Given
    When Search is performed for "YO1 7LZ"
    # Then

  @PostcodeFull
  Scenario: Search using a valid short postcode YO1 7LZ
    # Given
    When Search is performed for "YO13 0QA"
    # change to other place
    # Then

  @PostcodeSymbol
  Scenario: Search using a single symbol
    # Given
    When Search is performed for "$"
    # Then

  @PostcodeSymbols
  Scenario: Search using a number of symbols
    # Given
    When Search is performed for "!@£"
    # Then

  @PostcodeContained
  Scenario: Search using a postcode containing a symbol
    # Given
    When Search is performed for "Y)1 7LZ"
    # Then

  @PostcodeSymbolAddedAtEnd
  Scenario: Search using a valid postcode with a symbol added
    # Given
    When Search is performed for "YO1 7LZ$"
    # Then

  @PostcodeInvalid
  Scenario: Search using an invalid postcode
      # Given
    When Search is performed for "7LZ YO1"
      # Then

  @PostcodeInvalidFormat
  Scenario: Search using an invalid postcode
      # Given
    When Search is performed for "YO1 7LZA"
      # Then
