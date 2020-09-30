package com.woolies_challenge.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddressPageModel extends BasePage {

    public AddressPageModel(WebDriver driver) {
        super(driver);
    }

    public void clickCheckoutOnAddressPage() {
        WebElement checkoutButton = driver.findElement(By.name("processAddress"));
        waitForVisibilityAndClick(checkoutButton);
    }
}
