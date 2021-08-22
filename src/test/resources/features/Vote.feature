Feature:US-5. As a user, I should be able to vote for a poll


  Scenario: 1. users  (hr, marketing and helpdesk)  can select an answer to vote a poll.
  (this scenario has a pre-condition: at least one poll should be created)
    Given User is on nextbasecrm login page
    When User enter valid "helpdesk31@cybertekschool.com" and "UserUser"
    And user select an answer to vote the poll
    And user clicks Vote button
    Then user should be able to see Vote Again button


 Scenario: 2. users can use ""vote again"" button to select different answer
   Given User is on nextbasecrm login page
   When User enter valid "helpdesk31@cybertekschool.com" and "UserUser"
   And user clicks Vote again button
   And user select an answer to vote the poll
   And user clicks Vote button
   Then user should be able to see Vote Again button


  Scenario: 3. only vote owner stop the poll with ""STOP"" button
#  (no negative scenario for this functionality because otehr non owner user cannot see stop button)

   Given User is on nextbasecrm login page
   When User enter valid "helpdesk31@cybertekschool.com" and "UserUser"
   Then user can Stop the poll which he-she created
    And user should be able to see Results button is displayed
