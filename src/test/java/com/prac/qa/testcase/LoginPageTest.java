package com.prac.qa.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
	}
	
	
	@Test(priority=1, description="Validating Page Title")
	public void login_Page_title() {
		String title = loginPage.validateloginpageTitle();
		Assert.assertEquals(title, "Free CRM  - CRM software for customer relationship management, sales, and support.");
	}
	
	@Test(priority=2, description="Login with Username & Password")
	public void loginTest() {
		homePage = loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
