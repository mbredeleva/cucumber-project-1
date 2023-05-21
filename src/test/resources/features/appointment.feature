Feature: User makes an appointment in the system and views it

  Scenario: the user makes an appointment in Seoul for tomorrow
    Given the user opens login page
      And the user types correct credentials
      And the user is logged
    When the user selects Seoul in facility selector
      And the user selects medicaid radio button
      And the user selects tomorrow visit date
      And the user clicks submit button
    Then the user sees appointment created message
      And appointment city is Seoul
      And program is medicaid
      And visit date is tomorrow

  Scenario: the user makes an appointment and sees it in history
    Given the user opens login page
      And the user types correct credentials
      And the user selects Seoul in facility selector
      And the user selects medicaid radio button
      And the user selects tomorrow visit date
      And the user clicks submit button
      And the user sees appointment created message
    When the user clicks side menu button
      And the user clicks history
    Then the user sees history page
      And displayed facility is Seoul
      And displayed apply for hospital readmission is false
      And displayed program is medicaid
      And displayed comment is empty
      And displayed date is tomorrow