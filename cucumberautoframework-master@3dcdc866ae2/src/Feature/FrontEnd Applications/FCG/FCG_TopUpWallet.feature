@fetureTest
Feature: Topup Wallet balance

@test
@scenario
	@FrontEnd @POC_1
Scenario Outline: Topup CAD Wallet
	Given I launched application through "<browser>"
    And I navigate to FCG portal "<urlName>"
    When I enter UserName "<emailAddress>" password "<password>" and click login button
    Then I landed on Dashboard page successfully
	And User clicks on Top up your wallet section
	When User selects Payment currency "<payCurrency>" Select wallet "<selectWallet>"
	And User enters Payment currecy Amount "<payAmount>" and clicks countinue button
	And User selects Payment method "<payMethod>" and clicks countinue button
	And User clicks on Confirm button after validating details entered
	Then User should sucessfully be able to top up wallet and click on Back to dashboard link
	Examples:
	|browser|urlName|emailAddress|password|payCurrency|selectWallet|payAmount|payMethod|
	|Chrome|FCGUrl|FCGemailAddress|FCGPassword|EUR|CAD|100|Balance|