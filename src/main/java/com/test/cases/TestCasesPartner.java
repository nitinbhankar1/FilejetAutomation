package com.test.cases;

import com.filejet.feature.pages.entities.EntityPage;
import com.filejet.feature.pages.groups.GroupPage;
import com.filejet.feature.pages.groups.GroupViewPage;
import com.filejet.feature.pages.home.HomePage;
import com.filejet.feature.pages.login.LoginPage;
import com.filejet.helper.BaseHelp;
import com.filejet.util.HelpBase;
import com.filejet.util.PropertiesUtil;
import com.test.testData.CommonTestData;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TestCasesPartner extends HelpBase {
    HomePage homePage;
    GroupPage groupPage;
    String value;
    String actualValue;
    String expectedValue;
    SoftAssert softAssert = new SoftAssert();
    Map<String, String> map = new HashMap<>();
    GroupViewPage groupViewPage;
    PropertiesUtil testData;

    EntityPage entityPage;

    @Test(description = "Verify user can login successfully", priority = 1)
    public void userLogin() {
        LoginPage loginPage = new LoginPage(HelpBase.driver);
        homePage = loginPage.loginPartnerUser();
        Assert.assertEquals(homePage.verifyHomePageLogoDisplayed(), "Dashboard",
                "Home Page logo is not displaying");
    }

    @Test(description = "Verify user can add Group successfully", priority = 2)
    public void verifyAddGroup() {
        LoginPage loginPage = new LoginPage(HelpBase.driver);
        homePage = loginPage.loginPartnerUser();
        Assert.assertEquals(homePage.verifyHomePageLogoDisplayed(), "Dashboard",
                "Home Page logo is not displaying");
        groupPage = homePage.clickOnNavigationTabPartner(CommonTestData.NavigationLinksPartner.GROUPS.getNavigationLink());
        Assert.assertTrue(groupPage.verifyAddGroupBtnDisplayed(), "Add Group button is not visible on Group page");
        groupPage = groupPage.clickAddGroupBtn();

        value = "AutoName_" + BaseHelp.generateRandomString(9);

        // Enter data in Name, Primary Contact, Email, Phone
        groupPage.enterTextInGroupFields(CommonTestData.AddGroupFormFields.Name.getAddGroupFormFields(), value);
        map.put(CommonTestData.AddGroupFormFields.Name.getAddGroupFormFields(), value);

        value = "Test_Primary" + BaseHelp.generateRandomString(9);
        groupPage.enterTextInGroupFields(CommonTestData.AddGroupFormFields.PRIMARY_CONTACT.getAddGroupFormFields(), value);
        map.put(CommonTestData.AddGroupFormFields.PRIMARY_CONTACT.getAddGroupFormFields(), value);

        value = "auto" + BaseHelp.generateRandomEmail("testpartner.com", 8);
        groupPage.enterTextInGroupFields(CommonTestData.AddGroupFormFields.EMAIL.getAddGroupFormFields(), value);
        map.put(CommonTestData.AddGroupFormFields.EMAIL.getAddGroupFormFields(), value);

        groupPage.enterTextInGroupFields(CommonTestData.AddGroupFormFields.PHONE.getAddGroupFormFields(), "9976543210");
        map.put(CommonTestData.AddGroupFormFields.PHONE.getAddGroupFormFields(), "9976543210");

        // Click on save button
        groupViewPage = groupPage.saveChangesGroup();

        // Now, verify Group is created successfully with valid information
        actualValue = groupViewPage.getGroupName();
        expectedValue = map.get(CommonTestData.AddGroupFormFields.Name.getAddGroupFormFields());
        softAssert.assertEquals(actualValue, expectedValue, "Entered name value is not same," +
                " actual value is = " + actualValue + " expected value is = " + expectedValue);

        actualValue = groupViewPage.getGroupInfo(CommonTestData.AddGroupFormFields.PRIMARY_CONTACT_SAVED.getAddGroupFormFields());
        expectedValue = map.get(CommonTestData.AddGroupFormFields.PRIMARY_CONTACT.getAddGroupFormFields());
        softAssert.assertEquals(actualValue, expectedValue, "Entered Primary Contact  and saved Primary Contact value is not same," +
                " actual value is = " + actualValue + " expected value is = " + expectedValue);

        // Verify Email
        actualValue = groupViewPage.getGroupInfo(CommonTestData.AddGroupFormFields.EMAIL_SAVED.getAddGroupFormFields());
        expectedValue = map.get(CommonTestData.AddGroupFormFields.EMAIL.getAddGroupFormFields());
        softAssert.assertEquals(actualValue, expectedValue, "Entered Group Mail  and saved Group Mail value is not same," +
                " actual value is = " + actualValue + " expected value is = " + expectedValue);

        // Verify Phone
        /*actualValue = groupViewPage.getGroupInfo(CommonTestData.AddGroupFormFields.PHONE_SAVED.getAddGroupFormFields());
        expectedValue = map.get(CommonTestData.AddGroupFormFields.PHONE.getAddGroupFormFields());
        softAssert.assertEquals(actualValue, expectedValue, "Entered Group Mail  and saved Group Mail value is not same," +
                " actual value is = " + actualValue + " expected value is = " + expectedValue);*/

        softAssert.assertAll();
    }

    @Test(description = "Verify validation messages for invalid data in create group form", priority = 1)
    public void verifyValidationsForInvalidGroupData() throws IOException {
        testData = new PropertiesUtil("testData.properties");
        LoginPage loginPage = new LoginPage(HelpBase.driver);
        homePage = loginPage.loginPartnerUser();
        Assert.assertEquals(homePage.verifyHomePageLogoDisplayed(), "Dashboard", "Home Page logo is not displaying");
        groupPage = homePage.clickOnNavigationTabPartner(CommonTestData.NavigationLinksPartner.GROUPS.getNavigationLink());
        Assert.assertTrue(groupPage.verifyAddGroupBtnDisplayed(), "Add Group button is not visible on Group page");
        groupPage.clickAddGroupBtn();
        groupViewPage = groupPage.saveChangesGroup();
        softAssert.assertTrue(groupPage.isErrorMessageForField(CommonTestData.AddGroupFormFields.Name.getAddGroupFormFields()),
                "Validation message is not visible");
        softAssert.assertTrue(groupPage.isErrorMessageForField(CommonTestData.AddGroupFormFields.PRIMARY_CONTACT.getAddGroupFormFields()),
                "Validation message is not visible");
        softAssert.assertTrue(groupPage.isErrorMessageForField(CommonTestData.AddGroupFormFields.EMAIL.getAddGroupFormFields()),
                "Validation message is not visible");
        softAssert.assertTrue(groupPage.isErrorMessageForField(CommonTestData.AddGroupFormFields.PHONE.getAddGroupFormFields()),
                "Validation message is not visible");
        softAssert.assertAll();
    }

    @Test(description = "Verify user can add Entity successfully", priority = 2)
    public void verifyAddEntity() throws InterruptedException {
        LoginPage loginPage = new LoginPage(HelpBase.driver);
        homePage = loginPage.loginPartnerUser();
        Assert.assertEquals(homePage.verifyHomePageLogoDisplayed(), "Dashboard",
                "Home Page logo is not displaying");
        entityPage = homePage.clickOnNavigationTabEntity(CommonTestData.NavigationLinksPartner.ENTITIES.getNavigationLink());
        Assert.assertTrue(entityPage.verifyAddEntityBtnDisplayed(), "Add Group button is not visible on Group page");
        entityPage = entityPage.submitButtonClick();


        entityPage.selectEntityDetail(CommonTestData.AddEntityFormFields.FORMATIONTYPE.getAddEntityFormFields(),
                EntityPage.FormationType.DOMESTIC.getFormationType());
        entityPage.selectEntityDetail(CommonTestData.AddEntityFormFields.STATE.getAddEntityFormFields(),
                CommonTestData.States.ALABAMA.getState());
        Thread.sleep(3000);
        entityPage.selectEntityDetail(CommonTestData.AddEntityFormFields.ENTITYTYPE.getAddEntityFormFields(),
                CommonTestData.EntityType.LLC.getEntityType());

        value = "AutoName_" + BaseHelp.generateRandomString(9);

        // Enter data in Name, Primary Contact, Email, Phone
        entityPage.enterEntityName(CommonTestData.AddGroupFormFields.Name.getAddGroupFormFields(), value);
    }
}