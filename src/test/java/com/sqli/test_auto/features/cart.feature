@Ready
Feature: adding products to cart

  Background:
    Given from the landing page

  @ready
  Scenario Outline: check if a cafe product can be added to the cart
    Given navigate To <type> cafe catalogue
    When shopping the <capsule> cafe  with quantity of <capsule quantity>
    And navigate To <type> machine catalogue
    And shopping the <machine> cafe capsule with <machine quantity>
    Then the <capsule> with the quantity <capsule quantity> should exist in cart
    And the <machine> with the quantity <machine quantity> should exist in cart
    Examples:
      | capsule | capsule quantity | machine       | machine quantity | type     |
      | Cosi    | 17               | Creatista Pro | 7                | original |


