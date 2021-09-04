package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver1;
	
	public LoginPage(WebDriver driver2) {
		driver1 = driver2;
		PageFactory.initElements(driver2, this);
	}
	
	@FindBy(id = "Email")
	@CacheLookup
	WebElement email;
	
	@FindBy(id = "Password")
	@CacheLookup
	WebElement password;
	
	@FindBy(xpath = "//button[contains(text(),'Log in')]")
	@CacheLookup
	WebElement login;
	
	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	@CacheLookup
	WebElement logout;
	
	public void setEmail(String uname) {
		//email.clear();
		email.sendKeys(uname);
	}
	
	public void setPassword(String pass) {
		//password.clear();
		password.sendKeys(pass);
	}
	
	public void clickLogin() {
		login.click();
	}
	
	public void clickLogout() {
		logout.click();
	}
	
}
