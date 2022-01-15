package com.qa.alphasense.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LocatorsPage {
	/**
	 * @author <Muhammed Akcal> - 07/02/2022
	 */
	
	By searchKeywordLocation = By.className("CodeMirror-lines");
	By lastelementAfterSearcingKeywordLocation = By.xpath("//div[last()]/div/div/div/span/span");
    By chosenStatement = By.xpath("//*[@id='1285500634_top']/div[2]/p[last()]");
}




