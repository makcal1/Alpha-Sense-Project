//package com.qa.spinent.testpages;
//import java.util.Properties;
//
//import org.openqa.selenium.WebDriver;
//import org.testng.Assert;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//
//import com.qa.spinent.base.BasePage;
//import com.qa.spinent.pages.HomePage;
//import com.qa.spinent.pages.LoginPage;
//import com.qa.spinent.util.AppConstants;
//import com.qa.spinent.util.Credentials;
//
//
//
//
//
//
//public class HomePageTest {
//	WebDriver driver;
//	BasePage basePage;
//	Properties prop;
//	LoginPage loginPage;
//	HomePage homePage;
//	Credentials userCred;
//	
//
//	@BeforeTest
//	public void setUp() throws InterruptedException{
//	basePage = new BasePage();
//	prop = basePage.init_properties();
//	String browserName = prop.getProperty("browser");
//	driver = basePage.init_driver(browserName);
//	driver.get(prop.getProperty("url"));
//	loginPage=new LoginPage(driver);
//	userCred = new Credentials(prop.getProperty("username"), prop.getProperty("password"));
//	homePage = loginPage.doLogin(userCred);
//	Thread.sleep(5000);
//		
//	}	
//	@Test(priority=1,description = "Home Page Title will be tested")
//	public void verifyHomePageTitle() {
//		String title = homePage.getHomePageTitle();
//		System.out.println("home page title is: "+ title);
//		Assert.assertEquals(title, AppConstants.HOME_PAGE_TITLE);
//	
//	}@Test(priority =2,description = "The button function will be tested to see if it is clickable or not!" )
//	public void introToSportsTechButtonTest() {
//		
//	Assert.assertTrue(homePage.enableCheckIntroToSportsTechButton());	
//	}
//	@Test(priority =3,description = "The button function will be tested to see if it is clickable or not!" )
//	public void knowYourselfButtonTest() {
//		
//	Assert.assertTrue(homePage.enableCheckknowYourselfButton());	
//	}
//	@Test(priority =4,description = "The button function will be tested to see if it is clickable or not!" )
//	public void determineProblemsButtonTest() {
//		
//	Assert.assertTrue(homePage.enableCheckdetermineProblemsButton());	
//	}
//	@Test(priority =5,description = "The button function will be tested to see if it is clickable or not!" )
//	public void askToCustomerButtonTest() {
//		
//	Assert.assertTrue(homePage.enableCheckaskToCustomerButton());	
//	}
//	@Test(priority =6,description = "The button function will be tested to see if it is clickable or not!" )
//	public void generateIdeasButtonTest() {
//		
//	Assert.assertTrue(homePage.enableCheckgenerateIdeasButton());	
//	}
//	@Test(priority =7,description = "The button function will be tested to see if it is clickable or not!" )
//	public void preapareMVPButtonTest() {
//		
//	Assert.assertTrue(homePage.enableCheckpreapareMVPButton());	
//	}
//	@Test(priority =8,description = "The button function will be tested to see if it is clickable or not!" )
//	public void givePresentationButtonTest() {
//		
//	Assert.assertTrue(homePage.enableCheckgivePresentationButton());	
//	}
//	@Test(priority =9,description = "The button function will be tested to see if it is clickable or not!" )
//	public void belowButtonAblemsTest() {
//		
//	Assert.assertTrue(homePage.enableCheckbelowButtonAblems());	
//	}
//	@Test(priority =10,description = "The button function will be tested to see if it is clickable or not!" )
//	public void languageButtonTest() {
//		
//	Assert.assertTrue(homePage.enableChecklanguageButton());	
//	}
//	@Test(priority = 11,description = "The button function will be tested to see if it is clickable or not!")
//	public void userAccountNamesButtonTest() {
//		
//	Assert.assertTrue(homePage.enableCheckuserAccountNamesButton());	
//	}
//	@Test(priority =12,description = "The button function will be tested to see if it is clickable or not!" )
//	public void printCertificateButtonTest() {
//		
//	Assert.assertTrue(homePage.enableCheckprintCertificateButton());	
//	}
//		
//		
//		
//		
//		
//		
//	@AfterTest
//	public void tearDown() {
//		driver.quit();
//	}	
//	
//	
//}
