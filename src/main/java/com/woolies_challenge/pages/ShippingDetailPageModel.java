package com.woolies_challenge.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShippingDetailPageModel extends BasePage {

    public ShippingDetailPageModel(WebDriver driver) {
        super(driver);
    }

    public void clickOnTermsOfServiceCheckbox() {
        driver.findElement(By.id("uniform-cgv")).click();

    }

    public void clickCheckout() {

        waitForVisibilityAndClick(driver.findElement(By.name("processCarrier")));
    }

    public void clickOnPaymentType(String paymentType) {
        driver.findElement(By.className(paymentType)).click();

    }
}
