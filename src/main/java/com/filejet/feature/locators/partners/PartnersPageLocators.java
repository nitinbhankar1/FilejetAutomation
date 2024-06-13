package com.filejet.feature.locators.partners;

import com.filejet.helper.BaseHelp;
import org.openqa.selenium.By;

/**
 * This class contains Partner Page related locators
 */
public class PartnersPageLocators extends BaseHelp {
    public By addPartnerBtn = By.xpath("//button//span[contains(text(),'Add Partner')]");
    public String partnerPageFields = "//div[@class='card-box']//div[contains(@class, 'form-group')]//input[@name='%s']";

    public By state = By.id("state_id");

    public String selectRadioBtn = "//div[@class='radio radio-primary']//label[contains(text(),'%s')]//../input//../label";

    public By saveButton = By.xpath("//button[@type='submit']");

    public String errorMsg= "//label[text()='%s']//following-sibling::ul//li";

    public String statePartnerPlanErrorMsg = "//label[contains(text(),'%s')]/following-sibling::div//ul/li";

}
