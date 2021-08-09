
/*ClassName: Resuables.java
Date: 17/April/2020
Author: Saurabh Gadgil
Purpose of class: To implement generic methods, all resuable using Xpath and selenium for robust framework.*/

package com.selenium.utillity;

import com.cucumber.listener.Reporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;


public class Reusables {

    public boolean openBrowser(String object, String data) throws Exception {
        try {
            if (data.equals("Chrome")) {
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
                Constants.driver = new ChromeDriver();
                Constants.driver.manage().window().maximize();

            }

            takeSnapShot();
            return true;
        } catch (Exception ex) {
            takeSnapShot();
            return false;
        }
    }

    public String navigate(String object, String data) throws Exception {
        try {
            Constants.driver.navigate().to(data);
            takeSnapShot();
        } catch (Exception e) {
            takeSnapShot();
            return Constants.KEYWORD_FAIL + "...not able to navigate";

        }
        return Constants.KEYWORD_PASS;
    }

    public String writeInInput(String object, String data) throws Exception {
        try {
            Constants.driver.findElement(By.xpath(object)).sendKeys(data);
            takeSnapShot();
        } catch (Exception e) {
            takeSnapShot();
            return Constants.KEYWORD_FAIL + "Unable to write " + e.getMessage();
        }
        return Constants.KEYWORD_PASS;
    }

    public String click(String object, String data) throws Exception {
        try {
            Constants.driver.findElement(By.xpath(object)).click();
            takeSnapShot();

        } catch (Exception e) {
            takeSnapShot();
            return Constants.KEYWORD_FAIL + "Not able to click...." + e.getMessage();
        }
        return Constants.KEYWORD_PASS;
    }

    public String verifyText(String object, String data) throws Exception {
        try {
            String actual = Constants.driver.findElement(By.xpath(object)).getText();
            if (actual.length() < 1) {
                actual = Constants.driver.findElement(By.xpath(object)).getAttribute("value");
            }
            String expected = data;
            System.out.println("actual value->>>>" + actual);
            System.out.println("data value->>>>" + data);
            if (actual.equals(expected)) {
                takeSnapShot();
                return Constants.KEYWORD_PASS;
            } else {
                takeSnapShot();
                return Constants.KEYWORD_FAIL + "...text not verified " + actual + "  " + expected;
            }
        } catch (Exception e) {
            takeSnapShot();
            return Constants.KEYWORD_FAIL + "Object not found...." + e.getMessage();
        }

    }

    public String pause(String object, String data) throws NumberFormatException, InterruptedException {
        long time = (long) Double.parseDouble(object);
        Thread.sleep(time * 1000L);
        return Constants.KEYWORD_PASS;

    }

    public static void takeSnapShot() throws Exception {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
        String dateString = format.format(new Date());
        //Convert web driver object to TakeScreenshot
        String fileWithPath = System.getProperty("user.dir") + "\\Screenshot\\SC" + dateString + ".png";
        ;
        //String fileWithPath = "C://Framework//CucumberSeleniumProject//CucumberSeleniumProject//Screenshot//SC" + dateString + ".png";
        TakesScreenshot scrShot = ((TakesScreenshot) Constants.driver);
        //Call getScreenshotAs method to create image file
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        //Move image file to new destination
        File DestFile = new File(fileWithPath);
        //Copy file at destination
        FileUtils.copyFile(SrcFile, DestFile);
        Reporter.addScreenCaptureFromPath(fileWithPath);
    }

