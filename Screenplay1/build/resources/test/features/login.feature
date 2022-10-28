Feature: login in the page
  i as services user i need to automate login for access the services

  Scenario Outline: login Successfull
    Given he user in the page
    When he user entre in the page
      | username   | password   |
      | <username> | <password> |
    Then he user could see the products

    Examples:
      | username                | password     |
      | locked_out_user         | secret_sauce |
      | standard_user           | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |
