package com.qa.spinent.pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.spinent.base.BasePage;
import com.qa.spinent.util.ElementUtil;

public class MyReportPage extends BasePage {
	WebDriver driver;
	ElementUtil elementUtil;
	LocatorsPage lctr;
	By beforePartXpath=By.xpath("/html/body/div[3]/div[3]/div/table/thead/tr/th[");
	By afterPartXpath = By.xpath("]\"");
	
public MyReportPage(WebDriver driver) {
	this.driver = driver;
	elementUtil = new ElementUtil(driver);
	lctr = new LocatorsPage();

	//1.METHOD --> Table Visibility
}public boolean tableVisibilityMethod() {
	return elementUtil.doIsDisplayed(lctr.tableButton);

}public String myreportPageUrl() {
	
	
	return driver.getCurrentUrl();
}

	
	

	
	



}
