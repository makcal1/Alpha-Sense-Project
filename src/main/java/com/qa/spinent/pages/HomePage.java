package com.qa.spinent.pages;

import org.openqa.selenium.WebDriver;

import com.qa.spinent.base.BasePage;
import com.qa.spinent.util.AppConstants;
import com.qa.spinent.util.ElementUtil;

public class HomePage extends BasePage{
	WebDriver driver;
	ElementUtil elementUtil;
	LocatorsPage lctr;
	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	    lctr = new LocatorsPage();
	//1.TEST -GETTING TITLE
	}public String getHomePageTitle() {
		elementUtil.waitForTitlePresent(AppConstants.HOME_PAGE_TITLE);
		return elementUtil.doGetPageTitle();
	
	//2.TEST --> introToSportsTechButton
	}public boolean enableCheckIntroToSportsTechButton() {
		elementUtil.waitForElementToBeClickable(lctr.introToSportsTechButton);
	return elementUtil.doIsEnabled(lctr.introToSportsTechButton);	
	
	//3.TEST -->knowYourselfButton
		}public boolean enableCheckknowYourselfButton() {
			elementUtil.waitForElementToBeClickable(lctr.knowYourselfButton);
		return elementUtil.doIsEnabled(lctr.knowYourselfButton);	
		
		//4.TEST -->determineProblemsButton
			}public boolean enableCheckdetermineProblemsButton() {
				elementUtil.waitForElementToBeClickable(lctr.determineProblemsButton);
			return elementUtil.doIsEnabled(lctr.determineProblemsButton);	
			
			//5.TEST -->askToCustomerButton
		}public boolean enableCheckaskToCustomerButton() {
			elementUtil.waitForElementToBeClickable(lctr.askToCustomerButton);
		return elementUtil.doIsEnabled(lctr.askToCustomerButton);	
		
		//6.TEST -->generateIdeasButton
			}public boolean enableCheckgenerateIdeasButton() {
				elementUtil.waitForElementToBeClickable(lctr.generateIdeasButton);
			return elementUtil.doIsEnabled(lctr.generateIdeasButton);	
			
			//7.TEST -->preapareMVPButton
		}public boolean enableCheckpreapareMVPButton() {
			elementUtil.waitForElementToBeClickable(lctr.preapareMVPButton);
		return elementUtil.doIsEnabled(lctr.preapareMVPButton);	
		
		//8.TEST --> givePresentationButton
			}public boolean enableCheckgivePresentationButton() {
				elementUtil.waitForElementToBeClickable(lctr.givePresentationButton);
			return elementUtil.doIsEnabled(lctr.givePresentationButton);	
			}
			//9.TEST --> belowButtonAblems
		public boolean enableCheckbelowButtonAblems() {
			elementUtil.waitForElementToBeClickable(lctr.belowButtonAblems);
		return elementUtil.doIsEnabled(lctr.belowButtonAblems);	
		
		//10.TEST -->languageButton
			}public boolean enableChecklanguageButton() {
				elementUtil.waitForElementToBeClickable(lctr.languageButton);
			return elementUtil.doIsEnabled(lctr.languageButton);	
			
			//11.TEST -->userAccountNamesButton
		}public boolean enableCheckuserAccountNamesButton() {
			elementUtil.waitForElementToBeClickable(lctr.userAccountNamesButton);
			return elementUtil.doIsEnabled(lctr.userAccountNamesButton);	
			
			}//12.TEST -->printCertificateButton
	public boolean enableCheckprintCertificateButton() {
		elementUtil.waitForElementToBeClickable(lctr.printCertificateButton);
	return elementUtil.doIsEnabled(lctr.printCertificateButton);	
	
	}//Helper method to go My ReportPage
	
	public void clickon() {
		elementUtil.waitForElementToBeClickable(lctr.myReportButton);
		elementUtil.doClick(lctr.myReportButton);
	
	//MyReportPage Method	
	}public MyReportPage goToMyReportPage() {
		clickon();
		
		return new MyReportPage(driver);
	}
	

}
