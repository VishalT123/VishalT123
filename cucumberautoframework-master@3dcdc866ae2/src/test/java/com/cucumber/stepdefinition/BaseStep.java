package com.cucumber.stepdefinition;

import com.cucumber.listener.Reporter;
import com.selenium.utillity.Constants;
import com.selenium.utillity.Reusables;

import com.utility.LogCapture;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.commons.logging.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class BaseStep {


    @Before
    public void intialization() throws IOException {
        Constants.key = new Reusables();

        FileInputStream fs = new FileInputStream(System.getProperty("user.dir") + "//src//Config//config.properties");
        System.out.println(System.getProperty("user.dir"));
        Constants.CONFIG = new Properties();
        Constants.CONFIG.load(fs);
  System.out.println(System.getProperty("user.dir"));
        //FCG Login Page OR
  File f1=new File("");
  FileInputStream fs = new FileInputStream(System.getProperty("user.dir") + "//src//test//java//com//Pages//FCG//FCGloginPageOR.properties");
        Properties FCGloginPageOR = new Properties();
        FCGloginPageOR.load(fs);

       String UsernameXpath = FCGloginPageOR.get("SFUserName").toString();
        //FCG_Dashboard
        fs = new FileInputStream(System.getProperty("user.dir") + "//src//test//java//com//Pages//FCG//FCG_DashboardOR.properties");
        Constants.FCG_DashboardOR = new Properties();
        Constants.FCG_DashboardOR.load(fs);

        //FCG_NewRateAlert
        fs = new FileInputStream(System.getProperty("user.dir") + "//src//test//java//com//Pages//FCG//FCG_NewRateAlertOR.properties");
        Constants.FCG_NewRateAlertOR = new Properties();
        Constants.FCG_NewRateAlertOR.load(fs);

        //FCG_Top up Wallet
        fs = new FileInputStream(System.getProperty("user.dir") + "//src//test//java//com//Pages//FCG//FCG_TopupWalletOR.properties");
        Constants.FCG_TopupWalletOR = new Properties();
        Constants.FCG_TopupWalletOR.load(fs);

        //FCG_Make a Transfer
        fs = new FileInputStream(System.getProperty("user.dir") + "//src//test//java//com//Pages//FCG//FCG_MakeTransferOR.properties");
        Constants.FCG_MakeTransferOR = new Properties();
        Constants.FCG_MakeTransferOR.load(fs);

        //Titan Login OR
        fs = new FileInputStream(System.getProperty("user.dir") + "//src//test//java//com//Pages//Titan//TitanLoginOR.properties");
        Constants.TitanLoginOR = new Properties();
        Constants.TitanLoginOR.load(fs);

        //Titan_Create FX Ticket
        fs = new FileInputStream(System.getProperty("user.dir") + "//src//test//java//com//Pages//Titan//CreateFxTicketOR.properties");
        Constants.CreateFxTicketOR = new Properties();
        Constants.CreateFxTicketOR.load(fs);

        //Atlas Login OR
        fs = new FileInputStream(System.getProperty("user.dir") + "//src//test//java//com//Pages//Atlas//AtlasloginOR.properties");
        Constants.AtlasloginOR = new Properties();
        Constants.AtlasloginOR.load(fs);

        //Atlas dashboard OR
        fs = new FileInputStream(System.getProperty("user.dir") + "//src//test//java//com//Pages//Atlas//AtlasDashboardOR.properties");
        Constants.AtlasDashboardOR = new Properties();
        Constants.AtlasDashboardOR.load(fs);

        //Atlas AtlasPaymentInQueueOR
        fs = new FileInputStream(System.getProperty("user.dir") + "//src//test//java//com//Pages//Atlas//AtlasPaymentInQueueOR.properties");
        Constants.AtlasPaymentInQueueOR = new Properties();
        Constants.AtlasPaymentInQueueOR.load(fs);

        //Atlas_AtlasPaymentOutQueueOR
        fs = new FileInputStream(System.getProperty("user.dir") + "//src//test//java//com//Pages//Atlas//AtlasPaymentOutQueueOR.properties");
        Constants.AtlasPaymentOutQueueOR = new Properties();
        Constants.AtlasPaymentOutQueueOR.load(fs);
        //SF Login OR
        fs = new FileInputStream(System.getProperty("user.dir") + "//src//test//java//com//Pages//SF//SFLoginOR.properties");
        Constants.SFLoginOR = new Properties();
        Constants.SFLoginOR.load(fs);

//SF LeadGenerationOR
        fs = new FileInputStream(System.getProperty("user.dir") + "//src//test//java//com//Pages//SF//LeadGenerationOR.properties");
        Constants.LeadGenerationOR = new Properties();
        Constants.LeadGenerationOR.load(fs);


        LogCapture.startLog("-------------------------Test Case Validation Started--------------------");


    }

    @After
    public void finish() {

        Constants.driver.quit();
        LogCapture.endLog("-------------------------Test Case Validation Ended--------------------");
    }

    public static void writeExtentReport() {
        Reporter.loadXMLConfig(new File(Constants.key.getReportConfigPath()));

    }


}
