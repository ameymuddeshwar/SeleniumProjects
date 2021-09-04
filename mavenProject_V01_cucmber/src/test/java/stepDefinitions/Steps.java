package stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AddCustomersPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.safari.SafariDriver;

public class Steps extends BaseClass {
	
	@Before
	public void setup() throws IOException {
		logger = Logger.getLogger("mavenProject"); //Added logger
		PropertyConfigurator.configure("Log4j.properties"); //Added logger
		
		//Reading configs
		configProp = new Properties();
		FileInputStream configPropfile = new FileInputStream("Config.properties");
		configProp.load(configPropfile);
		
		String br = configProp.getProperty("browser");
		
		if(br.equals("safari")) {
			System.setProperty("webdriver.safari.driver", configProp.getProperty("safaripath"));
		    driver = new SafariDriver();
		}
	    
	    logger.info("*******Launching browser*******");
	}
	
	@Given("User launches Safari browser")
	public void user_launches_safari_browser() {
		driver.manage().window().maximize();
		lp = new LoginPage(driver);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@When("User opens an URL {string}")
	public void user_opens_an_url(String url) {
	    driver.get(url);
	}

	@When("User enters an email as {string} and password as {string}")
	public void user_enters_an_email_as_and_password_as(String email, String password) {
	    lp.setEmail(email);
	    lp.setPassword(password);
	}

	@When("Clicks on LogIn")
	public void clicks_on_log_in() throws InterruptedException {
	    lp.clickLogin();
	    Thread.sleep(6000);
	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String title) {
	    if(driver.getPageSource().contains("Login was unsuccessful")) {
	    	driver.close();
	    	Assert.assertTrue(false);
	    }
	    else {
	    	Assert.assertEquals(title, driver.getTitle());
	    }
	}

	@When("User clicks on logout link")
	public void user_clicks_on_logout_link() throws InterruptedException {
		lp.clickLogout();
		Thread.sleep(3000);
	}

	@Then("close browser")
	public void close_browser() {
	    driver.close();
	}
	
	//Add customer steps

	@Then("User can view the Dashboard")
	public void user_can_view_the_dashboard() throws InterruptedException {
		addCust = new AddCustomersPage(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration", addCust.getPageTitle());
		Thread.sleep(3000);
	}
	@When("User clicks on Customers menu")
	public void user_clicks_on_customers_menu() throws InterruptedException {
	    addCust.clickOnCustomersMenu();
	    Thread.sleep(2000);
	}
	@When("Clicks on Customers menu item")
	public void clicks_on_customers_menu_item() throws InterruptedException {
	    addCust.clickOnCustomersMenuItem();
	    Thread.sleep(2000);
	}
	@When("Clicks on Add new button")
	public void clicks_on_add_new_button() throws InterruptedException {
	    addCust.clickOnAddNewButton();
	    Thread.sleep(2000);
	}
	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page() throws InterruptedException {
	    Assert.assertEquals("Add a new customer / nopCommerce administration", addCust.getPageTitle());
	    Thread.sleep(2000);
	}
	@When("User enters Customer info")
	public void user_enters_customer_info() {
	    String email = randomString() + "@gmail.com";
	    addCust.setEmail(email);
	    addCust.setPassword("test@123");
	    addCust.setFirstName();
	    addCust.setLastName();
	    addCust.selectGender();
	    addCust.setDOB("11/02/1993");
	    //addCust.selectCustomerRoles();
	    //addCust.selectVendorManager();
	}
	@When("Clicks on save button")
	public void clicks_on_save_button() throws InterruptedException {
	    addCust.clickOnSave();
	    Thread.sleep(2000);
	}
	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String message) {
	    Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains(message));
	}
	
	//Search customer
	
	@When("Enter customer email")
	public void enter_customer_email() {
	    scp = new SearchCustomerPage(driver);
	    scp.searchByEmail("brenda_lindgren@nopCommerce.com");
	}

	@When("Click on search button")
	public void click_on_search_button() {
	    scp.clickSearchButton();
	}

	@Then("EmailId is a match")
	public void email_id_is_a_match() {
	    boolean status = scp.searchCustomerByEmail("brenda_lindgren@nopCommerce.com");
	    Assert.assertEquals(true, status);
	}
	
	//Search by customer name
	
	@When("Enter customer firstName")
	public void enter_customer_first_name() {
		scp = new SearchCustomerPage(driver);
		scp.setFirstName("Brenda");
	}

	@When("Enter customer lastName")
	public void enter_customer_last_name() {
	    scp.setLastName("Lindgren");
	}

	@Then("User should find name in the search results")
	public void user_should_find_name_in_the_search_results() {
	    boolean status = scp.searchCustomerByName("Brenda Lindgren");
	    Assert.assertEquals(true, status);
	}
}
