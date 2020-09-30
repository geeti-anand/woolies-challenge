package com.woolies_challenge.pages;

import com.woolies_challenge.util.ConfigFile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.Properties;


public class HomePageModel extends BasePage {

    public HomePageModel(WebDriver driver) {

        super(driver);
    }

    public void signInWithValidCredentials(){

        Properties properties = ConfigFile.configProperties();
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement signIn = driver.findElement(By.className("login"));
        signIn.click();
        driver.findElement(By.id("email")).sendKeys(username);
        driver.findElement(By.id("passwd")).sendKeys(password);
        WebElement submitLogin = driver.findElement(By.id("SubmitLogin"));
        submitLogin.click();

    }


}

