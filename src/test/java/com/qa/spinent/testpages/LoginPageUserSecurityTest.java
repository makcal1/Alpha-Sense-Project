package com.qa.spinent.testpages;

import java.util.Properties;



import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.spinent.base.BasePage;
import com.qa.spinent.pages.LoginPage;
import com.qa.spinent.util.AppConstants;
import com.qa.spinent.util.Credentials;
import com.qa.spinent.util.ExcelUtil;



public class LoginPageUserSecurityTest {
	
WebDriver driver;
BasePage basePage;
Properties prop;
LoginPage loginPage;
Credentials userCred;
//Logger log = Logger.getLogger(LoginPageTest.class);

@BeforeTest()
public void setUp() {
	basePage = new BasePage();
	prop = basePage.init_properties();
	String browserName = prop.getProperty("browser");
	driver = basePage.init_driver(browserName);
	driver.get(prop.getProperty("url"));
	loginPage = new LoginPage(driver);
	userCred = new Credentials(prop.getProperty("username"), prop.getProperty("password"));
	
}
@DataProvider
public Object[][] getLoginInvalidData(){

	Object [][] data = ExcelUtil.getTestData(AppConstants.EXCEL_USER_SHEET_NAME);
	return data;

	
	
	
	
}@Test(dataProvider = "getLoginInvalidData",description = "Testing invalid datas by sending wrong user information. "
		+ "Error message will be verified after sending wrong user information from the excel file.")	
//@Description("create new contacts")
//@Severity(SeverityLevel.BLOCKER)	
public void userSecurity(String mailData, String passwordData) throws InterruptedException {
	
loginPage.createNewContact(mailData, passwordData);

Assert.assertTrue(loginPage.gettingErrorMessage());


}
	
@AfterTest(alwaysRun = true)
public void tearDown() {
	driver.quit();
}




}
