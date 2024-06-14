package com.filejet.feature.pages.Orders;

import com.filejet.feature.locators.orders.OrdersPageLocators;
import com.filejet.utilities.ExtentTestManager;
import org.openqa.selenium.WebDriver;


public class OrderPage extends OrdersPageLocators {

    private WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
        waitForDomToLoad();

    }

    public boolean verifyOrderPageLogoDisplayed(){
        waitForVisible(orderPageLogo);
        ExtentTestManager.ReporterLog("Verify 'Order' is displaying on Order Page");
        return isDisplayed(orderPageLogo);

    }

    public boolean verifyTakeActionButtonDisplayed(){
        waitForVisible(takeActionButton);
        ExtentTestManager.ReporterLog(("Verify 'Take Action' is displaying on Order Page"));
        return isDisplayed(takeActionButton);

    }

    public void clickTakeActionButton(){
        click(takeActionButton);
    }

}
