# Smoke test
@SmokeTests
Feature: Smoke tests

  Scenario: Homepage is visible
    When i am on the site
    Then i can see a page
