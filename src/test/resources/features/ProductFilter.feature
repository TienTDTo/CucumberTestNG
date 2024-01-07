@ProductFilter
Feature: Product Filter
  Background: Pre-condition
    Given User access to login page
    When User type standard_user into Username field
    And User type secret_sauce into Password field
    And User click on login button
    Then Verify Inventory page is displayed

    Scenario Outline: Verify Filter for price
      When User select price filter <Filter>
      Then Verify that products are sorted by <Filter>

      Examples:
        | Filter |
        | HILO   |
        | LOHI   |