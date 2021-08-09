Feature: Rate Alert feature

  @Rate_Alert @POC_1 @compareDOM @FrontEnd @TORvsFCG @jenkins
  Scenario Outline:To create a new Rate Alert on buying
    Given I launched application through "<browser>"
    And I navigate to FCG portal "<urlName>"
    When I enter UserName "<emailAddress>" password "<password>" and click login button
    Then I click on Create new Rate Alert option on dashboard.
    And I Select buying currency"<buyCurr>" from I intend to buy drop down.
    And Select selling currency"<sellCurr>" from I intend to sell drop down.
    When I enter the amount"<BuyAmount>" to buy and click on Get Rate button
    Then Current Rate is populated successfully
    Then I enter the Target Rate and click on Continue button
    And  Pay this much less amount is displayed successfully
    When I select Alert me via "<AlertMeVia>" drop down and click on Create alert button
    Then success message of adding alert is displayed

    Examples:
      | browser | urlName | emailAddress | password | buyCurr | sellCurr | BuyAmount | AlertMeVia|
      | Chrome  | FCGUrl  | FCGemailAddress | FCGPassword | USD     | GBP      | 2000      | email only|


