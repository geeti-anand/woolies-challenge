package com.woolies_challenge.factory;

import com.woolies_challenge.pages.*;
import org.openqa.selenium.WebDriver;

public class PageSelection {

    private static WebDriver driver = BrowserSelection.getBrowser();

    public static BasePage getPage(String pageName) {
        BasePage page = null;

        switch (pageName) {
            case "homePage":
                page = new HomePageModel(driver);
                break;
            case "productListingPage":
                page = new ProductListingPageModel(driver);
                break;
            case "orderSummaryPage":
                page = new OrderSummaryPageModel(driver);
                break;
            case "addressSummaryPage":
                page = new AddressPageModel(driver);
                break;
            case "shippingPage":
                page = new ShippingDetailPageModel(driver);
                break;
            case "paymentsPage":
                page = new PaymentsPageModel(driver);
                break;
        }
        return page;
    }

}

