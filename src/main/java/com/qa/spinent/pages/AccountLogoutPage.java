package com.qa.spinent.pages;

import org.openqa.selenium.WebDriver;

import com.qa.spinent.base.BasePage;
import com.qa.spinent.util.ElementUtil;

public class AccountLogoutPage  extends BasePage{
	WebDriver driver;
	ElementUtil elementUtil;
	LocatorsPage lctr;

	// Constructor
	public AccountLogoutPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
		lctr = new LocatorsPage();
	
	//1. METHOD --> LogoutFunction
	}public boolean logOutFunctionMethod() {
		elementUtil.waitForElementToBeClickable(lctr.logOutButton);
		return elementUtil.doIsEnabled(lctr.logOutButton);
	
	//2.METHOD LOGOUT TEST METHOD WITH URL
	}public String logOutVerificationWithUrl() {
		
		return driver.getCurrentUrl();
	}
}
