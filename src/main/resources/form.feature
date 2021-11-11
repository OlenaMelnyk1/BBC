Feature:
  As a user
  I want to test main site functionality
  So that I can be sure that site works correctly


  Scenario: Check that user can submit a question to BBC
    Given User opens form 'https://www.bbc.com/news/52143212' page
    When User fills the form with value:
      |form                                       |value|
      |What questions would you like us to answer?| Hi|
      |Name         |Elena|
      |Email address|q|
      |Contact number|01112345678|
      |Location |UK         |
      |Age           |17         |
    And User clicks Submit button
    Then User gets error message