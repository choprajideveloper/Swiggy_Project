Feature: Select Item From WebSite and Add it to Cart

  Scenario Outline: Enter Location Where you are
    Given Browser is open
    Given Swiggy WebSite is Open
    When User Enters <Location> click Search
    And User is navigated to Search page

    Examples: 
      | Location                    |
      | Noida, Uttar Pradesh, India |
      | Noida, Uttar Pradesh, India |
 

  Scenario Outline: User enters item to order
    When User search <Item> to order
    And clicks on Add Item and item is added to cart

    Examples: 
      | Item     |
      | pizza    |
      | pizza    |
     

  Scenario Outline: Check item is added in cart or not
    Given User is on Cart Page
    Then check item added is available in cart or not
