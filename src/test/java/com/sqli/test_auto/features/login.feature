@Ready
Feature: User logging IN

  Background:
    Given from the landing page

  @ready
  Scenario Outline: User logs in with invalid credentials
    Given from the logging page
    When the user enters invalid <username> or <password>
    Then the user should see an error message
    Examples:
      | username       | password |
      | toto@gmail.com | 12345678 |



