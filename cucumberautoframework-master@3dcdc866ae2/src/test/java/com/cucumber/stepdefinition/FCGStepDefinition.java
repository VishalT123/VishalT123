package com.cucumber.stepdefinition;

import com.selenium.utillity.Constants;
//import com.utilities.Log;
import com.utility.LogCapture;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.testng.Assert;

public class FCGStepDefinition {

    @Given("^I launched application through \"([^\"]*)\"$")
    public void iLaunchedApplicationThrough(String data) throws Throwable {
        LogCapture.info(data+" Application is launching....");
        Assert.assertTrue(Constants.key.openBrowser("", data));
    }

    @And("^I navigate to FCG portal \"([^\"]*)\"$")
    public void iNavigateToFCGPortal(String vUrl) throws Throwable {
        LogCapture.info("FCG Portal is loading....");
        String url = Constants.CONFIG.getProperty(vUrl);
        Assert.assertEquals("PASS", Constants.key.navigate("", url));
    }

    @When("^I enter UserName \"([^\"]*)\" password \"([^\"]*)\" and click login button$")
    public void iEnterUserNamePasswordAndClickLoginButton(String userName, String password) throws Throwable {

        String vUserName = Constants.CONFIG.getProperty(userName);
        String vPassword = Constants.CONFIG.getProperty(password);
        String vObjUser = Constants.FCGloginPageOR.getProperty("FCG_Username");
        String vObjPass = Constants.FCGloginPageOR.getProperty("FCG_Password");
        LogCapture.info( "User Name " + vUserName + ", Password "+ password + " is validated ....");
        Assert.assertEquals("PASS", Constants.key.writeInInput(vObjUser, vUserName));
        Assert.assertEquals("PASS", Constants.key.writeInInput(vObjPass, vPassword));
        String vObjLoginButton = Constants.FCGloginPageOR.getProperty("LoginButton");
        Assert.assertEquals("PASS", Constants.key.click(vObjLoginButton, ""));
    }

    @Then("^I landed on Dashboard page successfully$")
    public void iLandedOnDashboardPageSuccessfully() throws Exception {
        LogCapture.info("Dashboard loading ......");
        Constants.key.pause("2", "");
        String vobjectDashboard = Constants.FCG_DashboardOR.getProperty("DashboardORText");
        Assert.assertEquals("PASS", Constants.key.verifyText(vobjectDashboard, "Check the exchange rate"));
    }

    @Then("^error message is displayed on Login page$")
    public void errorMessageIsDisplayedOnLognPage() throws Exception {
        String vExpected = "Either your email or your password is incorrect. Please re-enter your correct credentials. If you are not registered with us already, please click here to register with us..";
        String vErrorObj = Constants.FCGloginPageOR.getProperty("ErrorMessageLogin");
        LogCapture.info("Validating error message...");
        Assert.assertEquals("PASS", Constants.key.verifyText(vErrorObj, vExpected));
    }

    @When("^I enter UserName \"([^\"]*)\" incorrect password \"([^\"]*)\" and click login button$")
    public void iEnterUserNameIncorrectPasswordAndClickLoginButton(String usernName, String inPassword) throws Throwable {
        LogCapture.info("Validating incorrect credentials.......");
        String vUserName = Constants.CONFIG.getProperty(usernName);
        String vObjUser = Constants.FCGloginPageOR.getProperty("FCG_Username");
        Assert.assertEquals("PASS", Constants.key.writeInInput(vObjUser, vUserName));
        String vObjPass = Constants.FCGloginPageOR.getProperty("FCG_Password");
        Assert.assertEquals("PASS", Constants.key.writeInInput(vObjPass, inPassword));
        String vObjLoginButton = Constants.FCGloginPageOR.getProperty("LoginButton");
        Assert.assertEquals("PASS", Constants.key.click(vObjLoginButton, ""));


    }

