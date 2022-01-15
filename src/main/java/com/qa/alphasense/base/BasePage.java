package com.qa.alphasense.base;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.safari.SafariDriver;

import com.qa.alphasense.util.AppConstants;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();
	public OptionsManager optionsManager;
	public Properties prop;
	public static boolean highlightElement;


	/**
	 * @author <Muhammed Akcal> - 07/02/2022
	 * {@getDriver} - Settings For The Parallel Test Execution
	 */

	public static synchronized WebDriver getDriver() 
	{
		return tldriver.get();
	}


	/**
	 * @author <Muhammed Akcal> - 07/02/2022
	 * {@initDriver} - WebDriver Settings 
	 */
	
	public WebDriver init_driver(String browserName) 
	{
		highlightElement = prop.get("highlight").equals("yes") ? true : false;
		System.out.println("Browser name: "+ browserName);
		optionsManager = new OptionsManager(prop);

		switch (browserName) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			tldriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			tldriver.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));
			break;

		case "safari":
			WebDriverManager.getInstance(SafariDriver.class).setup();
			tldriver.set(new SafariDriver());
			break;

		default:
			System.out.println("Browser name "+ browserName + " is not found, please pass the correct browser");			
		}

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return getDriver();
	}

	/**
	 * @author <Muhammed Akcal> - 07/02/2022 
	 * {@init_properties} - Properties for Europe Teams
	 */
	
	public Properties init_properties() {

		prop = new Properties();
		String path = null;
		String env = null;

		try 
		{
			env = System.getProperty("qa");
			if(env.equals("qa")) 
			{
				path = AppConstants.North_Europe_Properties;
			}

			else if(env.equals("stg")) 
			{
				path = AppConstants.South_Europe_Properties;
			}

		} 
		catch (Exception e) 
		{
			path = AppConstants.Config_Properties;
		}


		try 
		{
			FileInputStream ip= new FileInputStream(path);
			prop.load(ip);
		} 

		catch (FileNotFoundException e) 
		{
			System.out.println("Error occured with config properties... Please correct your config...");
		} 

		catch (IOException e) 
		{
			e.printStackTrace();
		}

		return prop;

	}

	/**
	 * @author <Muhammed Akcal> - 07/02/2022
	 * {@getScreenshot} - Taking Png Screenshot Function
	 */
	
	public String getScreenshot() 
	{

		File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+ "/screenshots/" + System.currentTimeMillis()+ ".png";
		File destination = new File(path);

		try 
		{
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			System.err.println("Screenshot Captured Failed...");
			e.printStackTrace();
		}

		return path;


	}}