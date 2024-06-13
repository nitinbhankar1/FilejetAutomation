package com.filejet.util;

import com.filejet.helper.BaseHelp;
import com.filejet.helper.BrowserUtil;
import com.filejet.helper.LogUtil;
import com.filejet.helper.AppUrlUtility;
import com.filejet.utilities.ExtentTestManager;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class HelpBase extends ExtentTestManager {

    public static WebDriver driver;

    public String path;

    @BeforeMethod
    public void launchApplication(ITestResult result) {
        driver = BrowserUtil.getBrowser();
        driver.manage().window().maximize();
        driver.get(AppUrlUtility.getUrl());
        ReporterLog("Get url = " + AppUrlUtility.getUrl());
    }

    @AfterMethod
    public void quitBrowser(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            try {
                path = System.getProperty("user.dir") + System.getProperty("file.separator") + "screenshots"
                        + System.getProperty("file.separator") + result.getName()
                        + (System.currentTimeMillis() + ".png");
                new BaseHelp().getScreenshot(path);
                LogUtil.logInfo("Failed Screenshot : " + path);
            } catch (Exception e) {
            }
        }
        BrowserUtil.quitWebDriver();
        LogUtil.logInfo("Completed execution" + result.getMethod().getMethodName());
    }
}