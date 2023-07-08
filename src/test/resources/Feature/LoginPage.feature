Feature: To verify the adactin hotel web page

  Scenario Outline: To verify the adactin hotel login page with valid credentails
    Given User should be in the adactin login page
    When User should enter the "<Username>" and "<Password>"
    When User should click the login button
    When User should enter the "<Location>","<Hotels>","<RoomType>","<Number of Rooms>"
    When User should enter date "<Check in Date>" and "<Check out Date>"
    When User should select the "<Adults per Room>" and "<Children per Room>"
    When User should click the search button
    When User should click the radio button
    When User should click the continue button
    When User should enter name "<First Name>" and "<Last Name>"
    When User should enter th address "<Billing Address>"
    When User should enter credit card type "<Credit Card No>"
    When User should enter card type "<Credit Card Type>"
    When User should enter valid date "<Month>" and "<Year>"
    When User should enter cv number "<CVV Number>"
    When User should click book now button
    Then User should verify sucessfull book the hotel

    Examples: 
      | Username       | Password  | Location | Hotels      | RoomType | Number of Rooms | Check in Date | Check out Date | Adults per Room | Children per Room | First Name | Last Name | Billing Address    | Credit Card No   | Credit Card Type | Month    | Year | CVV Number |
      | vssanthosh1017 | siva12345 | Brisbane | Hotel Creek | Deluxe   | 3 - Three       | 22/02/2020    | 22/03/2020     | 2 - Two         | 3 - Three         | Prakash    | Prakash   | 1/123weryioplkjgxz | 1234567898765432 | American Express | February | 2025 |       1234 |
