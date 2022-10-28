Feature: critical flow article
  As a user I
  need to log in the page and create a article, update article, view a article and delete article

  Scenario Outline: critical article
    Given Kevin go to the webside

    When create a article, update a article, view a article and delete a article
      | email           | <email>           |
      | password        | <password>        |
      | titleArticle    | <titleArticle>    |
      | articleTopic    | <articleTopic>    |
      | description     | <description>     |
      | tags            | <tags>            |
      | newtitleArticle | <newtitleArticle> |
      | newarticleTopic | <newarticleTopic> |
      | newdescription  | <newdescription > |

    Then validation the message "No articles are here... yet."

    Examples:
    | email             | password | titleArticle | articleTopic | description         | tags | newtitleArticle | newarticleTopic | newdescription |
    | kevin12@anaya.com | pass12   | Silla        | new silla    | silla para sentarse | hola | olla            | new olla        | olla a presion |


