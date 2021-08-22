Feature: US#6. As a user, I should be able to log work hours with time reporting.



  Scenario: 1. users  (hr, marketing and helpdesk) start time tracking with ""Clock in"" button
    Given User is on nextbasecrm login page
    When User enter valid "helpdesk32@cybertekschool.com" and "UserUser"
    And user clicks on time management tab
    And user clicks on Clock in button
    Then user should be able to clock in


 Scenario: 2. users stop tracking with ""CLOCK OUT"" button when work hour is end
   Given User is on nextbasecrm login page
   When User enter valid "helpdesk32@cybertekschool.com" and "UserUser"
   And user clicks on time management tab
   And user clicks on Clock out button
   Then user should be able to clock out


  Scenario: 3. users create a new task for daily plan
    Given User is on nextbasecrm login page
    When User enter valid "helpdesk32@cybertekschool.com" and "UserUser"
    And user clicks on time management tab
    And user creates a new task "CRM US-6 AC#3"
    Then user should be able to see new task "CRM US-6 AC#3" is created

  @wip
  Scenario: 4. users add an event with starting and ending time
    Given User is on nextbasecrm login page
    When User enter valid "helpdesk32@cybertekschool.com" and "UserUser"
    And user clicks on time management tab
    And user creates a new event "Demo meeting with PO" with start time "04:00 pm" and end time "05.30 pm"
    Then user should be able to see new event "Demo meeting with PO" is created


#  Scenario: 5. users edit work day starting and ending time.
