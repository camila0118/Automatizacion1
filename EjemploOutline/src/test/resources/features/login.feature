Feature: Login
  i as services user i need to automate login for access the services

  Scenario: Login Successful
    Given He user is on the page
    When the user enter the credentials
      | username      | password     |
      | standard_user | secret_sauce |
    Then he could see the products
