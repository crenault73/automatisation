# Drag and drop test
@Dragndrop
Feature: Drag and drop tests

  Scenario: Drag and drop element
    When i am on the dragndrop page
    And i move A to B
    Then i see B in place of A