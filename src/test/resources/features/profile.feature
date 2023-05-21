Feature: User views their profile

  Scenario: User opens profile
    Given the user opens login page
      And the user types correct credentials
      And the user is logged
    When the user clicks side menu button
      And the user clicks profile
    Then the user sees profile page
      And the user sees under construction message