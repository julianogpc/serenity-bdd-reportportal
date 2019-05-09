Feature: Search on Google

  Scenario: Search on Google - Sucess
    Given that I have gone to the Google page
    When I add "cats" to the search box
    And submit the search
    Then "cats" should be mentioned in the results

  Scenario: Search on Google - Failed
    Given that I have gone to the Google page
    When I add "cats" to the search box
    And submit the search
    Then "parrots" should be mentioned in the results