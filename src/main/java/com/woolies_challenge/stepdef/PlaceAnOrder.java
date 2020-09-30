package com.woolies_challenge.stepdef;


import com.woolies_challenge.factory.BrowserSelection;
import com.woolies_challenge.factory.PageSelection;
import com.woolies_challenge.pages.*;
import com.woolies_challenge.util.ConfigFile;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class PlaceAnOrder {

    private static Properties properties;

    @Before
    public void setUp() {
     properties = ConfigFile.configProperties();
    }

    @After
    public void after() {
        BrowserSelection.quitDriver();
    }


    @Given("^User is on the homepage$")
    public void navigateToHomepage() {
        String homePageUrl = properties.getProperty("url");
        HomePageModel homePage = (HomePageModel) PageSelection.getPage("homePage");;
        homePage.goToUrl(homePageUrl);
    }


    @When("^User sign in with valid credentials$")
    public void signWithValidCredentials() throws InterruptedException {
        HomePageModel homePage = (HomePageModel) PageSelection.getPage("homePage");
        homePage.signInWithValidCredentials();
        String currentPageUrl = homePage.getCurrentPageUrl();
        Assert.assertEquals("http://automationpractice.com/index.php?controller=my-account", currentPageUrl);


    }

    @Then("^User add two items to the cart$")
    public void addTwoItemsToCart() {
        ProductListingPageModel productListingPage = (ProductListingPageModel) PageSelection.getPage("productListingPage");
        productListingPage.clickOnCategory();
        productListingPage.addToCart(0);
        productListingPage.clickContinueShoppingButton();
        //to add second product in the cart
        navigateToHomepage();
        productListingPage.addToCart(1);
    }

    @Then("^User clicks on the checkout button and proceed to checkout$")
    public void clickAndProceedToCheckout() throws InterruptedException {
        ProductListingPageModel productListingPage = (ProductListingPageModel) PageSelection.getPage("productListingPage");
        productListingPage.clickCheckout();
        
    }

    @Then("^User confirms there are two items in the cart$")
    public void thereShouldBeTwoItemsInTheCart() {
        ProductListingPageModel productListingPage = (ProductListingPageModel) PageSelection.getPage("productListingPage");
        int numberOfCartItems = productListingPage.getProductCount();
        Assert.assertEquals("There should be 2 items in the cart", 2, numberOfCartItems);
    }

    @Then("^User navigates to address details page$")
    public void navigateToAddressDetailsPage() {
        ProductListingPageModel productListingPage = (ProductListingPageModel) PageSelection.getPage("productListingPage");
        String currentPageUrl = productListingPage.getCurrentPageUrl();
        Assert.assertEquals("http://automationpractice.com/index.php?controller=order", currentPageUrl);
    }

    @And("^User proceeds to checkout$")
    public void proceedToCheckout() {
        OrderSummaryPageModel orderSummaryPage = (OrderSummaryPageModel) PageSelection.getPage("orderSummaryPage");
        orderSummaryPage.clickOnCheckoutButton();
        AddressPageModel addressSummaryPage = (AddressPageModel) PageSelection.getPage("addressSummaryPage");
        addressSummaryPage.clickCheckoutOnAddressPage();
    }

    @And("^User agrees to terms of service and clicks on proceed to checkout page button$")
    public void clicksOnProceedToCheckoutButton() {
        ShippingDetailPageModel shippingPage = (ShippingDetailPageModel) PageSelection.getPage("shippingPage");
        shippingPage.clickOnTermsOfServiceCheckbox();
        shippingPage.clickCheckout();
    }

    @And("^User choose to pay by \"([^\"]*)\" option$")
    public void chooseThePaymentOption(String paymentOption) {
        ShippingDetailPageModel shippingPage = (ShippingDetailPageModel) PageSelection.getPage("shippingPage");
        shippingPage.clickOnPaymentType("bankwire");
    }

    @Then("^User clicks on the confirm my order button$")
    public void clickConfirmMyOrderButton() {
        PaymentsPageModel paymentsPage = (PaymentsPageModel) PageSelection.getPage("paymentsPage");
        paymentsPage.clickOnOrderConfirmationButton();
    }

    @And("^Order confirmation page displays order details with message \"([^\"]*)\"$")
    public void messageOnOrderConfPage(String message) {
        PaymentsPageModel paymentsPage = (PaymentsPageModel) PageSelection.getPage("paymentsPage");
        String pageHeadingText = paymentsPage.getPageHeadingText();
        Assert.assertEquals("Heading should be Order confirmation", "ORDER CONFIRMATION", pageHeadingText);
        String orderConfirmationMsg = paymentsPage.getOrderConfMsg();
        Assert.assertEquals("Should have correct order confirmation message", message, orderConfirmationMsg);
    }
}
