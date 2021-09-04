Feature: Add Customers

	Background: Below are the common steps
		Given User launches Safari browser
    When User opens an URL "https://admin-demo.nopcommerce.com/"
    And User enters an email as "admin@yourstore.com" and password as "admin"
    And Clicks on LogIn
    Then User can view the Dashboard

  Scenario: Add new customers
    When User clicks on Customers menu
    And Clicks on Customers menu item
    And Clicks on Add new button
    Then User can view Add new customer page
    When User enters Customer info
    And Clicks on save button
    Then User can view confirmation message "The new customer has been added successfully."
    And close browser
    
  Scenario: Search customer by email
  	When User clicks on Customers menu
    And Clicks on Customers menu item
    And Enter customer email
    When Click on search button
    Then EmailId is a match
    And close browser
    
  Scenario: Search customer by Name
  	When User clicks on Customers menu
    And Clicks on Customers menu item
    And Enter customer firstName
    And Enter customer lastName
    When Click on search button
    Then User should find name in the search results
    And close browser