package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="/html/body/table[1]/tbody/tr[1]/td/table/tbody/tr/td[1]")
	WebElement userNameLabel;
	
	@FindBy(xpath="//td[@class='logo_text']")
	WebElement validatelogo;
	
	@FindBy(xpath="//a[normalize-space()='Contacts']")
	WebElement contactlink;
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void validatepagetitle() {
		driver.getTitle();
	}
	
	public boolean verifyPagelabel() {
		return userNameLabel.isDisplayed();
	}
	
	public ContactPage clickonContactlink() {
		contactlink.click();
		return new ContactPage();
		
	}

}
