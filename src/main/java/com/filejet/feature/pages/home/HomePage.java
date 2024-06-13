package com.filejet.feature.pages.home;

import com.codoid.products.fillo.Recordset;
import com.filejet.feature.locators.home.HomePageLocators;
import com.filejet.feature.pages.entities.EntityPage;
import com.filejet.feature.pages.groups.GroupPage;
import com.filejet.feature.pages.partners.PartnersPage;
import com.filejet.feature.pages.Orders.OrderPage;
import com.filejet.helper.AppUserUtility;
import com.filejet.util.ExcelUtil;
import com.filejet.utilities.ExtentTestManager;
import org.openqa.selenium.*;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends HomePageLocators {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        waitForDomToLoad();
    }

    public String verifyHomePageLogoDisplayed() {
        waitForVisible(homePageLogo);
        String logo = getText(homePageLogo);
        return logo;
    }
    public String verifyAdminHomePageLogoDisplayed() {
        waitForVisible(adminHomePageLogo);
        String logo = getText(adminHomePageLogo);
        ExtentTestManager.ReporterLog("get text of Admin Home page logo = "+logo);
        return logo;
    }

    /**
     * This method will click on left navigation link as per the parameter value assigned in navigationTabMenu
     * @param navigationTabMenu
     */
    public PartnersPage clickOnNavigationTab(String navigationTabMenu) {
        waitForVisible(adminHomePageLogo);
        waitForElementToBeClickable(By.xpath(String.format(navigationTab,navigationTabMenu)));
        highLightElement(By.xpath(String.format(navigationTab,navigationTabMenu)));
        click(By.xpath(String.format(navigationTab,navigationTabMenu)));
        ExtentTestManager.ReporterLog("Clicked on navigation tab from left bar "+String.format(navigationTab,navigationTabMenu));
        return new PartnersPage(driver);
    }

    public OrderPage  clickOnNavigationTabOrders(String navigationTabMenuOrders) {
        waitForVisible(adminHomePageLogo);
        waitForElementToBeClickable(By.xpath(String.format(navigationTab,navigationTabMenuOrders)));
        highLightElement(By.xpath(String.format(navigationTab,navigationTabMenuOrders)));
        click(By.xpath(String.format(navigationTab,navigationTabMenuOrders)));
        ExtentTestManager.ReporterLog("Clicked on navigation tab from left bar "+String.format(navigationTab,navigationTabMenuOrders));
        return new OrderPage(driver);
    }


    /**
     * This method will click on left navigation link as per the parameter value assigned in navigationTabMenu in partner portal
     * @param navigationTabMenuPartner
     */
    public GroupPage clickOnNavigationTabPartner(String navigationTabMenuPartner) {
        waitForElementToBeClickable(By.xpath(String.format(partnerNavigationTab,navigationTabMenuPartner)));
        highLightElement(By.xpath(String.format(partnerNavigationTab,navigationTabMenuPartner)));
        click(By.xpath(String.format(partnerNavigationTab,navigationTabMenuPartner)));
        ExtentTestManager.ReporterLog("Clicked on navigation tab from left bar "+String.format(partnerNavigationTab,navigationTabMenuPartner));
        return new GroupPage(driver);
    }

    public EntityPage clickOnNavigationTabEntity(String navigationTabMenuEntity) {
        waitForElementToBeClickable(By.xpath(String.format(partnerNavigationTab,navigationTabMenuEntity)));
        highLightElement(By.xpath(String.format(partnerNavigationTab,navigationTabMenuEntity)));
        click(By.xpath(String.format(partnerNavigationTab,navigationTabMenuEntity)));
        ExtentTestManager.ReporterLog("Clicked on navigation tab from left bar "+String.format(partnerNavigationTab,navigationTabMenuEntity));
        return new EntityPage(driver);
    }
}