    @And("^I Select buying currency\"([^\"]*)\" from I intend to buy drop down\\.$")
    public void iSelectBuyingCurrencyFromIIntendToBuyDropDown(String buyValue) throws Throwable {
        LogCapture.info("Selecting Buying Currency..."+ buyValue);
        String vIntentBuyDroDownClick = Constants.FCG_NewRateAlertOR.getProperty("IntentToBuyDDclick");
        Assert.assertEquals("PASS", Constants.key.pause("2", ""));
        Assert.assertEquals("PASS", Constants.key.click(vIntentBuyDroDownClick, ""));
        String vIntentBuyDroDownaddValue = Constants.FCG_NewRateAlertOR.getProperty("IntendToBuySearchAdd");
        Assert.assertEquals("PASS", Constants.key.writeInInput(vIntentBuyDroDownaddValue, buyValue));
        Assert.assertEquals("PASS", Constants.key.sendkeyboardStroke("", "enter"));

    }

    @Then("^I click on Create new Rate Alert option on dashboard\\.$")
    public void iClickOnCreateNewRateAlertOptionOnDashboard() throws Exception {
        LogCapture.info("Clicking New rate Alert option .......");
        String vNewRateAlert = Constants.FCG_DashboardOR.getProperty("CrNewRateButton");
        Assert.assertEquals("PASS", Constants.key.pause("2", ""));
        Assert.assertEquals("PASS", Constants.key.click(vNewRateAlert, ""));
    }

    @And("^Select selling currency\"([^\"]*)\" from I intend to sell drop down\\.$")
    public void selectSellingCurrencyFromIIntendToSellDropDown(String sellValue) throws Throwable {

        LogCapture.info("Selecting selling Currency..."+ sellValue);
        String vIntentSellDroDownClick = Constants.FCG_NewRateAlertOR.getProperty("vIntentSellDroDownClick");
        Assert.assertEquals("PASS", Constants.key.pause("2", ""));
        Assert.assertEquals("PASS", Constants.key.click(vIntentSellDroDownClick, ""));
        String vIntentSellDroDownaddValue = Constants.FCG_NewRateAlertOR.getProperty("IntendToSellSearchAdd");
        Assert.assertEquals("PASS", Constants.key.pause("2", ""));
        Assert.assertEquals("PASS", Constants.key.writeInInput(vIntentSellDroDownaddValue, sellValue));
        Assert.assertEquals("PASS", Constants.key.sendkeyboardStroke("", "enter"));
    }

    @When("^I enter the amount\"([^\"]*)\" to buy and click on Get Rate button$")
    public void iEnterTheAmountToyBuyAndClickOnGetRateButton(String buyAmount) throws Throwable {
        LogCapture.info("Entering the amount to buy .....");
        String vBuyInputObject = Constants.FCG_NewRateAlertOR.getProperty("BuyInputText");
        Assert.assertEquals("PASS", Constants.key.writeInInput(vBuyInputObject, buyAmount));
        String vGetRateButtonObj = Constants.FCG_NewRateAlertOR.getProperty("GetRateButton");
        Assert.assertEquals("PASS", Constants.key.click(vGetRateButtonObj, ""));


    }

    @Then("^Current Rate is populated successfully$")
    public void currentRateIsPopulatedSuccessfully() throws Exception {
        LogCapture.info("Checking for current rate ....");
        String vCurrentRateValue = Constants.FCG_NewRateAlertOR.getProperty("CurrentRateValue");
        Assert.assertEquals("PASS", Constants.key.exist(vCurrentRateValue, ""));


    }

    @Then("^I enter the Target Rate and click on Continue button$")
    public void iEnterTheTargetRateAndClickOnContinueButton() throws Throwable {
        LogCapture.info("Target Rate validation.....");
        String vTargetRate = Constants.FCG_NewRateAlertOR.getProperty("TargetRateValue");
        String vCurrentRateValue = Constants.FCG_NewRateAlertOR.getProperty("CurrentRateValue");
        Assert.assertEquals("PASS", Constants.key.pause("5", ""));
        String vCurrentRateValNum = Constants.driver.findElement(By.xpath(vCurrentRateValue)).getAttribute("value");
        double d = Double.parseDouble(vCurrentRateValNum);
        double vDoubleCurrRate = ((10 * d / 100) + d);
        String vTargetValueCalculated = Double.toString(vDoubleCurrRate);
        Assert.assertEquals("PASS", Constants.key.pause("5", ""));
        Assert.assertEquals("PASS", Constants.key.writeInInput(vTargetRate, vTargetValueCalculated));
        Assert.assertEquals("PASS", Constants.key.pause("2", ""));
        Assert.assertEquals("PASS", Constants.key.click(Constants.FCG_NewRateAlertOR.getProperty("ContinueButton"), ""));

    }

