package com.filejet.helper;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseHelp {

    WebDriverWait wait;
    public static Random random;

    public static StringBuilder stringBuilder;

    public static Select objSelect;

    public static int digit;

    public static void highLightElement(By by) {
        WebElement element = BrowserUtil.getBrowser().findElement(by);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) BrowserUtil.getBrowser();
        jsExecutor.executeScript("arguments[0].setAttribute('style', 'border:2px solid red; background:yellow')", element);
    }

    public void waitForDomToLoad() {
        wait = new WebDriverWait(BrowserUtil.getBrowser(), Duration.ofSeconds(30));
        wait.until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
    }

    public WebElement waitForVisible(By by) {
        waitForDomToLoad();
        return (new WebDriverWait(BrowserUtil.getBrowser(), Duration.ofSeconds(120)))
                .until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void click(By by) {
        waitForVisible(by);
        waitForElementToBeClickable(by);
        highLightElement(by);
        BrowserUtil.getBrowser().findElement(by).click();
    }

    public void enterText(By by, String text) {
        waitForVisible(by);
        WebElement element = BrowserUtil.getBrowser().findElement(by);
        highLightElement(by);
        element.clear();
        element.sendKeys(text);
    }

    public boolean isDisplayed(By by) {
        waitForDomToLoad();
        try {
            highLightElement(by);
            return BrowserUtil.getBrowser().findElement(by).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public WebElement waitForElementToBeClickable(By by) {
        waitForDomToLoad();
        highLightElement(by);
        return (new WebDriverWait(BrowserUtil.getBrowser(), Duration.ofSeconds(120)))
                .until(ExpectedConditions.elementToBeClickable(by));
    }

    public String getText(By by) {
        highLightElement(by);
        return waitForVisible(by).getText();
    }

    public ArrayList<String> getTextArray(By by) {
        List<WebElement> elements = BrowserUtil.getBrowser().findElements(by);
        waitForDomToLoad();
        highLightElement(by);
        waitForVisible(by);
        ArrayList<String> allText = new ArrayList<>();
        for (WebElement ele : elements) {
            allText.add(ele.getText());
        }
        return allText;
    }

    /**
     * This method is to generate random string
     *
     * @return
     */
    public static String generateRandomString(int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }

    /**
     * This method is to generate a random email
     *
     * @param domain
     * @param length
     * @return
     */
    public static String generateRandomEmail(String domain, int length) {
        //String domain = "Testpartner.com"; // Change this to your desired domain
        return RandomStringUtils.randomAlphabetic(length) + "@" + domain;
    }

    /**
     * This method is to generate random digits
     *
     * @return
     */
    public static String generateRandomDigits(int j) {
        return RandomStringUtils.randomNumeric(j);
    }

    public void getScreenshot(String filePath) throws Exception {
        File srcFile = ((TakesScreenshot) BrowserUtil.getBrowser()).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(filePath));
    }

    /**
     * This method is to select value from drop down
     *
     * @param by
     * @param value
     */
    public void selectValueFromDropDown(By by, String value) {
        objSelect = new Select(BrowserUtil.getBrowser().findElement(by));
        objSelect.selectByVisibleText(value);
    }
}