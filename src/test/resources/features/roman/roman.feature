Feature: Roman number converter

  Scenario: Convert to roman numeral
    Given roman numeral converter is available
    When I input 1 into the converter
    Then I get the roman numeral I

  Scenario Outline: Convert to roman numerals
    Given roman numeral converter is available
    When I input <number> into the converter
    Then I get the roman numeral <romannumeral>
    Examples:
      | number | romannumeral |
      | 1      | I            |
      | 2      | II           |
      | 4      | IV           |
      | 5      | V            |