package com.filejet.feature.pages.Orders;

import com.filejet.feature.locators.OrdersLocators;
import com.filejet.utilities.ExtentTestManager;
import org.openqa.selenium.WebDriver;


public class OrderPage extends OrdersLocators {

    private WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
        waitForDomToLoad();

    }

    public boolean verifyOrderPAgeLogoDisplayed(){
        waitForVisible(orderPageLogo);
        ExtentTestManager.ReporterLog("Verify 'Order' is displaying on Order Page");
        return isDisplayed(orderPageLogo);

    }

}
