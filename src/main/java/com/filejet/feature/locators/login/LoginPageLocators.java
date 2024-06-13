package com.filejet.feature.locators.login;

import com.filejet.helper.BaseHelp;
import org.openqa.selenium.By;

/**
 * This class contains Login Page related locators
 */
public class LoginPageLocators extends BaseHelp {
    public By userName = By.id("email");
    public By password = By.id("password");
    public By loginButton = By.xpath("//button[@type='submit']");
}
