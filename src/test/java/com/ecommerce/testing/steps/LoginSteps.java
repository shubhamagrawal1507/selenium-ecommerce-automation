package com.ecommerce.testing.steps;

import com.ecommerce.testing.pages.LoginPage;
import com.ecommerce.testing.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import static org.junit.Assert.assertTrue;

public class LoginSteps {
    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        String driverPath = "src/test/resources/drivers/msedgedriver";
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            driverPath += ".exe";
        }
        System.setProperty("webdriver.edge.driver", driverPath);
        driver = new EdgeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
    }


    @When("the user provides valid {string} and {string}")
    public void the_user_provides_valid_and(String username, String password) {
        loginPage = new LoginPage(driver);
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
}

    @Then("the user should be redirected to the home page")
    public void theUserShouldBeRedirectedToTheHomePage() {
        homePage = new HomePage(driver);
        assertTrue(homePage.isUserLoggedIn());
        driver.quit();
    }

}
