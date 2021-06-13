@feature-guru-03 @order-and-return
Feature: User Management
  As a user
  I want to order and return

  @mc-0301 @smoke
  Scenario: Register New User
    Given I access to Orders and Returns page
    When I order and return by "Email"
    Then I order successfully