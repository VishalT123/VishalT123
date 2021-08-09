Feature: Login feature

  @Login_positive @POC_1 @TORFX @compareDOM @TORFX_POSITIVE
    @FrontEnd @TORvsFCG
  Scenario Outline: Verify that user is able to login FCG application successfully
    Given I launched  application through "<browser>"
    And I navigate to FCG portal "<urlName>"
    When I enter UserName "<emailAddress>" password "<password>" and click login button
    Then I landed on Dashboard page successfully
    Examples:
    |browser | urlName|emailAddress |password|
    |  Chrome |TORFXurl |TORUserName |TORPassword|


  @Login_negative @TORFX

  Scenario Outline: Verify that error message is displayed when user email is not registered with FCG
    Given I launched application through "<browser>"
    And I navigate to FCG portal "<urlName>"
    When I enter UserName "<emailAddress>" incorrect password "<password>" and click login button
    Then error message is displayed on Login page
    Examples:
      |browser | urlName|emailAddress |password|
      |  Chrome |TORFXurl |TORUserName |abcd|




