package com.filejet.feature.locators.entities;

import com.filejet.helper.BaseHelp;
import org.openqa.selenium.By;

public class EntitiesLocators extends BaseHelp {
    public By addEntityBtn = By.xpath("//div[@class='d-flex w-100 mt-3 mt-md-0']");
    public String entityPageFields = "//select[contains(@class,'type')][@name='%s']";
    public String nameField = "//input[@name='name']";
}
