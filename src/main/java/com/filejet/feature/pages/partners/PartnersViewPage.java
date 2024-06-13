package com.filejet.feature.pages.partners;

import com.filejet.feature.locators.partners.PartnersPageLocators;
import com.filejet.feature.locators.partners.PartnersViewPageLocators;
import com.filejet.utilities.ExtentTestManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * This class is to hold methods for View partner page
 */
public class PartnersViewPage extends PartnersViewPageLocators {

    private WebDriver driver;

    public PartnersViewPage(WebDriver driver) {
        this.driver = driver;
        waitForDomToLoad();
    }

    /**
     * Get value for partner info
     * @param fieldName
     * @return
     */
    public String getPartnerInfo(String fieldName){
        waitForVisible(By.xpath(String.format(viewPartnerInfo,fieldName)));
        ExtentTestManager.ReporterLog("Get value for = "+fieldName);
        return getText(By.xpath(String.format(viewPartnerInfo,fieldName)));
    }
}
