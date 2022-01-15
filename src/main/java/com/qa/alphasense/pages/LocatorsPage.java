package com.qa.spinent.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class LocatorsPage {

WebDriver driver;
/**
 * 
 * LOGIN PAGE LOCATORS
 * 
 */
By redlLoginBtn=By.xpath("//a[@class='active']");
By greenLoginBtn=By.xpath("//button[contains(@type,'submit')]");



/**
 * 
 * LOCATORS PAGE LOCATORS
 * 
 */
By email=By.id("email");
By password=By.id("password");
By errorMessage = By.xpath("//*[@id=\"swal2-content\"]");



/**
 * HOMEPAGE LOCATORS
 * 
 * 
 */

By introToSportsTechButton=By.xpath("//a[normalize-space()='Intro to SportsTech']");
By knowYourselfButton = By.xpath("//a[normalize-space()='Know Yourself']");
By determineProblemsButton=By.xpath("//img[contains(@ng-src,'https://api.guide.spinent.eu/uploads/124/3.png')]");  // <-----
By askToCustomerButton=By.xpath("//a[normalize-space()='Ask to Customer']");
By generateIdeasButton=By.xpath("//a[normalize-space()='Generate Ideas']");
By preapareMVPButton=By.xpath("//a[normalize-space()='Prepare MVP']");
By givePresentationButton= By.xpath("//a[normalize-space()='Prepare MVP']");
By belowButtonAblems = By.xpath("//img[@alt='EU Supported Project']");     //
By languageButton=By.xpath("//a[normalize-space()='Logout from Muhammed Zahid Akcal']");   //
By userAccountNamesButton=By.xpath("//a[normalize-space()='Logout from Muhammed Zahid Akcal']");  // <-----
By printCertificateButton=By.xpath("//a[normalize-space()='Print Certificate']");


/**
 * 
 * 
 * MyReportPage Locators
 * 
 */

By myReportButton =By.xpath("//a[normalize-space()='My Report']");
By tableButton= By.xpath("//table[contains(@class,'table table-striped table-hover')]");   //  
By beforePartXpath=By.xpath("/html/body/div[3]/div[3]/div/table/thead/tr/th[");
By afterPartXpath = By.xpath("]\"");


/**
 * 
 * 
 * AccountLogoutPage Locators
 * 
 */
By logOutButton=By.xpath("/html/body/div/div[2]/ul/li[4]/a");

}




