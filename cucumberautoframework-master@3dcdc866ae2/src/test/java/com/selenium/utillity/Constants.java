package com.selenium.utillity;

import com.utility.LogCapture;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

import javax.xml.soap.Text;
import java.awt.*;
import java.util.Properties;
import java.util.logging.Logger;

public class Constants {
    public static Reusables key;
    public static WebDriver driver;
    public static String KEYWORD_PASS = "PASS";
    public static String KEYWORD_FAIL = "FAIL";
    public static Properties CONFIG;
    public static Properties FCGloginPageOR;
    public static Properties FCG_DashboardOR;
    public static Properties FCG_NewRateAlertOR;
    public static String RANDOM_VALUE = "";
    public static LogCapture logs;
    public static Properties FCG_TopupWalletOR;
    public static Properties FCG_MakeTransferOR;
    public static Properties TitanLoginOR;
    public static Properties CreateFxTicketOR;
    public static Properties AtlasloginOR;
    public static Properties AtlasDashboardOR;
    public static Properties AtlasPaymentInQueueOR;
    public static Properties AtlasPaymentOutQueueOR;
    public static Properties SFLoginOR;
    public static Properties LeadGenerationOR;
}
