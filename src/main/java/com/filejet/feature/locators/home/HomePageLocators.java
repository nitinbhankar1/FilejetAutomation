package com.filejet.feature.locators.home;

import com.filejet.helper.BaseHelp;
import org.openqa.selenium.By;

/**
 * This class contains Home Page related locators
 */
public class HomePageLocators extends BaseHelp {
    public By homePageLogo = By.xpath("//h3//strong");
    public By adminHomePageLogo = By.xpath("//h4[@class='page-title']");
    public String navigationTab = "//div[@class='left-side-menu']//i[contains(@class,'mdi mdi-')]//following-sibling::span[contains(text(),'%s')]";
    public String partnerNavigationTab = "[[//ul[contains(@class, 'menu-link')]]]//li[contains(@class, 'nav-link')]//span[contains(text(), '%s')]";
}
