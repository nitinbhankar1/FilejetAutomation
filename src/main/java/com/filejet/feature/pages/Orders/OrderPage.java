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

    public boolean verifyAssignButtonDisplayed(){
        waitForVisible(assignButton);
        ExtentTestManager.ReporterLog(("Verify 'Assign' button is displayed on Order Page"));
        return isDisplayed(assignButton);
    }

    public void clickAssignButton(){
        click(assignButton);
    }
    public boolean verifySaveChangesButtonDisplayed(){
        waitForVisible(saveChangesButton);
        ExtentTestManager.ReporterLog(("Verify Save changes button is displayed"));
        return isDisplayed(saveChangesButton);

    }

    public void clickChooseUser(){
        click(chooseUserDropdown);
    }

    public void selectUser(){
        click(selectUserDropDown);
    }

    public void clickSaveChangesButton(){
        click(saveChangesButton);
    }

}
