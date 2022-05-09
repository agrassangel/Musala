#1)	Visit http://www.musala.com/
#2)	Navigate to Careers menu (from the top)
#3)	Click ‘Check our open positions’ button
#4)	Verify that  ‘Join Us’ page is opened (can verify that URL is correct: http://www.musala.com/careers/join-us/

#5)	From the dropdown ‘Select location’ select ‘Anywhere’
#6)	Choose open position by name (e.g. Experienced Automation QA Engineer)
#7)	Verify that 4 main sections are shown: General Description, Requirements, Responsibilities, What we offer
#8)	Verify that ‘Apply’ button is present at the bottom


#9)	Click ‘Apply’ button
#10)	Prepare a few sets of negative data (e.g. leave required field(s) empty, enter e-mail with invalid format etc)
#11)	Upload a CV document, and click ‘Send’ button
#12)	Verify shown error messages (e.g. The field is required, The e-mail address entered is invalid etc.)

Feature:  Careers

  Background:
    Given User is on Musala web side

  Scenario: 03 - Verify JoinUS page
    Given User is on Musala web side
    When  User clicks on "Careers" top link
    And User click on Check our open positions
    Then  System displays Join US web page with url "http://www.musala.com/careers/join-us/"

  Scenario: 03 - Verify jof offer page
    Given User is on Musala Join US page
    When User select option "Anywhere" from Select location dropdown
    And User select open position "Automation QA Engineer"
    Then System will display the 4 main session
    And The apply button show be present


  Scenario Outline: 03 - Verify Apply form
    Given User is on Musala Join US page
    When User select option "Anywhere" from Select location dropdown
    And User select open position "Automation QA Engineer"
    And User clicks on Apply button
    And User fills the required fields with wrong data "<username>" "<email>" and "<mobile>"
    And Users upload an image
    Then System shows the error message expected
    Examples:
      | username  | email   | mobile  |
      | incorrect | incorrect | correct |
      | correct     | incorrect | correct   |
      | correct     | correct  | incorrect  |
      |          |       |        |


#  1)	Visit http://www.musala.com/
#  2)	Go to Careers
#  3)	Click ‘Check our open positions’ button
#  4)	Filter the available positions by available cities in the dropdown ‘Select location’ (Sofia and Skopje)
#  5)	Get the open positions by city
#  6)	Print in the console the list with available positions by city in the following format:

  Scenario Outline: 04 - Get Open possition by city
    Given User is on Musala Join US page
    When User select option "<city>" from Select location dropdown
    Then System will display the open positions
    Examples:
      | city   |
      | Sofia  |
      | Skopje |









