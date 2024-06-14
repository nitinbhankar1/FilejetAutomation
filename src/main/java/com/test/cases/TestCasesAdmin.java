package com.test.cases;

import com.filejet.feature.pages.home.HomePage;
import com.filejet.feature.pages.login.LoginPage;
import com.filejet.feature.pages.partners.PartnersPage;
import com.filejet.feature.pages.Orders.OrderPage;
import com.filejet.feature.pages.partners.PartnersViewPage;
import com.filejet.helper.BaseHelp;
import com.filejet.util.HelpBase;
import com.filejet.util.PropertiesUtil;
import com.test.testData.CommonTestData;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.*;

public class TestCasesAdmin extends HelpBase {

    HomePage homePage;
    PartnersPage partnersPage;
    OrderPage ordersPage;

    String value;

    Map<String, String> map = new HashMap<>();

    static String phone;
    PartnersViewPage partnersViewPage;
    String actualValue;
    String expectedValue;

    SoftAssert softAssert = new SoftAssert();

    @Test(description = "Verify user can add partner in Admin portal")
    public void verifyAddPartner() {
        LoginPage loginPage = new LoginPage(HelpBase.driver);
        homePage = loginPage.loginPartnerUser();
        Assert.assertEquals(homePage.verifyAdminHomePageLogoDisplayed(), "Dashboard",
                "Home Page logo is not displaying");
        partnersPage = homePage.clickOnNavigationTab(CommonTestData.NavigationLinks.PARTNERS.getNavigationLink());
        Assert.assertTrue(partnersPage.verifyAddPartnerBtnDisplayed(), "Add Partner button is not visible on Partner page");
        partnersPage.clickAddPartnerBtn();

        // Enter data in Name
        value = "AutoName_" + BaseHelp.generateRandomString(9);
        partnersPage.enterTextInPartnerField(CommonTestData.AddPartnerFormFields.Name.getPartnerPageField(),
                value);
        map.put(CommonTestData.AddPartnerFormFields.Name.getPartnerPageField(), value);


        // Enter data in Email
        value = "auto" + BaseHelp.generateRandomEmail("testpartner.com", 8);
        partnersPage.enterTextInPartnerField(CommonTestData.AddPartnerFormFields.EMAIL.getPartnerPageField(),
                value);
        map.put(CommonTestData.AddPartnerFormFields.EMAIL.getPartnerPageField(), value);


        // Enter data in Phone
        phone = BaseHelp.generateRandomDigits(10);
        // 1. TODO : Fix for input name which is changing the digits position while input
        partnersPage.enterTextInPartnerField(CommonTestData.AddPartnerFormFields.PHONE.getPartnerPageField(),
                "9876543210");
        map.put(CommonTestData.AddPartnerFormFields.PHONE.getPartnerPageField(), "9876543210");


        // Enter data in Fax
        String fax = BaseHelp.generateRandomDigits(10);
        partnersPage.enterTextInPartnerField(CommonTestData.AddPartnerFormFields.FAX.getPartnerPageField(),
                fax);
        map.put(CommonTestData.AddPartnerFormFields.FAX.getPartnerPageField(), fax);


        // Enter data in Address
        value = "AutoAddress_" + BaseHelp.generateRandomString(9);
        partnersPage.enterTextInPartnerField(CommonTestData.AddPartnerFormFields.Address.getPartnerPageField(),
                value);
        map.put(CommonTestData.AddPartnerFormFields.Address.getPartnerPageField(), value);


        // Enter data in City
        value = "AutoCity_" + BaseHelp.generateRandomString(9);
        partnersPage.enterTextInPartnerField(CommonTestData.AddPartnerFormFields.City.getPartnerPageField(),
                value);
        map.put(CommonTestData.AddPartnerFormFields.City.getPartnerPageField(), value);


        // Select State
        partnersPage.selectState(CommonTestData.States.MS.getState());

        // Enter data in Zip
        String zip = BaseHelp.generateRandomDigits(5);
        partnersPage.enterTextInPartnerField(CommonTestData.AddPartnerFormFields.ZIP.getPartnerPageField(),
                zip);
        map.put(CommonTestData.AddPartnerFormFields.ZIP.getPartnerPageField(), zip);


        // Select radio button for partner plan
        partnersPage.selectPlatformPlan(PartnersPage.PartnerPlans.BASE.getPartnerPlan());

        // Saved the form
        partnersViewPage = partnersPage.saveChangesPartner();


        // Now, verify Partner is created successfully with valid information
        // Verify name
        actualValue = partnersViewPage.getPartnerInfo(CommonTestData.AddPartnerFormFields.Name.name());
        expectedValue = map.get(CommonTestData.AddPartnerFormFields.Name.getPartnerPageField());
        softAssert.assertEquals(actualValue, expectedValue, "Entered partner name and saved partner name value is not same," +
                " actual value is = " + actualValue + " expected value is = " + expectedValue);

        // Verify Email
        actualValue = partnersViewPage.getPartnerInfo(CommonTestData.AddPartnerFormFields.EMAIL_ADDRESS.getPartnerPageField());
        expectedValue = map.get(CommonTestData.AddPartnerFormFields.EMAIL.getPartnerPageField());
        softAssert.assertEquals(actualValue, expectedValue, "Entered partner Email and saved partner Email value is not same," +
                " actual value is = " + actualValue + " expected value is = " + expectedValue);

        // TODO : PHONE validation needs to add

        // Verify address along with city, state, zip
        actualValue = partnersViewPage.getPartnerInfo(CommonTestData.AddPartnerFormFields.Address.name() + " ");
        expectedValue = map.get(CommonTestData.AddPartnerFormFields.Address.getPartnerPageField());
        expectedValue = expectedValue + ", " + map.get(CommonTestData.AddPartnerFormFields.City.getPartnerPageField());
        expectedValue = expectedValue + ", " + CommonTestData.States.MS.name();
        expectedValue = expectedValue + " " + map.get(CommonTestData.AddPartnerFormFields.ZIP.getPartnerPageField());
        softAssert.assertEquals(actualValue, expectedValue,
                "Entered partner Email and saved partner Email value is not same," +
                        " actual value is = " + actualValue + " expected value is = " + expectedValue);
        softAssert.assertAll();
    }

