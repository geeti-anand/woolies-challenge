package com.woolies_challenge.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaymentsPageModel extends BasePage {

    public PaymentsPageModel(WebDriver driver) {

        super(driver);
    }

    public void clickOnOrderConfirmationButton() {
        WebElement orderConfirmationButton = driver.findElement(By.cssSelector("button.btn.btn-default.button-medium"));
        orderConfirmationButton.click();
    }

    public String getPageHeadingText() {
        WebElement pageHeadingElement = driver.findElement(By.className("page-heading"));
        return pageHeadingElement.getText();
    }

    public String getOrderConfMsg() {
        WebElement element = driver.findElement(By.className("cheque-indent"));
        return element.findElement(By.tagName("strong")).getText();
    }

}
