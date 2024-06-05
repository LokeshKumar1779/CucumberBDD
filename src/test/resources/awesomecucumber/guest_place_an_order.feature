Feature: Place an order

  @GuestOrder
  Scenario: Order using default payment option
    Given As a guest customer
      | firstname | lastname | email               |
      | demo      | user     | testemail@gmail.com |
    And My billing details are
      | addressLine1      | city  | state | zipcode   |
      | 6300 Spring Creek | Plano | Texas | 75024 |
    And I have a product in the cart
    And I am on checkout page
    When I provide personal details
    And I provide billing details
    And I place an order
    Then order should be placed successfully