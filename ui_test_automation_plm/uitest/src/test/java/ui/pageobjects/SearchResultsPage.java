package ui.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import uitest.framework.AbstractPage;
import uitest.framework.WebElements;

public class SearchResultsPage extends AbstractPage{
	
	By itemNumbersInItemTable = By.cssSelector("[id*='Item__c'] >table> tbody > tr > th[class~='dataCell'] > a");
	By parentItemNumbersInItemRevTable = By.cssSelector("[id*='Revision__c'] >table> tbody > tr > td[class~='dataCell'] > a");
	By itemsSideBarBtn = By.cssSelector("ul > li > div[data_title=Items]");
	By itemRevsSideBarBtn = By.cssSelector("ul > li > div[data_title='Item Revisions']");

	public SearchResultsPage(WebDriver driver) {
		super(driver);
	}
	
	public void clickSideBarObject(String input) {
		log.info("selectSideBarObject: click the side bar button based on input");
		if(input.equalsIgnoreCase("Items")) {
			WebElements.waitAndClick(driver, itemsSideBarBtn, ELEMENT_WAIT_TIME);
			super.pause(3000);
		} else if(input.equalsIgnoreCase("Item Revisions")) {
			WebElements.waitAndClick(driver, itemRevsSideBarBtn, ELEMENT_WAIT_TIME);
			super.pause(3000);
		}
	}
	
	public boolean verifyItemExists(String itemNumber) {
		log.info("verifyItemExists: verify that the item exists");
		try {
			List<WebElement> listItemNumbers = WebElements.waitUntilAllElementsFound(driver, itemNumbersInItemTable, ELEMENT_WAIT_TIME);
			for(WebElement item : listItemNumbers) {
				if(item.getText().equalsIgnoreCase(itemNumber)) {
					return true;
				}
			}
		} catch(Exception e) {
			log.error("ERROR: could not find item numbers", e);
		}
		return false;
	}
	
	public boolean verifyItemRevExists(String itemNumber) {
		log.info("verifyItemRevExists: verify that the item exists");
		try {
			List<WebElement> listItemNumbers = WebElements.waitUntilAllElementsFound(driver, parentItemNumbersInItemRevTable, ELEMENT_WAIT_TIME);
			for(WebElement item : listItemNumbers) {
				if(item.getText().equalsIgnoreCase(itemNumber)) {
					return true;
				}
			}
		} catch(Exception e) {
			log.error("ERROR: could not find item numbers", e);
		}
		return false;	
	}
	
	
}
