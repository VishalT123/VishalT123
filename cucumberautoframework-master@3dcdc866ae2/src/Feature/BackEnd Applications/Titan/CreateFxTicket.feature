Feature: Create Fx Ticket

  @Titan_FXTicketCreation @POC2 @Titan
  Scenario Outline: Created FX ticket from Bank to Wallet
    Given User launched application through "<browser>"
    And User navigate to Titan Application "<urlName>"
    When User enter UserName "<emailAddress>" password "<password>" and click log In button
    Then User successfully landed on Titan Dashboard page
    And User clicks on Customers option under Titan
    And User clicks on Filter option
    Then User enters client number "<clientNumber>" and hits Enter key
    Then User clicks on client number"<clientNumber>" link to navigate to customer detail page
    And User clicks on FX button
    And User selects Instructed by "<instructedBy>" Deal type SPOT purpose of payment "<purposeOfPayment>" and clicks Next
    And User selects Selling Currency "<selling>" Buying currency "<buying>" Selling amount "<sellingAmount>"and clicks on Fetch rates button
    And User clicks on Next button
    And User selects method Bank
    And User clicks on Add Credit button
    And User clicks on Skip button
    And User clicks on Yes button for popup
    And user clicks on Submit button
    Then User successfully creates FX ticket and clicks on Close Slip button
    And User clicks on Logout button and successfully logout from application
    Examples:
      | browser | urlName  | emailAddress  | password      | clientNumber     | instructedBy | purposeOfPayment | selling | buying | sellingAmount |
      | Chrome  | TitanUrl | TitanUserName | TitanPassword | 0201000006484551 | Rohit        | Emigration       | EUR     | GBP    | 100           |


  @Titan_FCTicketCardToWallet @POC2 @Titan
  Scenario Outline: Created FX ticket from Card to payee
    Given User launched application through "<browser>"
    And User navigate to Titan Application "<urlName>"
    When User enter UserName "<emailAddress>" password "<password>" and click log In button
    Then User successfully landed on Titan Dashboard page
    And User clicks on Customers option under Titan
    And User clicks on Filter option
    Then User enters client number "<clientNumber>" and hits Enter key
    Then User clicks on client number"<clientNumber>" link to navigate to customer detail page
    And User clicks on FX button
    And User selects Instructed by "<instructedBy>" Deal type SPOT purpose of payment "<purposeOfPayment>" and clicks Next
    And User selects Selling Currency "<selling>" Buying currency "<buying>" Selling amount "<sellingAmount>"and clicks on Fetch rates button
    And User clicks on Next button
    And User selects method Card selects card "<selectCard>" enters CVV "<cvv>"
    And User clicks on Add Credit button
    And User clicks on Skip button
    And User clicks on Yes button for popup
    And user clicks on Submit button
    Then User successfully creates FX ticket and clicks on Close Slip button
    And User clicks on Logout button and successfully logout from application
    Examples:
      | browser | urlName  | emailAddress  | password      | clientNumber     | instructedBy | purposeOfPayment | selling | buying | sellingAmount | selectCard | cvv |
      | Chrome  | TitanUrl | TitanUserName | TitanPassword | 0101000006482234 | Rohit        | Emigration       | EUR     | GBP    | 100           | patel      | 999 |