package com.woolies_challenge.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.Optional;


public class BrowserSelection {

    static WebDriver driver;

    public static WebDriver getBrowser() {

        String browser;
        browser = Optional.ofNullable(System.getProperty("browser")).orElse("");

        if ("firefox".equals(browser.toLowerCase())) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

        } else if ("chrome".equals(browser.toLowerCase())) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        } else {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
}

