Feature: Payment In feature


  @Atlas_PaymentInCLEARStatusFlow @POC2
  Scenario Outline: To Validate Payment In-CLEAR status flow
    Given User launched application through "<browser>" browser
    And User navigate to Atlas Application "<urlName>"
    When User enter UserName "<emailAddress>" password "<password>" and click log In button on Altas Application
    Then User successfully landed on Atlas Dashboard page
    And User navigates to  Payment_In Report from Dashboard
    When User click on filter criteria
    And User enters valid customer number"<customerNumber>" in keyword section
    And user hits Enter on Keyboard
    And User Click on  a record for which Payment  is in HOLD status to navigate to details page
    Then User Lock the Record
    And  Mark the Payment In Status as CLEAR with comments
    When User Click on Apply/Apply & Unlock
    Then Payment In Status to be Observed as CLEAR wth success message

    Examples:
      | browser | urlName  | emailAddress  | password      | customerNumber   |
      | Chrome  | AtlasUrl | AtlasUserName | AtlasPassword | 0101000006482796 |


  @Atlas_PaymenREJECTStatusFlow @POC2
  Scenario Outline: To Validate Payment In-CLEAR status flow
    Given User launched application through "<browser>" browser
    And User navigate to Atlas Application "<urlName>"
    When User enter UserName "<emailAddress>" password "<password>" and click log In button on Altas Application
    Then User successfully landed on Atlas Dashboard page
    And User navigates to  Payment_In Report from Dashboard
    When User click on filter criteria
    And User enters valid customer number"<customerNumber>" in keyword section
    And user hits Enter on Keyboard
    And User Click on  a record for which Payment  is in HOLD status to navigate to details page
    Then User Lock the Record
    And  Mark the Payment In Status as REJECT with comments
    And User selects reason"<reason>" from drop down
    When User Click on Apply/Apply & Unlock
    Then Payment Out Status to be Observed as REJECT wth success message

    Examples:
      | browser | urlName  | emailAddress  | password      | customerNumber   |reason|
      | Chrome  | AtlasUrl | AtlasUserName | AtlasPassword | 0101000006482796 | Awaiting sanction review|