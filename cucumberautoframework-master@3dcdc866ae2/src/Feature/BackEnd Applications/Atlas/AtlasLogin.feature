Feature: Atlas Login feature


  @Atlas_LoginScenario @POC2
  Scenario Outline: Login to Atlas with valid credential
    Given User launched application through "<browser>" browser
    And User navigate to Atlas Application "<urlName>"
    When User enter UserName "<emailAddress>" password "<password>" and click log In button on Altas Application
    Then User successfully landed on Atlas Dashboard page
    And User clicks on Logout button to logoff application
    Examples:
      | browser | urlName  | emailAddress  | password      |
      | Chrome  | AtlasUrl | AtlasUserName | AtlasPassword |