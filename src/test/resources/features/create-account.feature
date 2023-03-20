Feature: Create Account

  Scenario: An account is created

    Given user wants to create an account
      | id  | name   | email               |
      | 100 | Rachel | rachel.green@fs.com |

    When account is saved
    Then the save 'IS SUCCESSFUL'
    #AND The response Content to create account should be