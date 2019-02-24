Feature: Test login feature of lemfix
  I want to use this case to test login functionality

  Scenario Outline: Test login feature of lemfix
    Given I navigated to lemfix site
    When I input "<username>" and "<password>" to login
    Then I verify login "<result>"

    Examples:
      | username        | password  | result  |
      | vincent20181030 | password1 | success |
      | vincent20000000 | password1 | fail    |