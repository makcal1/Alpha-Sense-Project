package com.qa.spinent.testpages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.spinent.base.BasePage;
import com.qa.spinent.pages.HomePage;
import com.qa.spinent.pages.LocatorsPage;
import com.qa.spinent.pages.LoginPage;
import com.qa.spinent.pages.MyReportPage;
import com.qa.spinent.util.AppConstants;
import com.qa.spinent.util.Credentials;
import com.qa.spinent.util.ElementUtil;

public class MyReportPageTest  {
	
	BasePage basePage;
	Properties prop;
	WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;
	MyReportPage myReportPage;
	Credentials userCred;

	@BeforeTest
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.init_properties();
		String browserName = prop.getProperty("browser");
		driver = basePage.init_driver(browserName);
		driver.get(prop.getProperty("url"));
		loginPage = new LoginPage(driver);
		userCred = new Credentials(prop.getProperty("username"), prop.getProperty("password"));
		homePage = loginPage.doLogin(userCred);
		myReportPage=homePage.goToMyReportPage();
	
	

}

@Test(priority=1)
public void verifyMyReportPageTableVisibility() {
	
Assert.assertTrue(myReportPage.tableVisibilityMethod());	
	
}
@Test(priority=2)
public void verifyMyReportPageTable() {
	
String url= myReportPage.myreportPageUrl();
System.out.println("The page url is : " + url);
Assert.assertEquals(url, AppConstants.MY_REPORT_PAGE_URL);

	
}
@AfterTest
public void tearDown() {
	driver.quit();
}




}
