Feature: TitanLogin feature

  @Titan_LoginPositiveScenario @POC2
  Scenario Outline: Login to Titan with valid credential
    Given User launched application through "<browser>"
    And User navigate to Titan Application "<urlName>"
    When User enter UserName "<emailAddress>" password "<password>" and click log In button
    Then User successfully landed on Titan Dashboard page
    And User clicks on Logout button and successfully logout from application
    Examples:
      | browser | urlName  | emailAddress  | password      |
      | Chrome  | TitanUrl | TitanUserName | TitanPassword |


  @Titan_LoginNegativeScenario @POC2
  Scenario Outline: Login to Titan with invalid credential
    Given User launched application through "<browser>"
    And User navigate to Titan Application "<urlName>"
    When User enter UserName "<emailAddress>" Incorrect password "<password>" and click log In button
    Then User should get error and should not be able to login in to Titan
    Examples:
      | browser | urlName  | emailAddress  | password |
      | Chrome  | TitanUrl | TitanUserName | qwerty   |





