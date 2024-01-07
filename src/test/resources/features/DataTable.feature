@DataTable
Feature: Data Table Demo
  Scenario: Data Table Single value
    Given I have a List of names
      | Johne |
      | Max   |
      | Tien  |

  Scenario: Data Table double value
    Given I have a List of names and age
      | name  | age |
      | Johne | 29  |
      | Max   | 30  |
      | Tien  | 18  |