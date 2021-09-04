package stepDefinitions;

import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import pageObjects.AddCustomersPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

public class BaseClass {

	public WebDriver driver;
	public LoginPage lp;
	public AddCustomersPage addCust;
	public SearchCustomerPage scp;
	public static Logger logger;
	public Properties configProp;
	
	public static String randomString()	{
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
		
	}
	
}
