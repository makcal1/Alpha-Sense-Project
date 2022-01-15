package com.qa.spinent.testpages;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.spinent.base.BasePage;
import com.qa.spinent.pages.LoginPage;
import com.qa.spinent.util.AppConstants;
import com.qa.spinent.util.Credentials;


//@Epic("Epic - 101 : create login features")
//@Feature("US - 501 : create test for login on Spinent Modules")
public class LoginPageTest {
	
WebDriver driver;
BasePage basePage;
Properties prop;
LoginPage loginPage;
Credentials userCred;
public static String USERNAME="muhammedakcal_x0ifUn";
public static String ACCESSKEY="UDdA7F2vez7ACjfBDNhW";

@BeforeTest(alwaysRun = true)

public void setUp() {
	basePage = new BasePage();
	prop = basePage.init_properties();
	String browserName = prop.getProperty("browser");
	driver = basePage.init_driver(browserName);
	
	
	
	
	
	driver.get(prop.getProperty("url"));
	loginPage = new LoginPage(driver);
	userCred = new Credentials(prop.getProperty("username"), prop.getProperty("password"));
	
}@Test(priority = 1,description = "LOGIN PAGE TITLE PRESENCE FUNCTIONALITY",enabled = true)


public void verifyLoginPageTitleTest() {
	String title = loginPage.getPageTitle();
	System.out.println("login page title is: "+ title);
	Assert.assertEquals(title, AppConstants.LOGIN_PAGE_TITLE);

}@Test(priority = 2,description = "LOGIN PAGE URL FUNCTIONALITY TEST",enabled = true)
//@Description("Verify Login Page Url")
//@Severity(SeverityLevel.NORMAL)
public void verifyLoginPageUrlTest() {
	
	String url = loginPage.getPageUrl();
	System.out.println("login page url is: "+ url);
	Assert.assertEquals(url, AppConstants.LOGIN_PAGE_URL);

}

@Test(priority = 3, description = "VERIFICATION OF RED LOGIN-BUTTON IN THE LOGIN PAGE ", enabled = true)
//@Description("Verify Login Button")
//@Severity(SeverityLevel.CRITICAL)
public void verifyRedColorLoginButtonTest() {
	Assert.assertTrue(loginPage.checkRedLoginPageButton());
	System.out.println("Passsed");
}

@Test(priority = 4, description = "VERIFICATION OF GREEN LOGIN-BUTTON IN THE LOGIN PAGE ", enabled = true)

public void verifyGreenolorLoginButtonTest() {
	Assert.assertTrue(loginPage.checkGreenLoginPageButton());
}

@AfterTest(alwaysRun = true)
public void tearDown() {
	driver.quit();
}

















}
