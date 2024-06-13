package com.filejet.feature.pages.entities;

import com.filejet.feature.locators.entities.EntitiesLocators;
import com.filejet.utilities.ExtentTestManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EntityPage extends EntitiesLocators {
    private WebDriver driver;

    public EntityPage(WebDriver driver) {
        this.driver = driver;
        waitForDomToLoad();
    }

    /**
     * this method verify "Add Entity" button is displaying on Partner page
     *
     * @return
     */

    public boolean verifyAddEntityBtnDisplayed() {
        waitForVisible(addEntityBtn);
        ExtentTestManager.ReporterLog("Now, verify 'Add Entity' button is displaying on Group page");
        return isDisplayed(addEntityBtn);
    }

    public void selectEntityDetail(String fieldName, String fieldValue) {
        ExtentTestManager.ReporterLog("Enter text in field " + String.format(nameField, fieldName));
        waitForDomToLoad();
        waitForVisible(By.xpath(String.format(entityPageFields,fieldName)));
        selectValueFromDropDown(By.xpath(String.format(entityPageFields,fieldName)), fieldValue);
    }
    public void enterEntityName(String fieldName, String fieldValue) {
        ExtentTestManager.ReporterLog("Enter text in field " + String.format(nameField, fieldName));
        enterText(By.xpath(String.format(nameField, fieldName)), fieldValue);
    }

    public EntityPage submitButtonClick() {
        waitForElementToBeClickable(addEntityBtn);
        ExtentTestManager.ReporterLog("Now, clicking on Add Entity button");
        click(addEntityBtn);
        return new EntityPage(driver);
    }
    /**
     * This enum contains FormationType dropdown options
     */
    public static enum FormationType {

        DOMESTIC("Domestic"), FOREIGN("Foreign");

        private final String formationType;

        FormationType(String formationType) {
            this.formationType = formationType;
        }

        public String getFormationType() {
            return formationType;
        }


    }
}
