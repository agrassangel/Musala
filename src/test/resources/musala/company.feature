Feature: Company
  As user we want to verify that Company information is correct

  Background:
    Given User is on Musala web side

  Scenario: 02 - Verify company section info
    When  User clicks on "company" top link
    Then  Web page url match with "http://www.musala.com/company/"
    And Web page shows the Leadership section


  Scenario: 02 - Verify Facebook company profile
    When  User clicks on "company" top link
    And user clicks on "Facebook" icon
    Then  Web page url match with "https://www.facebook.com/MusalaSoft?fref=ts"
    And Musala Soft picture should appears




#  2)	Click ‘Company’ tap from the top
#  3)	Verify that the correct URL (http://www.musala.com/company/) loads
#  4)	Verify that there is ‘Leadership’ section
#  5)	Click the Facebook link from the footer
#  6)	Verify that the correct URL (https://www.facebook.com/MusalaSoft?fref=ts) loads and
#  verify if the Musala Soft profile picture appears on the new page
#
