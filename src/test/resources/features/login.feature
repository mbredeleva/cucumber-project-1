Feature: User logins in the system

  Scenario: Successful login
    Given the user opens login page
    When the user types correct credentials
    Then the user is logged

  Scenario: Unsuccessful login
    Given the user opens login page
    When the user types incorrect credentials
    Then the user sees incorrect credentials error message