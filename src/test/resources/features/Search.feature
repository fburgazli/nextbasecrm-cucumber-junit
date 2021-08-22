Feature:As a user, I should be able to search people,document and more from search box.



  Scenario: 1. Verify users can search a valid info from search box.(employee, doc, post, etc)
    Given User is on nextbasecrm login page
    When User enter valid "helpdesk31@cybertekschool.com" and "UserUser"
    And user is searching for "Nadir"
    Then user should see "Nadir" in result page


  Scenario: 2. users cannot find an invalid info, the page should show "" Nothing Found"" (negative)
    Given User is on nextbasecrm login page
    When User enter valid "helpdesk31@cybertekschool.com" and "UserUser"
    And user is searching for "invalid info"
    Then user should see Nothing found in result page


  Scenario: 3. users get "Employees", ""Groups"", ""Menu itemts"", and ""search"" once typing at least a letter
    Given User is on nextbasecrm login page
    When User enter valid "helpdesk31@cybertekschool.com" and "UserUser"
    And user is searching for with the first letter "a"
    Then user should see following sections in opened window
      | Employees  |
      | Groups     |
      | Menu items |
      | Search     |