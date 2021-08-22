@login
Feature: nextbasecrm login functionality
  Agile story: As a user , I should be able to login to nexctbasecrm.

  Scenario Outline: 1. users (hr, marketing and helpdesk) login with valid credentials
    Given User is on nextbasecrm login page
    When User enter valid "<username>" and "<password>"
    Then User should be able to login
    Then close the browser

    Examples:
      | username                       | password |
      | helpdesk31@cybertekschool.com  | UserUser |
      | helpdesk32@cybertekschool.com  | UserUser |
      | marketing31@cybertekschool.com | UserUser |
      | marketing32@cybertekschool.com | UserUser |
      | hr31@cybertekschool.com        | UserUser |
      | hr32@cybertekschool.com        | UserUser |


  Scenario Outline: 2. users cannot login with invalid credentials. (Negative )
    Given User is on nextbasecrm login page
    When User enter invalid "<username>" or "<password>"
    Then User should NOT able to login

    Examples:
      | username                      | password |
      |                               |          |
      | helpdesk32@cybertekschool.com | useruser |
      | marketing31@cybertekschool    | UserUser |
      | marketing32@cybertekschool    | abcdefs  |
      | hr31                          | UserUser |
      | @cybertekschool.com           | UserUser |



  Scenario: 3. users can check "Remember me on this computer" option
    Given User is on nextbasecrm login page
    When User clicks on Remember me on this computer checkbox
    Then Remember me on this computer is selected with a tick
    Then close the browser


  Scenario: 4. users access to  "FORGOT YOUR PASSWORD?" link page

    Given User is on nextbasecrm login page
    When User clicks on FORGOT YOUR PASSWORD? link
    Then User navigated to Get Password page
    Then close the browser