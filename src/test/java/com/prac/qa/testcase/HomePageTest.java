package com.prac.qa.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utils.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	ContactPage contactpage;
	TestUtil testutil;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		testutil = new TestUtil();
		loginPage = new LoginPage();
		contactpage = new ContactPage();
		homePage = loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		contactpage = new ContactPage();

	}

	@Test(priority = 1, description = "Validate the Page Title")
	public void validate_page_title() {
		homePage.validatepagetitle();
	}

	@Test(priority = 2, description = "Verify UserName")
	public void verifyusername() {
		Assert.assertTrue(homePage.verifyPagelabel());
	}

	@Test(priority = 3, description = "Click on Contact Page")
	public void clickoncontactpage() {
		contactpage = homePage.clickonContactlink();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
