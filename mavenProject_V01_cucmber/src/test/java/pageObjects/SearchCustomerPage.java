package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SearchCustomerPage {
public WebDriver driver1;
	
	public SearchCustomerPage(WebDriver driver2) {
		this.driver1 = driver2;
		PageFactory.initElements(driver1, this);
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='SearchEmail']")
	@CacheLookup
	WebElement searchEmail;
	
	@FindBy(how = How.ID, using = "search-customers")
	@CacheLookup
	WebElement searchButton;
	
	@FindBy(how = How.ID, using = "customers-grid")
	@CacheLookup
	WebElement table;
	
	@FindBy(how = How.XPATH, using = "//table[@id='customers-grid']//tbody/tr")
	@CacheLookup
	List<WebElement> tableRows;
	
	@FindBy(how = How.XPATH, using = "//table[@id='customers-grid']//tbody/tr/td")
	@CacheLookup
	List<WebElement> tableColumns;
	
	@FindBy(how = How.ID, using = "SearchFirstName")
	@CacheLookup
	WebElement firstName;
	
	@FindBy(how = How.ID, using = "SearchLastName")
	@CacheLookup
	WebElement lastName;
	
	public void searchByEmail(String email) {
		searchEmail.clear();
		searchEmail.sendKeys(email);
	}
	
	public void clickSearchButton()	{
		searchButton.click();
	}
	
	public int getNoOfRows() {
		return tableRows.size();
	}
	
	public int getNoOfColumns() {
		return tableColumns.size();
	}
	
	public void setFirstName(String name) {
		firstName.clear();
		firstName.sendKeys(name);
	}
	
	public void setLastName(String name) {
		lastName.clear();
		lastName.sendKeys(name);
	}
	
	public boolean searchCustomerByEmail(String email) {
		boolean flag = false;
		
		for(int i=1; i<=getNoOfRows(); i++) {
			String emailId = table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[2]")).getText();
			System.out.println(emailId);
			
			if(emailId.equalsIgnoreCase(email)) {
				flag = true;
			}
		}
		return flag;
	}
	
	public boolean searchCustomerByName(String name) {
		boolean flag = false;
		
		for(int i=1; i<=getNoOfRows(); i++) {
			String fullName = table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[3]")).getText();
			System.out.println(fullName);
			String splitNames[] = fullName.split(" ");
			
			if(splitNames[0].equalsIgnoreCase("Brenda") && splitNames[1].equalsIgnoreCase("Lindgren")) {
				flag = true;
			}
		}
		return flag;
	}
}
