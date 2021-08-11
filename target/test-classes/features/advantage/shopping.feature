@advantageRegression

Feature: Customer journey scenarios

  @completeSale
  Scenario: Register a new user then complete sale
    Given I open advantage shopping site
    And I verify home page
    Then I navigate to create account page
    And I register new user
    Then I add "headPhones" to cart
    And I complete purchase



