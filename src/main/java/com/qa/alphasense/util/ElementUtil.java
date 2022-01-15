package com.qa.alphasense.util;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.qa.alphasense.base.BasePage;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;


public class ElementUtil extends BasePage
{

	/**
	 * @author <Muhammed Akcal> - 07/02/2022
	 */

	WebDriver driver;
	WebDriverWait wait;
	JavaScriptUtil jsUtil;
	Properties prop;
	Robot robot;

	public ElementUtil(WebDriver driver) 
	{
		this.driver  = driver;
		wait = new WebDriverWait(driver, AppConstants.DEFAULT_TIMEOUT);
		jsUtil = new JavaScriptUtil(driver);

	}

	public boolean waitForElementToBeClickable(By locator) 
	{
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		wait.withTimeout(Duration.ofSeconds(7));
		return true;
	}

	public boolean waitForTitlePresent(String title) 
	{
		wait.until(ExpectedConditions.titleIs(title));
		return true;
	}


	public boolean waitForElementPresent(By locator) 
	{
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return true;
	}

	public boolean waitForElementVisible(By locator) 
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return true;
	}

	public String doGetPageTitle() 
	{

		try 
		{
			return driver.getTitle();
		}
		catch (Exception e) 
		{
			System.out.println("some excaption got occured while getting the title...");
		}
		return null;
	}


	public WebElement getElement(By locator) 
	{
		WebElement element = null;
		try 
		{
			element = driver.findElement(locator);
			if(highlightElement) 
			{
				jsUtil.flash(element);
			}
		} catch (Exception e) 
		{
			System.out.println("some exception occured while creating the web element...");
		}
		return element;
	}


	public void click(By locator) 
	{
		try {

			getElement(locator).click();

		}
		catch (Exception e) 
		{
			System.out.println("some exception occured while clicking the web element...");
		}
	}


	public void sendKeys(By locator, String value) 
	{

		try 
		{
			WebElement element = getElement(locator);
			element.clear();
			element.sendKeys(value);
		} catch (Exception e) 
		{
			System.out.println("some exception occured while entering values in a field.");
		}
	}


	public boolean doIsDisplayed(By locator) 
	{

		try 
		{
			return getElement(locator).isDisplayed();
		}
		catch (Exception e) 
		{
			System.out.println("some exception occured while isDisplayed");
		}
		return false;
	}


	public boolean doIsEnabled(By locator) 
	{

		try 
		{
			return getElement(locator).isEnabled();
		}
		catch (Exception e) 
		{
			System.out.println("some exception occured while isEnabled");
		}

		return false;
	}


	public boolean doIsSelected(By locator) 
	{

		try 
		{
			return getElement(locator).isSelected();
		}
		catch (Exception e) 
		{
			System.out.println("some exception occured while isSelected");
		}

		return false;
	}

	public String getText(By locator) 
	{
		try 
		{
			return getElement(locator).getText();
		}
		catch (Exception e) 
		{
			System.out.println("some exception occured while getting text");
		}
		return null;
	}

	public void pressEnter(int time) throws Exception 
	{

		try 
		{
			robot = new Robot();
			for (int i = 0; i < time; i++) 
			{
				robot.keyPress(KeyEvent.VK_ENTER); 
				robot.keyRelease(KeyEvent.VK_ENTER);
				robot.delay(1000);

			}}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	public void pressTab(int time) throws Exception 
	{
		try 
		{
			robot = new Robot();
			for (int i = 0; i < time; i++) 
			{
				robot.keyPress(KeyEvent.VK_TAB); 
				Thread.sleep(1000);

			}}
		catch (Exception e) 
		{
			e.printStackTrace();

		}}
}


