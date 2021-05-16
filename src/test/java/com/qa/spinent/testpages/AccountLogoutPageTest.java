package com.qa.spinent.testpages;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.spinent.base.BasePage;
import com.qa.spinent.pages.AccountLogoutPage;
import com.qa.spinent.pages.HomePage;
import com.qa.spinent.pages.LoginPage;
import com.qa.spinent.util.AppConstants;
import com.qa.spinent.util.Credentials;


public class AccountLogoutPageTest {
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	LoginPage loginPage;
	HomePage homePage;
	AccountLogoutPage accountLogoutPage;
	Credentials userCred;


	@BeforeTest()
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.init_properties();
		String browserName = prop.getProperty("browser");
		driver = basePage.init_driver(browserName);
		driver.get(prop.getProperty("url"));
		loginPage = new LoginPage(driver);
		userCred = new Credentials(prop.getProperty("username"), prop.getProperty("password"));
		homePage = loginPage.doLogin(userCred);
		accountLogoutPage = new AccountLogoutPage(driver);


	}@Test(priority = 1)
	public void logOutFunctionTest() {
		Assert.assertTrue(accountLogoutPage.logOutFunctionMethod());	

	}@Test(priority = 2)
	public void logOutUrlVerificationTest() {
		String expectedUrl= accountLogoutPage.logOutVerificationWithUrl();
		Assert.assertEquals(expectedUrl, AppConstants.ACCOUNT_PAGE_URL);

	}
	@AfterTest()
	public void tearDown() {
		driver.quit();
	}

}
