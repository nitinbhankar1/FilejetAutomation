package com.filejet.feature.pages.groups;

import com.filejet.feature.locators.groups.GroupLocators;
import com.filejet.utilities.ExtentTestManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GroupPage extends GroupLocators {
    private WebDriver driver;

    public GroupPage(WebDriver driver) {
        this.driver = driver;
        waitForDomToLoad();
    }

    /**
     * this method verify "Add Group" button is displaying on Partner page
     *
     * @return
     */
    public boolean verifyAddGroupBtnDisplayed() {
        waitForVisible(addGroupBtn);
        ExtentTestManager.ReporterLog("Now, verify 'Add Group' button is displaying on Group page");
        return isDisplayed(addGroupBtn);
    }

    public GroupPage clickAddGroupBtn() {
        waitForElementToBeClickable(addGroupBtn);
        ExtentTestManager.ReporterLog("Now, clicking on Add Group button");
        click(addGroupBtn);
        return new GroupPage(driver);
    }

    public void enterTextInGroupFields(String fieldName, String fieldValue) {
        ExtentTestManager.ReporterLog("Enter text in field " + String.format(groupPageFields, fieldName));
        enterText(By.xpath(String.format(groupPageFields, fieldName)), fieldValue);
    }

    /**
     * This method is to click on Save Changes button on Create Group page
     */

    public GroupViewPage saveChangesGroup() {
        ExtentTestManager.ReporterLog("Now, click on Save Changes button");
        click(createBtn);
        return new GroupViewPage(driver);
    }

    public boolean isErrorMessageForField(String fieldLabel) {
        ExtentTestManager.ReporterLog("Checking if error message is displayed for: "
                + String.format(requiredFieldError, fieldLabel));
        return isDisplayed(By.xpath(String.format(requiredFieldError, fieldLabel)));
    }
}