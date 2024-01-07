@Logins
Feature: Login Function

  Background: Pre-condition
    Given User access to login page

  Scenario Outline: User logged-in successfully with standard account
    When User type <Username> into Username field
    And User type <Password> into Password field
    And User click on login button
    Then Verify Inventory page is displayed

    Examples:
      | Username      | Password     |
      | standard_user | secret_sauce |


  Scenario Outline: User logged-in Failure
    When User type <Username> into Username field
    And User type <Password> into Password field
    And User click on login button
    Then Verify Error Message is displayed with message <ErrorMessage>

    Examples:
      | Username        | Password     | ErrorMessage                                                               |
      | abc_user        | secret_sauce | Epic sadfaces: Username and password do not match any user in this service |
      | locked_out_user | secret_sauce | Epic sadface: Sorry, this user has been locked out.                        |