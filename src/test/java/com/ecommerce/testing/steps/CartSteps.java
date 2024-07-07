package com.ecommerce.testing.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.ecommerce.testing.pages.CartPage;
import com.ecommerce.testing.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import static org.junit.Assert.assertTrue;

public class CartSteps {

WebDriver driver;
CartPage cartPage;
LoginPage loginPage;


@Given("the user is logged in")
    public void theUserIsLoggedIn() {
        String driverPath = "src/test/resources/drivers/msedgedriver";
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            driverPath += ".exe";
        }
        System.setProperty("webdriver.edge.driver", driverPath);
        driver = new EdgeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
    }
    
@Then("the user adds a product {string} to the cart")
public void the_user_adds_a_product_to_the_cart(String productName) throws InterruptedException {
    cartPage = new CartPage(driver);
    cartPage.add_product_to_cart(productName);
    assertTrue(cartPage.isProductInCart(productName));
}
@Then("the user places order for the product")
public void the_user_places_order_for_the_product() throws InterruptedException {
    cartPage = new CartPage(driver);
    cartPage.checkout();
}
@Then("Order should be placed successfully")
public void order_should_be_placed_successfully() {
    cartPage = new CartPage(driver);
    assertTrue(cartPage.isOrderPlaced());
    driver.quit();
}
}
