Feature: register
  As a user I
  need to register in to the page

  Scenario Outline: register successful

    Given Kevin go to the webside

    When  enter the sign up credential
    | username | <username> |
    | email    | <email>    |
    | password | <password> |

    Then validate that the new username is  "Kevin12"

    Examples:
    | username   | email             | password |
    | Kevin12    | kevin12@anaya.com | pass12    |