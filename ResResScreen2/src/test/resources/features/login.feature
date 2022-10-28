Feature: login
  i as a user, i need login to obtain a token

  Scenario: login successful
    Given camila is a swaglabs user and wants to log in
    When We send the information required for the login
    Then he user obtain a token