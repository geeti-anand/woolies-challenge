package com.woolies_challenge.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductListingPageModel extends BasePage {

    public ProductListingPageModel(WebDriver driver) {
        super(driver);
    }

    public void clickOnCategory() {
        WebElement topBlockMenuDiv = driver.findElement(By.id("block_top_menu"));
        WebElement ulElement = topBlockMenuDiv.findElement(By.tagName("ul"));
        List<WebElement> elements = ulElement.findElements(By.tagName("li"));
        if(elements.size()>0){
            WebElement selectProduct = elements.get(0);
            selectProduct.findElement(By.tagName("a")).click();
        }

    }

    public void addToCart(int productCount) {
        WebElement productRow = driver.findElement(By.cssSelector(".product_list.grid.row"));
        List<WebElement> elements = productRow.findElements(By.tagName("li"));
        WebElement selectedElements = elements.get(productCount);
        addProduct(selectedElements);
    }

    public void clickContinueShoppingButton() {
        //add First item to cart
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement continueShoppingButton = driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/span/span"));
        waitForVisibilityAndClick(continueShoppingButton);
    }


    public void clickCheckout() throws InterruptedException {
        //click on continue to shopping

        Thread.sleep(1000);
        WebElement continueShoppingButton = driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/span/span"));
        waitForVisibilityAndClick(continueShoppingButton);
    }

    private void addProduct(WebElement productLiElement) {
        WebElement productContainerDiv = productLiElement.findElement(By.className("product-container"));
        WebElement rightBlockDiv = productContainerDiv.findElement(By.className("right-block"));
        WebElement buttonContainerDiv = rightBlockDiv.findElement(By.className("button-container"));
        WebElement addToCartButton = buttonContainerDiv.findElement(By.tagName("a"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", addToCartButton);
    }

    public int getProductCount() {
        WebElement cartQuantityElement = driver.findElement(By.className("ajax_cart_quantity"));
        String text = cartQuantityElement.getText();
        return Integer.parseInt(text);
    }

}
