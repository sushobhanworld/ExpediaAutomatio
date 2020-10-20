Feature: Expedia Search Page validations
  Scenario Outline: Expedia Search
    Given I am on the homePage of Expedia
    Then I search "<text>"
    And I select "<CheckInDate>" and "<CheckOutDate>"
    And I select "<num>" as number of travellers
    And I click on Search button
    Then I validate the "<title>" of the page
    Then I validate  the text is selected under Neighbourhood
    Then I validate the url contains the "<text>"
    Examples:
      | text | CheckInDate | CheckOutDate | num | title |
      | Kolkata | 11/18/2020 | 12/6/2020  | 3 | Kolkata (and vicinity), West Bengal, India Hotel Search Results |