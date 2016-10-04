Feature: Apple count

  Scenario: Apples get lost
    Given I have 5 apples
    When I loose 2 apples
    Then I have 3 apples left