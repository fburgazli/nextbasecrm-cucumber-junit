Feature:


  Scenario: 1. users  (hr, marketing and helpdesk) create a poll with Q/A
    Given User is on nextbasecrm login page
    When User enter valid "helpdesk31@cybertekschool.com" and "UserUser"
    And user navigates to Poll page
    And user writes "Good morning SDETs!Please participate in the following survey!" and question with options and click Send button
    Then user should be able to see Poll is sent


  Scenario: 2. users get error message ""The message title is not specified"
  when they are trying to create a poll without poll title (negative )
    Given User is on nextbasecrm login page
    When User enter valid "helpdesk31@cybertekschool.com" and "UserUser"
    And user navigates to Poll page
    And user writes "" and question with options and click Send button
    Then user get error message: The message title is not specified


  Scenario: 3. users check ""allow multiple Choice"" while create a poll
    Given User is on nextbasecrm login page
    When User enter valid "helpdesk31@cybertekschool.com" and "UserUser"
    And user navigates to Poll page
    And user check allow multiple Choice
    Then user should be able to see allow multiple Choice is selected


  Scenario: 4. users can add more questions to a poll
    Given User is on nextbasecrm login page
    When User enter valid "helpdesk31@cybertekschool.com" and "UserUser"
    And user navigates to Poll page
    And user click on add more questions link
    Then user should be able to see another question added


  Scenario: 5. users are able to cancel creating a poll
    Given User is on nextbasecrm login page
    When User enter valid "helpdesk31@cybertekschool.com" and "UserUser"
    And user navigates to Poll page
    And user click on cancel button
    Then user should not be able to see Cancel button on the page

