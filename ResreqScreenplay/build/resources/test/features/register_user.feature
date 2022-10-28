Feature: Register tu users
  i as a user, i need register to user for can login

  @post
  Scenario: Register Successful
    Given Camila is client that can managment his bank products
    When We send the information required for the register
    Then he should see a virtual account for can login into page

  @put
  Scenario: put the user
    Given Camila is client that can managment his bank products
    When he send the information for put
    Then he should see put

  @get
  Scenario: get list user
    Given Camila is client that can managment his bank products
    When he capture the list
    Then he should the data list

  @post_conduit
  Scenario: Login successful
    Given Camila is client that can managment his  products and articles
    When We send the information required for the login
    Then he should see the articles and products into page


  @post_conduit_outline
  Scenario Outline: Login successful2
    Given Camila is client that can managment his  products and articles
    When the enter credentiales "<email>" and "<password>"
    Then he should see the articles and products into pages
    Examples:
      | email              | password |
      | maob13@yopmail.com | 1234     |
      | jarv078@gmail.com  | 123qwe   |
      | camila@gmail.com   | 12345    |

  @delete
  Scenario: delete articles
    Given Camila is client that can managment his bank products
    When we see articles for the delete
    Then see that the articles are deleted


