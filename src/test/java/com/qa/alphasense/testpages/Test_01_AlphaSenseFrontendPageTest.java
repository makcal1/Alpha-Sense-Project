package com.qa.alphasense.testpages;


import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.qa.alphasense.base.BasePage;
import com.qa.alphasense.pages.HomePage;
import com.qa.alphasense.util.AppConstants;

@Listeners

public class Test_01_AlphaSenseFrontendPageTest {
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	HomePage homePage;

 
	@BeforeTest(alwaysRun = true , description = "Opening mentioned page")
	public void openEnvironment() 
	{
		basePage = new BasePage();
		prop = basePage.init_properties();
		String browserName = prop.getProperty("browser");
		driver = basePage.init_driver(browserName);
		driver.get(prop.getProperty("url"));
		homePage = new HomePage(driver);
	}
	

	@Test(priority = 1, description = "Searching for Additional Keyword")
	public void searchingforAdditionalKeyword() throws Exception
	{

		homePage.searchAdditionalKeyword("AlphaSense");
	}

	@Test(priority = 2 , description = "Scrolling To The Last Found Result")
	public void scrollTheLastFoundResult() 
	{
		homePage.scrollTheLastFoundResult();
	}

	@Test(priority = 3 , description = "Clicking On It")
	public void clickTheLastFoundResult() 
	{
		homePage.clickTheLastFoundResult();	
	}

	@Test(priority = 4 , description = "Changing Frame In Order To Verify Highlighed Result")
	public void switchToFrame() 
	{
		homePage.switchFrameTo("content-1");
	}

	@Test(priority = 5 , description = "Verifying that chosen statement is highlighted in the document viewer")
	public void verifyChosenStatement() 
	{

		String actualResult = homePage.getTextFromChosenStatement();
		String expectedResult = AppConstants.CHOSEN_HIGHLIGHTED_RESULT;
		Assert.assertEquals(actualResult, expectedResult);
	}


	@AfterTest(alwaysRun = true)
	public void tearDown() 
	{
		driver.quit();
	}

















}
