Feature: send Message functionality
  Agile Story : As a user i should be able to send message to all employees.


  Scenario Outline: 1. users  (hr, marketing and helpdesk) send message with ""MESSAGE"" tab
    Given User is on nextbasecrm login page
    When User enter valid "<username>" and "<password>"
    When User clicks on Message Tab
    And User enters message body and click Send button
    Then User should be able to see message sent

    Examples:
      | username                       | password |
      | helpdesk31@cybertekschool.com  | UserUser |
      | marketing31@cybertekschool.com | UserUser |
      | hr31@cybertekschool.com        | UserUser |


Scenario: 2. users cancels messages
  Given User is on nextbasecrm login page
  When User enter valid "helpdesk31@cybertekschool.com" and "UserUser"
  When User clicks on Message Tab
  And User enters message body and click Cancel button
  Then User should be able to see message NOT sent


 Scenario: 3. users attach link with the link icon
    Given User is on nextbasecrm login page
    When User enter valid "helpdesk31@cybertekschool.com" and "UserUser"
    When User clicks on Message Tab
    And User enters message body and click Link button
    Then User should be able to see message sent


  Scenario: User can comment under messages
    Given User is on nextbasecrm login page
    When User enter valid "helpdesk31@cybertekschool.com" and "UserUser"
    When User clicks on Comment tab and enters the message
    And User clicks on send comment button
    Then User should be able to send comment