    public String selectList(String object, String data) throws Exception {
        try {
            int attempt = 0;
            Select objSelect = new Select(Constants.driver.findElement(By.xpath(object)));
            if (!data.equals(Constants.RANDOM_VALUE)) {
                objSelect.selectByVisibleText(data);
                takeSnapShot();
            } else {
                WebElement droplist = Constants.driver.findElement(By.xpath(object));
                List<WebElement> droplist_contents = droplist.findElements(By.tagName("option"));
                Random num = new Random();
                int index = num.nextInt(droplist_contents.size());
                String selectedVal = droplist_contents.get(index).getText();
                objSelect.selectByVisibleText(selectedVal);
                takeSnapShot();
            }

        } catch (Exception e) {
            takeSnapShot();
            return Constants.KEYWORD_FAIL + "---Could not select from the List---" + e.getMessage();

        }
        return Constants.KEYWORD_PASS;
    }

    public String sendkeyboardStroke(String object, String data) throws Exception {
        //valid values for data = space,enter,up,tab,down,left,right
        try {
            Robot robot = new Robot();
            if (!object.equals("")) {
                WebElement browseBtn = Constants.driver.findElement(By.xpath(object));
                browseBtn.click();
                Thread.sleep(1000);
            }
            if (data.equals("space")) {
                robot.keyPress(KeyEvent.VK_SPACE);
                robot.keyRelease(KeyEvent.VK_SPACE);
            } else if (data.equals("enter")) {
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);
            } else if (data.equals("tab")) {
                robot.keyPress(KeyEvent.VK_TAB);
                robot.keyRelease(KeyEvent.VK_TAB);
            } else if (data.equals("down")) {
                robot.keyPress(KeyEvent.VK_DOWN);
                robot.keyRelease(KeyEvent.VK_DOWN);
            }
            Thread.sleep(1000);
            takeSnapShot();

        } catch (Exception e) {
            takeSnapShot();
            return Constants.KEYWORD_FAIL + "....unable to find element...." + e.getMessage();
        }
        return Constants.KEYWORD_PASS;
    }

    public String getReportConfigPath() {
        String reportConfigPath = Constants.CONFIG.getProperty("reportConfigPath");
        if (reportConfigPath != null) return reportConfigPath;
        else
            throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");
    }

    public String exist(String object, String data) throws Exception {
        try {
            Constants.driver.findElement(By.xpath(object));
            takeSnapShot();
        } catch (Exception e) {
            takeSnapShot();
            return Constants.KEYWORD_FAIL + "object does not exist " + e.getMessage();
        }
        return Constants.KEYWORD_PASS;
    }

    public String navigateSubMenu(String object, String data) throws Exception {
        try {
            WebElement elem = Constants.driver.findElement(By.xpath(object));
            String js = "argements[0].click();";
            ((JavascriptExecutor) Constants.driver).executeScript(js, elem);

            takeSnapShot();
        } catch (Exception e) {
            takeSnapShot();
            return Constants.KEYWORD_FAIL + "object does not exist " + e.getMessage();
        }
        return Constants.KEYWORD_PASS;
    }


    public String AltasRejectDropDown(String object, String data) throws Exception {
        try {
            List<WebElement> dropdown_list = Constants.driver.findElements(By.xpath(object));
            //System.out.println("The Options in the Dropdown are: " + dropdown_list.size());
            for (int i = 0; i < dropdown_list.size(); i++) {
                //System.out.println(dropdown_list.get(i).getText());
                if (dropdown_list.get(i).getText().contains(data)) {
                    for (int j = 1; j < 10000; j++) {
                        String vdata = Constants.driver.findElement(By.xpath("//div[@id='input-more-reject-reasons']//li[" + j + "]//label[1]")).getText();
                        if (vdata.equals(data)) {
                            Constants.driver.findElement(By.xpath("//div[@id='input-more-reject-reasons']//li[" + j + "]//label[1]")).click();
                            break;
                        }
                    }
                }
            }

        } catch (Exception e) {
            takeSnapShot();
            return Constants.KEYWORD_FAIL + "drop down value does not exist " + e.getMessage();
        }
        takeSnapShot();
        return Constants.KEYWORD_PASS;
    }

 /*   public void ReadCookies() {
        // create file named Cookies to store Login Information
        File file = new File("C:\\POC2\\CucumberSeleniumProject\\Cookies.data");
        try {
            // Delete old file if exists
            file.delete();
            file.createNewFile();
            FileWriter fileWrite = new FileWriter(file);
            BufferedWriter Bwrite = new BufferedWriter(fileWrite);
            // loop for getting the cookie information

            // loop for getting the cookie information
            for (Cookie ck : Constants.driver.manage().getCookies()) {
                Bwrite.write((ck.getName() + ";" + ck.getValue() + ";" + ck.getDomain() + ";" + ck.getPath() + ";" + ck.getExpiry() + ";" + ck.isSecure()));
                Bwrite.newLine();
            }
            Bwrite.close();
            fileWrite.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void WriteCookies() {
        try {

            File file = new File("C:\\POC2\\CucumberSeleniumProject\\Cookies.data");
            FileReader fileReader = new FileReader(file);
            BufferedReader Buffreader = new BufferedReader(fileReader);
            String strline;
            while ((strline = Buffreader.readLine()) != null) {
                StringTokenizer token = new StringTokenizer(strline, ";");
                while (token.hasMoreTokens()) {
                    String name = token.nextToken();
                    String value = token.nextToken();
                    String domain = token.nextToken();
                    String path = token.nextToken();
                    Date expiry = null;

                    String val;
                    if (!(val = token.nextToken()).equals("null")) {
                        expiry = new Date(val);
                    }
                    Boolean isSecure = new Boolean(token.nextToken()).
                            booleanValue();
                    Cookie ck = new Cookie(name, value, domain, path, expiry, isSecure);
                    System.out.println(ck);
                    Constants.driver.manage().addCookie(ck); // This will add the stored cookie to your current session
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }*/

    public String isAlertPresent() {
        try {
            Alert alert = Constants.driver.switchTo().alert();
            alert.accept();
        } catch (NoAlertPresentException e) {
            return Constants.KEYWORD_FAIL;
        }
        return Constants.KEYWORD_PASS;
    }

    public String clearText(String object) throws Exception {
        try {
            Constants.driver.findElement(By.xpath(object)).clear();
            takeSnapShot();
        } catch (Exception e) {
            takeSnapShot();
            return Constants.KEYWORD_FAIL;
        }
        return Constants.KEYWORD_PASS;
    }

    public String SfLeadDD(String object, String data) throws Exception {
        try {
            Constants.driver.findElement(By.xpath(object)).click();
            Constants.key.pause("2", "");
            Constants.driver.findElement(By.xpath(data)).click();
        } catch (Exception e) {
            takeSnapShot();
            return Constants.KEYWORD_FAIL;
        }
        return Constants.KEYWORD_PASS;
    }

    public String VerifyTitle(String object, String data) throws Exception {
        try {
            String actual = Constants.driver.getTitle();
            String expected = data;
            System.out.println("actual value->>>>" + actual);
            System.out.println("data value->>>>" + data);
            if (actual.equals(expected)) {
                takeSnapShot();
                return Constants.KEYWORD_PASS;
            } else {
                takeSnapShot();
                return Constants.KEYWORD_FAIL + "...text not verified " + actual + "  " + expected;
            }
        } catch (Exception e) {
            takeSnapShot();
            return Constants.KEYWORD_FAIL + "Object not found...." + e.getMessage();
        }

    }

    //
    //        w.until(ExpectedConditions.visibilityOfAllElements( By.xpath(Constants.CreateFxTicketOR.getProperty("CloseFxSlipButton"))));

    public String VisibleConditionWait(String object,String data) throws Exception {
        try {
            WebDriverWait w=new WebDriverWait(Constants.driver, 10);
           w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(object)));
            takeSnapShot();

        } catch (Exception e) {
            takeSnapShot();
            return Constants.KEYWORD_FAIL;
        }
        return Constants.KEYWORD_PASS;
    }


}













