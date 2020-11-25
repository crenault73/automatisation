# Authentication test

Feature: Authentication tests

  Scenario Outline: Test authentication with login and password
    Given i am on the authentication page
    When i log with "<login>" and "<password>"
    Then i am logged into secure area

    Examples:
      | login    | password |
      | tomsmith | SuperSecretPassword! |
      | ronfloyd | wrongPassword! |
      | benSwanson | wrongPassword* |


  Scenario Outline: Test authentication with user
    Given i am on the authentication page
    When i log with "<user>"
    Then i am logged into secure area

    Examples:
      | user       |
      | tomsmith   |
      | ronfloyd   |
      | benSwanson |
