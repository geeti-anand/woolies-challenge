package com.woolies_challenge.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderSummaryPageModel extends BasePage {

    public OrderSummaryPageModel(WebDriver driver) {
        super(driver);
    }

    public void clickOnCheckoutButton() {
        WebElement checkoutButton = driver.findElement(By.cssSelector(".button.btn.btn-default.standard-checkout.button-medium"));
        checkoutButton.click();
    }

}