    @And("^Pay this much less amount is displayed successfully$")
    public void payThisMuchLessAmountIsDisplayedSuccessfully() throws Exception {
        LogCapture.info("Check for Pay this much less field.......");
        String vPaylessObj = Constants.FCG_NewRateAlertOR.getProperty("PayThisMuchLessField");
        Assert.assertEquals("PASS", Constants.key.exist(vPaylessObj, ""));
    }

    @When("^I select Alert me via \"([^\"]*)\" drop down and click on Create alert button$")
    public void iSelectAlertMeViaDropDownAndClickOnCreateAlertButton(String arg0) throws Throwable {
        LogCapture.info("Setting Alert options and creating Alert Button......");
        String vAlertMeDD = Constants.FCG_NewRateAlertOR.getProperty("AlertMeViaDDclick");
        Assert.assertEquals("PASS", Constants.key.click(vAlertMeDD, ""));
        String vAlertMeVal = Constants.FCG_NewRateAlertOR.getProperty("AlertMeViaDDAdd");
        Assert.assertEquals("PASS", Constants.key.writeInInput(vAlertMeVal, arg0));
        Assert.assertEquals("PASS", Constants.key.sendkeyboardStroke("", "enter"));
        Constants.key.pause("2", "");
        Assert.assertEquals("PASS", Constants.key.click(Constants.FCG_NewRateAlertOR.getProperty("CreateAlertButton"), ""));

    }

    @Then("^success message of adding alert is displayed$")
    public void successMessageOfAddingAlertIsDisplayed() throws Exception {
        LogCapture.info("Checking Alert success message.....");
        Constants.key.pause("2", "");
        String vRateSuccessObj = Constants.FCG_NewRateAlertOR.getProperty("RateAlertSuccessfullyMsg");
        Assert.assertEquals("PASS", Constants.key.verifyText(vRateSuccessObj, "Thanks, your rate alert has been added successfully."));
    }

    @Then("^User clicks on Top up your wallet section$")
    public void user_clicks_on_Top_up_your_wallet_section() throws Throwable {
        LogCapture.info("Selecting Top Up Wallet section......");
        String vObjTopUpWalletLink = Constants.FCG_TopupWalletOR.getProperty("TopUpWalletLink");
        Assert.assertEquals("PASS",Constants.key.click(vObjTopUpWalletLink, ""));
        Constants.key.pause("2","");

    }

    @When("^User selects Payment currency \"(.*?)\" Select wallet \"(.*?)\"$")
    public void user_selects_Payment_currency_Select_wallet(String payCurrency, String selectWallet) throws Throwable {
        LogCapture.info("Selecting Payment Curreny and Wallet......");
        String vObjPaymentCurrency = Constants.FCG_TopupWalletOR.getProperty("PaymentCurrency");
        Assert.assertEquals("PASS",Constants.key.click(vObjPaymentCurrency, ""));
        String vObjPaySearchCurrency = Constants.FCG_TopupWalletOR.getProperty("PayCurrencySearch");
        Assert.assertEquals("PASS",Constants.key.writeInInput(vObjPaySearchCurrency, payCurrency));
        Assert.assertEquals("PASS",Constants.key.sendkeyboardStroke("", "enter"));
        String vObjSelectWallet = Constants.FCG_TopupWalletOR.getProperty("SelectWallet");
        Assert.assertEquals("PASS",Constants.key.click(vObjSelectWallet, ""));
        String vObjBuySearchCurrency = Constants.FCG_TopupWalletOR.getProperty("BuyCurrencySearch");
        Assert.assertEquals("PASS", Constants.key.writeInInput(vObjBuySearchCurrency, selectWallet));
        Assert.assertEquals("PASS",Constants.key.sendkeyboardStroke("", "enter"));

    }

