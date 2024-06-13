package com.filejet.feature.locators.groups;

import com.filejet.helper.BaseHelp;
import org.openqa.selenium.By;

public class GroupViewPageLocators extends BaseHelp {
    public String viewGroupInfo = "//div/div[text()='%s']//following-sibling::div";
    public By groupName = By.xpath("//h3[@class='fw-bold']");
}
