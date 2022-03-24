Feature: Add products to compare list
  In order to compare products by parameters
  As a user of shop
  I want to add products to compare list

  Scenario Outline: Add products to compare list
    Given I open Citilink web site
    And I select '<subcategory>' subcategory in catalog '<category>' category
    When I add products with indexes '<product_indexes>' to Compare list on Citilink Products page
    Then added products should be displayed on Citilink Compare Products page

    Examples:
      | category                      | subcategory            | product_indexes |
      | Смартфоны и гаджеты           | Смартфоны              | 1,2,3           |
      | Ноутбуки и компьютеры         | Ноутбуки               | 1,2             |
      | Телевизоры, аудио-видео, фото | Ultra HD 8K телевизоры | 1,3             |
