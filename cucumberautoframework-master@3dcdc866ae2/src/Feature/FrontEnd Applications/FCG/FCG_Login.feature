Feature: Login feature

  @Login_positive @POC_1 @compareDOM @FCG_LoginPositive
     @FrontEnd @TORvsFCG @Smoke @Regress @TC_01
  Scenario Outline: Verify that user is able to login FCG application successfully
    Given I launched application through "<browser>"
    And I navigate to FCG portal "<urlName>"
    When I enter UserName "<emailAddress>" password "<password>" and click login button
    Then I landed on Dashboard page successfully
    Examples:
    |browser | urlName|emailAddress |password|
    |  IE |gmail.com |FCGemailAddress1 |FCGPassword|
    |  Chrome |FCGUrl |FCGemailAddress2 |FCGPassword|


  @Login_negative
    @POC_1 @FrontEnd
  Scenario Outline: Verify that error message is displayed when user email is not registered with FCG
    Given I launched application through "<browser>"
    And I navigate to FCG portal "<urlName>"
    When I enter UserName "<emailAddress>" incorrect password "<password>" and click login button
    Then error message is displayed on Login page
    Examples:
      |browser | urlName|emailAddress |password|
      |  Chrome |FCGUrl |FCGemailAddress |abcd|





