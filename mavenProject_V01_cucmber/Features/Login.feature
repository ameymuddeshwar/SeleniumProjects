Feature: Login

@normalLogin
  Scenario: Successful login with valid credentials
    Given User launches Safari browser
    When User opens an URL "https://admin-demo.nopcommerce.com/"
    And User enters an email as "admin@yourstore.com" and password as "admin"
    And Clicks on LogIn
    Then Page title should be "Dashboard / nopCommerce administration"
    When User clicks on logout link
    Then Page title should be "Your store. Login"
    And close browser
 
@sanity
  Scenario: Successful login with valid credentials (TDD)
    Given User launches Safari browser
    When User opens an URL "https://admin-demo.nopcommerce.com/"
    And User enters an email as "<emailid>" and password as "<password>"
    And Clicks on LogIn
    Then Page title should be "Dashboard / nopCommerce administration"
    When User clicks on logout link
    Then Page title should be "Your store. Login"
    And close browser
    
    Examples:
    	| emailid	|	password	|
    	|	admin@yourstore.com	|	admin	|
    	|	admin1@yourstore.com	|	admin123	|