package com.woolies_challenge.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {

        this.driver = driver;
    }

    public void goToUrl(String url) {
        driver.get(url);
    }

    public String getCurrentPageUrl() {
        String currentUrl = driver.getCurrentUrl();
        return currentUrl;
    }


    public void waitForVisibilityAndClick(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }

}
