package com.qa.spinent.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.spinent.base.BasePage;
import com.qa.spinent.util.AppConstants;
import com.qa.spinent.util.Credentials;
import com.qa.spinent.util.ElementUtil;



public class LoginPage extends BasePage{
	
WebDriver driver;
ElementUtil elementUtil;
LocatorsPage lctr;

//Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
		lctr = new LocatorsPage();
	}
/**
 * 1.METHOD --> TITLE
 * @return
 */
	
public String getPageTitle() {
elementUtil.waitForTitlePresent(AppConstants.LOGIN_PAGE_TITLE);
return elementUtil.doGetPageTitle();
/**
 * 2.METHOD --> URL 
 * @return
 */
}public String getPageUrl() {
elementUtil.waitForTitlePresent(AppConstants.LOGIN_PAGE_TITLE);	
return driver.getCurrentUrl();
/**
 * 3.METHOD --> RED COLOR LOGIN BUTTON FUNCTIONALITY
 * @return
 */
}public boolean checkRedLoginPageButton() {
elementUtil.waitForElementPresent(lctr.redlLoginBtn);
return elementUtil.doIsDisplayed(lctr.redlLoginBtn);
/**
 * 4.METHOD --> GREEN COLOR LOGIN BUTTON FUNCTIONALITY
 * @return
 */
}public boolean checkGreenLoginPageButton() {
	elementUtil.waitForElementPresent(lctr.greenLoginBtn);
	return elementUtil.doIsDisplayed(lctr.greenLoginBtn);
	
/**
 * 
 * 5.METHOD -->LOGIN METHOD
 */
	
}public HomePage doLogin(Credentials userCred) {
	
elementUtil.doSendKeys(lctr.email, userCred.getAppUsername());
elementUtil.doSendKeys(lctr.password, userCred.getAppPassword());

elementUtil.doClick(lctr.greenLoginBtn);
	
return new HomePage(driver);

}
public void createNewContact(String mailData, String passwordData) throws InterruptedException {
	
	elementUtil.waitForElementPresent(lctr.email);

	elementUtil.doSendKeys(lctr.email, mailData);
	Thread.sleep(5000);
	elementUtil.doSendKeys(lctr.password, passwordData);
	
    elementUtil.doClick(lctr.greenLoginBtn);
    
    
	System.out.println(elementUtil.doGetText(lctr.email));
	
	
}public boolean gettingErrorMessage() {

	return elementUtil.doIsDisplayed(lctr.errorMessage);
	
}public String errorText() {
	return elementUtil.doGetText(lctr.errorMessage);
}


}
