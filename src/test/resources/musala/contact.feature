Feature: Contact


  Scenario Outline: 01 - Wrong email validation
    Given User is on Musala web side
    And User click on "Contact us"
    And user is on Contact Us form
    When User fill the required fields with invalid email "<email>"
    And user clicks on Send button
    Then The validation email error message should appears
    Examples:
      | email           |
      | test@test       |
      | simpleEmail     |
      | @gmail.com      |
      | Th@ths.         |
      | test.@gmail.com |