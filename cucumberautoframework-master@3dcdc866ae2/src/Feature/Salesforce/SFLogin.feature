Feature: Sales Force Login feature

 @SF_PositiveLoginScenario @POC2
  Scenario Outline: Valid Sales Force Credentials
   Given User launched SF application through "<browser>"
   And User navigate to SF Application "<urlName>"
   When User enter SF UserName "<emailAddress>" password "<password>" and click log In button
   #Then User Enters  "<otp>" Sent on mobile and clicks verify
   Then User successfully landed on SF Home page
   #And User clicks on Logout link under profile and successfully logout from application
   Examples:
     |browser | urlName|emailAddress |password|otp|
     |  Chrome |SFUrl |SFUserName |SFPassword|55794|


  @SF_NegativeLoginScenario @POC2
  Scenario Outline: Invalid Sales Force Credentials
  Given User launched SF application through "<browser>"
  And User navigate to SF Application "<urlName>"
  When User enter SF UserName "<emailAddress>" incorrect password "<password>" and click log In button
  Then error message is displayed on SF Login page
  Examples:
    |browser | urlName|emailAddress |password|
    |  Chrome |SFUrl |SFUserName |abcd|





