package com.filejet.feature.locators.orders;

import com.filejet.helper.BaseHelp;
import org.openqa.selenium.By;

public class OrdersPageLocators extends BaseHelp {

    public By orderPageLogo = By.xpath("//h4[@class='page-title']");
    public By takeActionButton = By.xpath("//button[@class='btn btn-secondary dropdown-toggle waves-effect waves-light'][1]");
    public By assignButton = By.xpath("(//a[@class='dropdown-item btn-assign'])[1]");
}

