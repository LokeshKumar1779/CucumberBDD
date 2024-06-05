Feature: Add product to cart

  @Smoke
  Scenario Outline: Add product to cart from store
    Given User is at store page
    When User adds a "<product>" to cart
    Then User should see 1 "<product>" in the cart
    Examples:
      | product         |
      | Blue Shoes      |
      | Anchor Bracelet |

#  Scenario Outline: Add product to cart from store - multiple products
#    Given User is at store page
#    When User adds a "<product_name>" to cart
#    Then User should see 1 "<product_name>" in the cart
#    Examples:
#      | product_name      |
#      | Blue Denim Shorts |
#      | Blue Tshirt       |
