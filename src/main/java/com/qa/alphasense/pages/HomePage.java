package com.qa.alphasense.pages;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.qa.alphasense.base.BasePage;
import com.qa.alphasense.util.ElementUtil;







public class HomePage extends BasePage{

/**
 * @author <Muhammed Akcal> - 07/02/2022
 */



	WebDriver driver;
	ElementUtil elementUtil;
	LocatorsPage locator;
	Actions action;
	


	//Constructory
	public HomePage(WebDriver driver)

	{
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
		locator = new LocatorsPage();
		action = new Actions(driver);

	}

	public void searchAdditionalKeyword(String keyword) throws Exception

	{

		try 

		{

			By searchKeyword = locator.searchKeywordLocation;

			elementUtil.waitForElementVisible(searchKeyword);
			elementUtil.click(searchKeyword);

			action.sendKeys(driver.findElement(searchKeyword), keyword).build().perform();
			action.sendKeys(driver.findElement(searchKeyword), Keys.ENTER).build().perform();

		} 

		catch (Exception e) 

		{

			e.printStackTrace();
		}

	}

	public void scrollTheLastFoundResult() 

	{

		By lastFoundResult = locator.lastelementAfterSearcingKeywordLocation;

		try 
	
		{

			elementUtil.waitForElementVisible(lastFoundResult);
			action.sendKeys(driver.findElement(lastFoundResult), Keys.CONTROL).pause(Duration.ofSeconds(1)).build().perform();
			action.sendKeys(driver.findElement(lastFoundResult), Keys.END).pause(Duration.ofSeconds(1)).build().perform();
			action.sendKeys(driver.findElement(lastFoundResult), Keys.CONTROL).pause(Duration.ofSeconds(1)).build().perform();
			action.sendKeys(driver.findElement(lastFoundResult), Keys.END).pause(Duration.ofSeconds(1)).build().perform();

		} 
		
		catch (Exception e) 
		
		{
			e.printStackTrace();

		}
	}

	public void clickTheLastFoundResult() 

	{

		By lastFoundResult = locator.lastelementAfterSearcingKeywordLocation;
		int attempts = 0;
		while(attempts < 2) 
		
		{
			
			try 
			{
				action.click(driver.findElement(lastFoundResult)).pause(Duration.ofSeconds(1)).build().perform();
				break;

			} 
			
			catch(Exception e) 
			{
				e.printStackTrace();
			}
			
			attempts++;
		}
	}

	public void switchFrameTo(String frameName) 
	{

		try 
		{
			driver.switchTo().frame(frameName);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}

	}
	
	public String getTextFromChosenStatement() 
	{

		By textLocation = locator.chosenStatement;
		WebElement textElement =driver.findElement(textLocation);
		String text = textElement.getText();

		try 
		{
			elementUtil.waitForElementPresent(textLocation);
			System.out.println("Chosen Statement : "+ textElement.getText());
		} catch (Exception e) 
		{
			e.printStackTrace();
		}

		finally 
		{
			return 	text;
		}


	}

  



}



