@fetureTest
Feature: Make a Transfer

@test
	@MakeATransfer @FrontEnd @POC_1
@scenario
Scenario Outline: Make EUR to CAD transfer from Wallet Balance
	Given I launched application through "<browser>"
    And I navigate to FCG portal "<urlName>"
    When I enter UserName "<emailAddress>" password "<password>" and click login button
    Then I landed on Dashboard page successfully
    Then User click on Transfer section
	And User clicks on Select link for relevant benificiary 
	When User selects you Pay "<youPay>" Amount "<amount>"
	And User selects Reason for this transfer "<reason>" enters Recipient reference "<reference>"
	And User selects Payment method "<method>" and clicks on Continue button
	And User clicks on Confirm button after validating details entered for transfer
	Then User should sucessfully be able make a transfer and click on Back to dashboard link
	Examples:
	|browser|urlName|emailAddress|password|youPay|amount|reason|reference|method|
	|Chrome|FCGUrl|FCGemailAddress|FCGPassword|EUR|100|Emigration|Testing|Balance|
