# Authentication test

Feature: Authentication tests

  Scenario Outline: Test authentication
    Given i am on the authentication page
    When i log with "<login>" and "<password>"
    Then i am logged into secure area

    Examples:
      | login    | password |
      | tomsmith | SuperSecretPassword! |
      | ronfloyd | wrongPassword! |
      | benSwanson | wrongPassword* |
