@feature-guru-01 @login
Feature: User Management
  As a user
  I want to login

  @mc-0101 @regression @sanity
  Scenario: Login with correct password only
    Given I access to Login Function
    Then I login