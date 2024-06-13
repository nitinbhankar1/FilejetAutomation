package com.filejet.feature.pages.partners;

import com.filejet.feature.locators.partners.PartnersPageLocators;
import com.filejet.utilities.ExtentTestManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PartnersPage extends PartnersPageLocators {

    private WebDriver driver;

    public PartnersPage(WebDriver driver) {
        this.driver = driver;
        waitForDomToLoad();
    }

    /**
     * this method verify "Add Partner" button is displaying on Partner page
     *
     * @return
     */
    public boolean verifyAddPartnerBtnDisplayed() {
        waitForVisible(addPartnerBtn);
        ExtentTestManager.ReporterLog("Now, verify 'Add Partner' button is displaying on Partner page");
        return isDisplayed(addPartnerBtn);
    }

    public void clickAddPartnerBtn() {
        waitForElementToBeClickable(addPartnerBtn);
        ExtentTestManager.ReporterLog("Now, clicking on Add Partner button");
        click(addPartnerBtn);
    }

    public void enterTextInPartnerField(String fieldName, String fieldValue) {
        ExtentTestManager.ReporterLog("Enter text in field " + String.format(partnerPageFields, fieldName));
        enterText(By.xpath(String.format(partnerPageFields, fieldName)), fieldValue);
    }

    /**
     * This method is to select state from drop down
     *
     * @param value
     */
    public void selectState(String value) {
        selectValueFromDropDown(state, value);
        ExtentTestManager.ReporterLog("Now, select state = " + value);
    }

    /**
     * This method is to click on radio button
     *
     * @param platformPlanText
     */
    public void selectPlatformPlan(String platformPlanText) {
        ExtentTestManager.ReporterLog("Enter text in field " + String.format(selectRadioBtn, platformPlanText));
        click(By.xpath(String.format(selectRadioBtn, platformPlanText)));
    }

    public static enum PartnerPlans {
        BASE("The Base Platform"), PROFESSIONAL("The Professional Platform"),
        MANAGED("Managed by FileJet");

        private final String partnerPlan;

        PartnerPlans(String partnerPlan) {
            this.partnerPlan = partnerPlan;
        }

        public String getPartnerPlan() {
            return partnerPlan;
        }
    }

    /**
     * This method is to click on Save Changes button on Create Partner page
     */
    public PartnersViewPage saveChangesPartner() {
        ExtentTestManager.ReporterLog("Now, click on Save Changes button");
        click(saveButton);
        return new PartnersViewPage(driver);
    }

    public String getErrorMessageForField(String fieldLabel) {
        if(!(fieldLabel.equals("State") || fieldLabel.equals("Platform Plan"))){
            waitForVisible(By.xpath(String.format(errorMsg, fieldLabel)));
            ExtentTestManager.ReporterLog("Checking if error message is displayed for: " + fieldLabel);
            return getText(By.xpath(String.format(errorMsg, fieldLabel)));
        } else {
            waitForVisible(By.xpath(String.format(statePartnerPlanErrorMsg, fieldLabel)));
            ExtentTestManager.ReporterLog("Checking if error message is displayed for: " + fieldLabel);
            return getText(By.xpath(String.format(statePartnerPlanErrorMsg, fieldLabel)));
        }
    }
}
