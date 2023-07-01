@Sales
Feature: Sales
  As a user I want select and buy item on website sauce demo

  Scenario: User sort product cart
    Given User already on login page
    When User input "standard_user" as userName and input "secret_sauce" as password
    Then User already on sales page
    When User sort product list by "Name (Z to A)"
    And User select item product "Test.allTheThings() T-Shirt (Red)" and "Sauce Labs Onesie"
    And User open cart button
    And User delete product "Test.allTheThings() T-Shirt (Red)"
    And User click checkout button
    And User enters details firstname "Aditya" lastname "Dwi" and postalcode "1234"
    And User click button continue
    Then User verify that "25.9"
    And User clicks finish button
    Then User able to see  confirmation message as "Thank you for your order!"

  Scenario Outline: User cannot input checkout with invalid data
    Given User on login page
    When User input "standard_user" as UserName and input "secret_sauce" as Password
    Then User already on product page
    And User select item product "Test.allTheThings() T-Shirt (Red)"
    And User click cart button
    And User click checkout button
    Then User already on checkout information
    And User input "<firstName>" as firstName and input "<lastName>" as lastName and postalCode "<postalCode>"
    And User click continue to your overview page
    Then User see "<errorPopUp>" error popUp on your information page

    Examples:
      | firstName | lastName   | postalCode | errorPopUp                     |
      |           |            |            | Error: First Name is required  |
      |           | Dwi Irawan | 53235      | Error: First Name is required  |
      | Aditya    |            | 12212      | Error: Last Name is required   |
      | Aditya    | Dwi Irawan |            | Error: Postal Code is required |
#      | Aditya    | Dwi Irawan | 4234234    |                                |