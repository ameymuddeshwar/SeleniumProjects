package pageObjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomersPage {
	public WebDriver driver1;
	
	public AddCustomersPage(WebDriver driver2) {
		this.driver1 = driver2;
		PageFactory.initElements(driver1, this);
	}
	
	public String getPageTitle() {
		driver1.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		return driver1.getTitle();
	}
	
	public void clickOnCustomersMenu() throws InterruptedException {
		driver1.findElement(By.xpath("//a[@id='nopSideBarPusher']")).click();
		driver1.findElement(By.cssSelector("i[class='nav-icon far fa-user']")).click();
		driver1.findElement(By.xpath("//a[@href='/Admin/Customer/List']")).click();
	}
	
	public void clickOnCustomersMenuItem() {
		driver1.findElement(By.xpath("//body[1]/div[3]/aside[1]/div[1]/div[4]/div[1]/div[1]/nav[1]/ul[1]/li[4]/ul[1]/li[1]/a[1]/p[1]")).click();
	}
	
	public void clickOnAddNewButton() {
		driver1.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
	}
	
	public void setEmail(String email) {
		driver1.findElement(By.xpath("//input[@id='Email']")).sendKeys(email);
	}
	
	public void setPassword(String password) {
		driver1.findElement(By.xpath("//input[@id='Password']")).sendKeys(password);
	}
	
	public void setFirstName() {
		driver1.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Amey");
	}
	
	public void setLastName() {
		driver1.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Muddeshwar");
	}
	
	public void selectGender() {
		driver1.findElement(By.xpath("//input[@id='Gender_Male']")).click();
	}
	
	public void setDOB(String dob) {
		driver1.findElement(By.xpath("//input[@id='DateOfBirth']")).sendKeys(dob);
	}
	
//	public void selectCustomerRoles() {
//		driver1.findElement(By.xpath("//body/div[3]/div[1]/form[1]/section[1]/div[1]/div[1]/nop-cards[1]/nop-card[1]/div[1]/div[2]/div[10]/div[2]/div[1]/div[1]/div[1]/div[1]")).click();
//	}
	
//	public void selectVendorManager() {
//		driver1.findElement(By.xpath("//select[@id='VendorId']")).click();
//		System.out.println("Clicked");
//		List<WebElement> vendors = driver1.findElements(By.xpath("//select[@id='VendorId']"));
//		System.out.println(vendors);
//		Select s = new Select((WebElement) vendors);
//		s.selectByValue("Vendor 2");
//	}
	
	public void clickOnSave() {
		driver1.findElement(By.xpath("//button[@name='save']")).click();
	}
}
