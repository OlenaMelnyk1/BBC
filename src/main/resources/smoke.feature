Feature:
  As a user
  I want to test main site functionality
  So that I can be sure that site works correctly

  Background:
    Given User opens 'https://www.bbc.com/' page
    And User clicks on button News
    And User checks page News visibility

  Scenario Outline: Checks name of the headline article in News
    Then User checks the name of the headline article '<ArticleName>'
    Examples:
      |ArticleName|
      |Deadly storm cuts transport links around Vancouver|


  Scenario: Checks names of all articles in News
    Then User checks the names of all articles
      |State of emergency declared after Canada storm|
      |Germany hit by full force of Covid, warns Merkel|
      |What England's cricket racism scandal is all about|
      |Britney Spears: Life after conservatorship|
      |Capitol riot: 'QAnon Shaman' sentenced to prison|


  Scenario Outline: Checks search by category name in News
    Given User collects names of all Category of the headline and checks '<CategoryName>'
    And User inputs name of Category into '<CategoryName>' Search field
    And User checks page Search page visibility
    Then User checks '<CategoryName>' of the first article
    Examples:
      |CategoryName|
      |Video|


