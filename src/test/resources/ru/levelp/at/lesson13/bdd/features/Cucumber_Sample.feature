Feature: Add products to compare list
  In order to compare products by parameters
  As a user of shop
  I want to add products to compare list

  Scenario: Add products to compare list
    Given I open Citilink web site
    And I select 'Смартфоны' subcategory in catalog 'Смартфоны и гаджеты' category
    When I add products with indexes '1,2,3' to Compare list on Citilink Products page
    Then added products should be displayed on Citilink Compare Products page
