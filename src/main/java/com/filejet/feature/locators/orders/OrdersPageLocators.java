package com.filejet.feature.locators.orders;

import com.filejet.helper.BaseHelp;

import org.openqa.selenium.By;

public class OrdersPageLocators extends BaseHelp {

    public By orderPageLogo = By.xpath("//h4[@class='page-title']");
    public By takeActionButton = By.xpath("//button[@class='btn btn-secondary dropdown-toggle waves-effect waves-light'][1]");
    public By assignButton = By.xpath("(//a[@class='dropdown-item btn-assign'])[1]");
    public By chooseUserDropdown = By.xpath("//select[@class='custom-select form-option1']");
    public By selectUserDropDown = By.xpath(" //option[@value='2']");
    public By saveChangesButton = By.xpath ("//button[@type='submit']");
}

