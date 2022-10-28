Feature: Demoqa
  as a user I want to enter demoqa

  Scenario: enter data in the form
    Given he user open the page
    When he user enter data
      | name   | email            | adress  | adresspermanent |
      | camila | camila@gmail.com | popayan | popayan_cauca   |
    Then the user verifies entered data
