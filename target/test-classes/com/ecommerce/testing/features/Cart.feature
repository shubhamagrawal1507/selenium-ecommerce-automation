@Cart
Feature: Cart Management

  Scenario: Place order for the items in cart

    Given the user is logged in
    Then the user adds a product "Sauce Labs Bolt T-Shirt" to the cart
    Then the user places order for the product
    Then Order should be placed successfully