    @When("^User enters Payment currecy Amount \"(.*?)\" and clicks countinue button$")
    public void user_enters_Payment_currecy_Amount_and_clicks_countinue_button(String payAmount) throws Throwable {
        LogCapture.info("Entering Payment Currency and clicking continue button....");
        String vObjPayCurrencyAMT = Constants.FCG_TopupWalletOR.getProperty("PaymentCurrencyAMT");
        Constants.key.pause("2","");
        Assert.assertEquals("PASS",Constants.key.writeInInput(vObjPayCurrencyAMT, payAmount));
        Assert.assertEquals("PASS",Constants.key.sendkeyboardStroke("", "enter"));
        Constants.key.pause("2","");
        String vObjButtonBuyCur1 = Constants.FCG_TopupWalletOR.getProperty("ButtonBuyCur1");
        Assert.assertEquals("PASS",Constants.key.click(vObjButtonBuyCur1, ""));

    }

    @When("^User selects Payment method \"(.*?)\" and clicks countinue button$")
    public void user_selects_Payment_method_and_clicks_countinue_button(String payMethod) throws Throwable {
        LogCapture.info("Select payment method and click Continue....");
        String vObjPaymentMethod = Constants.FCG_TopupWalletOR.getProperty("PaymentMethod");
        Assert.assertEquals("PASS",Constants.key.click(vObjPaymentMethod, ""));
        String vObjFromBalance = Constants.FCG_TopupWalletOR.getProperty("FromBalance");
        Assert.assertEquals("PASS",Constants.key.click(vObjFromBalance, ""));
        String vObjButtonBuyCur2 = Constants.FCG_TopupWalletOR.getProperty("ButtonBuyCur2");
        Assert.assertEquals("PASS",Constants.key.click(vObjButtonBuyCur2, ""));
        Constants.key.pause("2","");

    }

    @When("^User clicks on Confirm button after validating details entered$")
    public void user_clicks_on_Confirm_button_after_validating_details_entered() throws Throwable {
        LogCapture.info("Confirming validations.....");
        //String vObjConfirmYourPurchase = Constants.FCG_DashboardOR.getProperty("ConfirmYourPurchase");
        //Assert.assertEquals("PASS",Constants.key.verifyText(vObjConfirmYourPurchase,"Confirm your purchase"));
        String vObjButtonPurchaseConfirmation = Constants.FCG_TopupWalletOR.getProperty("ButtonPurchaseConfirmation");
        Assert.assertEquals("PASS",Constants.key.click(vObjButtonPurchaseConfirmation, ""));
        Constants.key.pause("2","");

    }

    @Then("^User should sucessfully be able to top up wallet and click on Back to dashboard link$")
    public void user_should_sucessfully_be_able_to_top_up_wallet_and_click_on_Back_to_dashboard_link() throws Throwable {
        LogCapture.info("Top Up Wallet validation...");
        String vObjSuccessfullTopUpMSG = Constants.FCG_TopupWalletOR.getProperty("SuccessfullTopUpMSG");
        Assert.assertEquals("PASS",Constants.key.verifyText(vObjSuccessfullTopUpMSG, "Top-up details"));
        String vObjLinkBackToDashboard = Constants.FCG_TopupWalletOR.getProperty("LinkBackToDashboard");
        Assert.assertEquals("PASS",Constants.key.click(vObjLinkBackToDashboard, ""));

    }

    @Then("^User click on Transfer section$")
    public void user_click_on_Transfer_section() throws Throwable {
        LogCapture.info("Transfer Section verification.......");
        String vObjTransferLink = Constants.FCG_MakeTransferOR.getProperty("TransferLink");
        Assert.assertEquals("PASS",Constants.key.click(vObjTransferLink, ""));

    }


    @Then("^User clicks on Select link for relevant benificiary$")
    public void user_clicks_on_Select_link_for_relevant_benificiary() throws Throwable {
        LogCapture.info("Adding Benificiary......");
        String vObjSelectRecipient = Constants.FCG_MakeTransferOR.getProperty("SelectRecipient");
        Assert.assertEquals("PASS",Constants.key.click(vObjSelectRecipient, ""));

    }

