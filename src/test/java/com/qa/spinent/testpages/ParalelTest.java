//package com.qa.spinent.testpages;
//
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.util.Properties;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;
//import org.testng.Assert;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//
//import com.qa.spinent.base.BasePage;
//import com.qa.spinent.pages.LoginPage;
//import com.qa.spinent.util.AppConstants;
//import com.qa.spinent.util.Credentials;
//import com.qa.spinent.util.ExcelUtil;
//
//public class ParalelTest {
//
//	public static final String AUTOMATE_USERNAME = "muhammedakcal_x0ifUn";
//	  public static final String AUTOMATE_ACCESS_KEY = "UDdA7F2vez7ACjfBDNhW";
//	  public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";
//	  WebDriver driver;
//	  BasePage basePage;
//	  Properties prop;
//	  LoginPage loginPage;
//	  Credentials userCred;
//	  
//	  @BeforeTest(alwaysRun = true)
//
//	  public void setUp() throws MalformedURLException {
//	  	basePage = new BasePage();
//	  	prop = basePage.init_properties();
//	  
//	  
//	  
//	  
//	    DesiredCapabilities caps = new DesiredCapabilities();
//	    caps.setCapability("os", "OS X");
//	    caps.setCapability("os_version", "Big Sur");
//	    caps.setCapability("browser", "Safari");
//	    caps.setCapability("browser_version", "14.0");
//	    caps.setCapability("project", "Spinent Guvenlik Testi");
//	    caps.setCapability("name", "User Security Test");
//	    caps.setCapability("browserstack.local", "false");
//	    caps.setCapability("browserstack.selenium_version", "3.14.0");// CI/CD job or build name
//	     driver = new RemoteWebDriver(new URL(URL), caps);
//	    driver.get("https://portal.spinent.eu/");
//	    loginPage = new LoginPage(driver);
//		userCred = new Credentials(prop.getProperty("username"), prop.getProperty("password"));
//		
//	  }
//	  @DataProvider
//	  public Object[][] getLoginInvalidData(){
//
//	  	Object [][] data = ExcelUtil.getTestData(AppConstants.EXCEL_USER_SHEET_NAME);
//	  	return data;
//
//	  	
//	  	
//	  	
//	  	
//	  }@Test(dataProvider = "getLoginInvalidData",description = "Testing invalid datas by sending wrong user information. "
//	  		+ "Error message will be verified after sending wrong user information from the excel file.")	
//	  //@Description("create new contacts")
//	  //@Severity(SeverityLevel.BLOCKER)	
//	  public void userSecurity(String mailData, String passwordData) throws InterruptedException {
//	  	
//	  loginPage.createNewContact(mailData, passwordData);
//
//	  Assert.assertTrue(loginPage.gettingErrorMessage());
//
//
//	  }
//	  	
//	  @AfterTest(alwaysRun = true)
//	  public void tearDown() {
//	  	driver.quit();
//	  }
//
//
//
//
//	  }
//
