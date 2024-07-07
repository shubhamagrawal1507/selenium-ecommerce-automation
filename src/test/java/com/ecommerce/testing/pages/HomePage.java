package com.ecommerce.testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    By homePage = By.xpath("//div[text()='Swag Labs']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isUserLoggedIn() {
        return driver.findElement(homePage).isDisplayed();
    }
}

