# Checkboxes test
@Checkbox
Feature: Checkboxes tests

  Scenario: Check checkbox 1
    When i am on the checkboxes page
    And i click on the checkbox 1
    Then checkbox 1 is checked

  Scenario: Uncheck checkbox 2
    When i am on the checkboxes page
    And i click on the checkbox 2
    Then checkbox 2 is unchecked



