package com.crm.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.utils.TestUtil;

public class LoginPage extends TestBase {
	
	@FindBy(xpath="//span[normalize-space()='Log In']")
	WebElement loginbutton;
	
	@FindBy(xpath="//input[@placeholder='Username']")
	WebElement enterEmail;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement enterPassword;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement submitbutton;
	
	
	//Initializing the Page Object
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public String validateloginpageTitle() {
		return driver.getTitle();
		
	}
	
	
	public HomePage Login(String un,String pass) {
	//	loginbutton.click();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.IMPICIT_WAIT, TimeUnit.SECONDS);
		enterEmail.sendKeys(un);
		enterPassword.sendKeys(pass);
		submitbutton.click();
		return new HomePage();
		
	}
	
	
}
