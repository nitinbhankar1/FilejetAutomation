package com.filejet.feature.locators.groups;

import com.filejet.helper.BaseHelp;
import org.openqa.selenium.By;

public class GroupLocators extends BaseHelp {
    public By addGroupBtn = By.xpath("//div//button[contains(text(),'Create')]");
    public String groupPageFields = "//form[@id='groupsForm']//input[@id='%s']";
    public By createBtn = By.xpath("//button[@id='save-group-btn']");
    public String requiredFieldError = "//h3[text()='Group Details']//ancestor::div[contains(@class,'modal-content')]//input[@id='%s']//..//div[contains(@class,'parentFormgroupsForm')]";

}
