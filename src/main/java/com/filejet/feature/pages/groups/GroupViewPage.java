package com.filejet.feature.pages.groups;

import com.filejet.feature.locators.groups.GroupLocators;
import com.filejet.feature.locators.groups.GroupViewPageLocators;
import com.filejet.utilities.ExtentTestManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GroupViewPage extends GroupViewPageLocators {
    private WebDriver driver;

    public GroupViewPage(WebDriver driver) {
        this.driver = driver;
        waitForDomToLoad();
    }

    /**
     * Get value for partner info   yet to do
     * @param fieldName
     * @return
     */
    public String getGroupInfo(String fieldName){
        waitForVisible(By.xpath(String.format(viewGroupInfo,fieldName)));
        ExtentTestManager.ReporterLog("Get value for = "+fieldName);
        return getText(By.xpath(String.format(viewGroupInfo,fieldName)));
    }

    public String getGroupName(){
        waitForVisible(groupName);
        ExtentTestManager.ReporterLog("Get value for group name");
        return getText(groupName);
    }
}
