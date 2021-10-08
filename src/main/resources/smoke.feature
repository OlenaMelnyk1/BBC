Feature:
  As a user
  I want to test main site functionality
  So that I can be sure that site works correctly

Scenario Outline: Checks name of the headline article in News
  Given User opens '<HomePage>' page
  And User clicks on button News
  And User checks page News visibility
  Then User checks the name of the headline article '<ArticleName>'
Examples:
|HomePage|ArticleName|
|https://www.bbc.com/|Secret assets of Kenyan president’s family exposed|


  Scenario: Checks names of all articles in News
    Given User opens 'https://www.bbc.com/' page
    And User clicks on button News
    And User checks page News visibility
    Then User checks the names of all articles
      |Secret assets of Kenyan president’s family exposed|
      |Leaders respond to Pandora Papers leaks3 minutes ago|
      |How world is reporting leaks on powerful leaders|
      |Facebook whistleblower reveals identity|
      |Sense of touch and heat research wins Nobel Prize|
      |Billie Eilish to headline Glastonbury 2022|
      |A bitter battle rages in Florida over vaccines|
      |UK military starts fuel deliveries to boost supplies|
      |Deadly cyclone Shaheen batters Oman and Iran|
      |Muhammad cartoonist Lars Vilks dies in car crash|
      |Cuban players in largest defection in years|
      |Evergrande shares halted as 'major' update awaited|
      |Chinese character removed from Walliams book|
      |India to pay $674 for every Covid-19 death|
      |Secret wealth of leaders exposed in document leak|
      |King of Jordan amassed £70m secret property empire|
      |A simple guide to the Pandora Papers leak|
      |Your guide to nine years of finance leaks|
      |Send us your questions about the Pandora Papers|
      |Sons of Mocímboa: Mozambique’s terrorism crisis|
      |BBC World News TV|
      |BBC World Service Radio|
      |Life at sea by world's largest offshore wind farm|
      |The Afghan children hiding under moving lorries|
      |New lava flows formed as La Palma eruption intensifies|
      |Building a Gothic palace with my dad|
      |The pioneer Scots photographer who captured China|
      |Why depicting the Prophet Muhammad causes offence|
      |How Modi speaks the language of India's millennials|
      |Covid vaccines: How fast is worldwide progress?|
      |From monk to soldier - how war has split a church|
      |How scientists deal with their climate change anxiety|
      |Tuna corruption scandal puts Mozambique on trial|
      |‘I wish I hadn’t bought my flat, it’s halved in value’|
      |Female Afghan judges hunted by the murderers they convicted|
      |The #MeToo icon China is trying to silence|
      |A baby, job loss - and now eviction|
      |'In my business, you eat what you kill'|
      |Why women are so burned out|
      |Why our future may be on the water|
      |Eight TV shows to watch this October|
      |Costa Rica's answer to 'range anxiety'|
      |Why hard workers often go unnoticed|
      |Scotland's version of 'hygge'|
      |Mbappe 'wanted to leave' PSG in summer|
      |Brady breaks passing record in Bucs win at Patriots|
      |ECB to decide on Ashes tour this week|
      |Wilder an atomic bomb - champion Fury|
      |Osaka drops out of top 10 in rankings for first time in three years|
      |Watford in talks to appoint Ranieri|

  Scenario Outline: Checks search by category name in News
    Given User opens '<HomePage>' page
    And User clicks on button News
    And User checks page News visibility
    And User collects names of all Category of the headline and checks '<CategoryName>'
    And User inputs name of Category into '<CategoryName>' Search field
    And User checks page Search page visibility
    Then User checks '<CategoryName>' of the first article
    Examples:
      |HomePage|CategoryName|
      |https://www.bbc.com/|Video|

  Scenario Outline: Check that user can submit a question to BBC
    Given User opens '<HomePage>' page
    And User clicks on button News
    And User checks page News visibility
    And User clicks on button Coronavirus
    And User clicks on button Your Coronavirus Stories
    And User inputs data in fields '<TextMessage>' '<Name>' '<Email>' '<Contact>' '<Location>'
    Examples:
      |HomePage            |SearchPhrase          |TextMessage|Name |Email  |Contact    |Location|
      |https://www.bbc.com/|Send us your questions|           |Elena|1@q.com|01112345678|UK      |

