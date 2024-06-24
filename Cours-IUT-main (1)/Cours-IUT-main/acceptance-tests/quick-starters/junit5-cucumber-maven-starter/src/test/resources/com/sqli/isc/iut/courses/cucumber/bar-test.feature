Feature: Visit to the Juste bar

  Background: A bar with limited seats
    Given there are only 10 seats in the bar

  Scenario: Refuse entry when the bar is full
    Given there are already 9 people in the bar
    When Mr. Pignon and Mr. Leblanc arrive in group
    Then they are refused entry
    And the bar displays "Full"

  Scenario: Allow entry and order cocktails when bar is almost full
    Given there are already 8 people in the bar
    When Mr. Pignon and Mr. Leblanc arrive in group
    Then they are allowed entry
    And the person behind them is refused entry with "Full"
    When they order a "cocktail of the month"
    And Mr. Leblanc pays for both
    Then the bill shows 20 euros
    And Mr. Pignon is happy because they had only one drink

  Scenario: Order individually and Mr. Leblanc orders more when bar is not full
    Given there are already 3 people in the bar
    When Mr. Pignon and Mr. Leblanc arrive
    Then they are allowed entry
    When they order a "cocktail of the month"
    And Mr. Pignon pays for his drink
    And Mr. Leblanc orders 2 more "cocktail of the month"
    Then the bill for Mr. Leblanc shows 30 euros
    And Mr. Pignon is sad because he knows Mr. Leblanc will have a bad night

  Scenario: Allow single entry when bar is almost full
    Given there are already 9 people in the bar
    When only Mr. Pignon arrives in solo
    Then he is allowed entry
    And the bar does not display "Full"
