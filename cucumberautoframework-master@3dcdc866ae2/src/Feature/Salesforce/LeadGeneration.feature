Feature: Sales Force Lead generation

  @SF_LeadGenerationScenario @POC2
  Scenario Outline: Lead generation
    Given User launched SF application through "<browser>"
    And User navigate to SF Application "<urlName>"
    When User enter SF UserName "<emailAddress>" password "<password>" and click log In button
    Then User successfully landed on SF Home page
    When User clicks on Lead Tab and then on New Lead
    And User select record type as CD and clicks on Next button
    And User enter Lead Information "<accountname>" "<firstname>" "<lastname>" "<email>"
    And User enters source information "<sourcelookup>" "<branchname>" and clicks on Save button
    Then User successfully landed on SF Home page
    #Then User should be able successfully generate Lead"<firstname>""<lastname>"
    #And User clicks on Logout link under profile and successfully logout from application
    Examples:
      | browser | urlName | emailAddress | password   | accountname | firstname | lastname | email                | sourcelookup | branchname |
      | Chrome  | SFUrl   | SFUserName   | SFPassword | Stone Cold  | Stone     | Austin   | SC123@mailinator.com | Web: Google  | Italy      |