    @When("^User selects you Pay \"(.*?)\" Amount \"(.*?)\"$")
    public void user_selects_you_Pay_Amount(String youPay, String amount) throws Throwable {
        LogCapture.info("Amount selection......");
        String vObjYouPay = Constants.FCG_MakeTransferOR.getProperty("YouPay");
        Constants.key.pause("2","");
        Assert.assertEquals("PASS",Constants.key.click(vObjYouPay, ""));

        String vObjYouPaySearch = Constants.FCG_MakeTransferOR.getProperty("YouPaySearch");
        Constants.key.pause("2","");
        Assert.assertEquals("PASS",Constants.key.writeInInput(vObjYouPaySearch, youPay));
        Assert.assertEquals("PASS",Constants.key.sendkeyboardStroke("", "enter"));

        String vObjSellInput = Constants.FCG_MakeTransferOR.getProperty("SellInput");
        Assert.assertEquals("PASS",Constants.key.writeInInput(vObjSellInput, amount));
        Assert.assertEquals("PASS",Constants.key.sendkeyboardStroke("", "enter"));

    }

    @When("^User selects Reason for this transfer \"(.*?)\" enters Recipient reference \"(.*?)\"$")
    public void user_selects_Reason_for_this_transfer_enters_Recipient_reference(String reason, String reference) throws Throwable {
        LogCapture.info("Reason for transfer and references.....");
        String vObjReasonForTransfer = Constants.FCG_MakeTransferOR.getProperty("ReasonForTransfer");
        Assert.assertEquals("PASS",Constants.key.click(vObjReasonForTransfer, ""));

        String vObjReasonForTransferSearch = Constants.FCG_MakeTransferOR.getProperty("ReasonForTransferSearch");
        Assert.assertEquals("PASS",Constants.key.writeInInput(vObjReasonForTransferSearch, reason));
        Assert.assertEquals("PASS",Constants.key.sendkeyboardStroke("", "enter"));

        String vObjRecipientReference = Constants.FCG_MakeTransferOR.getProperty("RecipientReference");
        Assert.assertEquals("PASS",Constants.key.writeInInput(vObjRecipientReference, reference));

        String vObjButtonContinue = Constants.FCG_MakeTransferOR.getProperty("ButtonContinue");
        Assert.assertEquals("PASS",Constants.key.click(vObjButtonContinue, ""));

    }

    @When("^User selects Payment method \"(.*?)\" and clicks on Continue button$")
    public void user_selects_Payment_method_and_clicks_on_Continue_button(String arg1) throws Throwable {
        LogCapture.info("Selecting Payment method.....");
        String vObjPaymentMethod = Constants.FCG_MakeTransferOR.getProperty("PaymentMethod");
        Assert.assertEquals("PASS",Constants.key.click(vObjPaymentMethod, ""));
        String vObjFromBalance = Constants.FCG_MakeTransferOR.getProperty("FromBalance");
        Assert.assertEquals("PASS",Constants.key.click(vObjFromBalance, ""));
        String vObjButtonContinuetoSubmit = Constants.FCG_MakeTransferOR.getProperty("ButtonContinuetoSubmit");
        Assert.assertEquals("PASS",Constants.key.click(vObjButtonContinuetoSubmit, ""));


    }

    @When("^User clicks on Confirm button after validating details entered for transfer$")
    public void user_clicks_on_Confirm_button_after_validating_details_entered_for_transfer() throws Throwable {
        LogCapture.info("Confirming post validations.....");
        String vObjConfirmButton = Constants.FCG_MakeTransferOR.getProperty("ConfirmButton");
        Assert.assertEquals("PASS",Constants.key.click(vObjConfirmButton, ""));

    }

    @Then("^User should sucessfully be able make a transfer and click on Back to dashboard link$")
    public void user_should_sucessfully_be_able_make_a_transfer_and_click_on_Back_to_dashboard_link() throws Throwable {
        LogCapture.info("Transfer success Validation.....");
        String vObjLinkBackToDashboard = Constants.FCG_MakeTransferOR.getProperty("LinkBackToDashboard");
        Assert.assertEquals("PASS",Constants.key.click(vObjLinkBackToDashboard, ""));


    }
}