    @Test(description = "Verify validation messages for invalid data in create partner form")
    public void verifyValidationsForInvalidData() throws IOException {
        PropertiesUtil testData;
        testData = new PropertiesUtil("testData.properties");
        LoginPage loginPage = new LoginPage(HelpBase.driver);
        homePage = loginPage.loginPartnerUser();
        Assert.assertEquals(homePage.verifyAdminHomePageLogoDisplayed(), "Dashboard", "Home Page logo is not displaying");
        partnersPage = homePage.clickOnNavigationTab(CommonTestData.NavigationLinks.PARTNERS.getNavigationLink());
        Assert.assertTrue(partnersPage.verifyAddPartnerBtnDisplayed(), "Add Partner button is not visible on Partner page");
        partnersPage.clickAddPartnerBtn();

        //enter data--------------------------------------------
        partnersPage.enterTextInPartnerField(CommonTestData.AddPartnerFormFields.Name.getPartnerPageField(),
                "");
        partnersPage.enterTextInPartnerField(CommonTestData.AddPartnerFormFields.EMAIL.getPartnerPageField(),
                testData.getProperty("invalid.email"));
        partnersPage.enterTextInPartnerField(CommonTestData.AddPartnerFormFields.PHONE.getPartnerPageField(),
                testData.getProperty("invalid.phone"));
        partnersPage.enterTextInPartnerField(CommonTestData.AddPartnerFormFields.FAX.getPartnerPageField(),
                testData.getProperty("invalid.fax"));
        partnersPage.enterTextInPartnerField(CommonTestData.AddPartnerFormFields.Address.getPartnerPageField(),
                testData.getProperty("invalid.address"));
        partnersPage.enterTextInPartnerField(CommonTestData.AddPartnerFormFields.City.getPartnerPageField(),
                testData.getProperty("invalid.city"));
        partnersPage.enterTextInPartnerField(CommonTestData.AddPartnerFormFields.ZIP.getPartnerPageField(),
                testData.getProperty("invalid.zip"));

        partnersViewPage = partnersPage.saveChangesPartner();

        softAssert.assertEquals(partnersPage.getErrorMessageForField(CommonTestData.AddPartnerFormFields.Name.name()),
                testData.getProperty("error.name.address.city.state"), "Error message for empty name format is not displayed");

        softAssert.assertEquals(partnersPage.getErrorMessageForField(CommonTestData.AddPartnerFormFields.EMAIL_address.getPartnerPageField()),
                testData.getProperty("error.email"), "Error message for email format is not displayed");

        softAssert.assertEquals(partnersPage.getErrorMessageForField(CommonTestData.AddPartnerFormFields.PHONE_NUMBER.getPartnerPageField()),
                testData.getProperty("error.phone"), "Error message for phone format is not displayed");

        softAssert.assertEquals(partnersPage.getErrorMessageForField(CommonTestData.AddPartnerFormFields.FAX_NUMBER.getPartnerPageField()),
                testData.getProperty("error.fax"), "Error message for Fax format is not displayed");

        softAssert.assertEquals(partnersPage.getErrorMessageForField(CommonTestData.AddPartnerFormFields.ZIP_CODE.getPartnerPageField()),
                testData.getProperty("error.zip"), "Error message for ZIP format is not displayed");

        softAssert.assertEquals(partnersPage.getErrorMessageForField(CommonTestData.AddPartnerFormFields.Address.name()),
                testData.getProperty("error.name.address.city.state"), "Error message for Address format is not displayed");

        softAssert.assertEquals(partnersPage.getErrorMessageForField(CommonTestData.AddPartnerFormFields.City.name()),
                testData.getProperty("error.name.address.city.state"), "Error message for City format is not displayed");

        softAssert.assertEquals(partnersPage.getErrorMessageForField(CommonTestData.AddPartnerFormFields.STATE.getPartnerPageField()),
                testData.getProperty("error.name.address.city.state"), "Error message for State format is not displayed");

        softAssert.assertEquals(partnersPage.getErrorMessageForField(CommonTestData.AddPartnerFormFields.PLATFORM_PLAN.getPartnerPageField()),
                testData.getProperty("error.platformPlan"), "Error message for Partner Plan format is not displayed");
        softAssert.assertAll();
    }

    @Test(description ="Verify user can see create and wait the partner orders in Admin")
    public void verifyOrderActions () throws IOException{

        LoginPage loginPage = new LoginPage(HelpBase.driver);
        homePage = loginPage.loginPartnerUser();
        Assert.assertEquals(homePage.verifyAdminHomePageLogoDisplayed(), "Dashboard",
                "Home Page logo is not displaying");
        ordersPage = homePage.clickOnNavigationTabOrders(CommonTestData.NavigationLinks.ORDERS.getNavigationLink());
        Assert.assertTrue(ordersPage.verifyTakeActionButtonDisplayed(),"Take Action button is visible for the Orders");
       ordersPage.clickTakeActionButton();




    }


}

