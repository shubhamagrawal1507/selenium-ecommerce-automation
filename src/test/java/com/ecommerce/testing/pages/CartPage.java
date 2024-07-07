package com.ecommerce.testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    WebDriver driver;

    By checkout = By.id("checkout");
    By firstName = By.id("first-name");
    By lastName = By.id("last-name");
    By zip = By.id("postal-code");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isProductInCart(String productName) throws InterruptedException {
        driver.findElement(By.xpath("//a[@data-test='shopping-cart-link']")).click();
        Thread.sleep(2000);
        return driver.findElement(By.xpath("//div[contains(text(),'"+productName+"')]")).isDisplayed();
    }

    public void add_product_to_cart(String productName) throws InterruptedException {
        driver.findElement(By.xpath("//div[contains(text(),'"+productName+"')]/../../..//button[text()='Add to cart']")).click();
        Thread.sleep(2000);
    }

    public void checkout() throws InterruptedException{
        driver.findElement(checkout).click();
        Thread.sleep(2000);
        driver.findElement(firstName).sendKeys("Shubham");
        driver.findElement(lastName).sendKeys("Agrawal");
        driver.findElement(zip).sendKeys("111101");
        driver.findElement(By.id("continue")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("finish")).click();
        Thread.sleep(2000);
    }

    public boolean isOrderPlaced(){
        return driver.findElement(By.xpath("//h2[contains(text(),'Thank you for your order')]")).isDisplayed();
    }
}

