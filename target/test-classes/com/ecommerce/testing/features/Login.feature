@Login
Feature: Login with Multiple Credentials

  Scenario Outline: Login with "<username>" and "<password>"

    Given the user is on the login page
    When the user provides valid "<username>" and "<password>"
    Then the user should be redirected to the home page

Examples:
  | username        | password     |
  | standard_user   | secret_sauce |
  | locked_out_user | secret_sauce |

