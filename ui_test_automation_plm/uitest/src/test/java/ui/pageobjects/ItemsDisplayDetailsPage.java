package ui.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import uitest.framework.WebElements;

public class ItemsDisplayDetailsPage extends ItemsDisplayPage{

	By itemNumberAnchorTag = By.cssSelector("div:nth-child(1) > div:nth-child(1) > div > div.slds-form-element__control > span > span > a");
	By itemCategoryAnchorTag = By.cssSelector("div:nth-child(1) > div:nth-child(2) > div > div.slds-form-element__control > span > span > a");
	By descriptionTextArea = By.cssSelector("#Description__c");
	public ItemsDisplayDetailsPage(WebDriver driver) {
		super(driver);
	}
	
	public void waitForPageToLoad() {
		log.info("waitForPageToLoad: waiting for the react page to load");
		WebDriverWait wait = new WebDriverWait(driver, PAGE_WAIT_TIME);
		wait.until(ExpectedConditions.elementToBeClickable(itemNumberAnchorTag));
		wait.until(ExpectedConditions.elementToBeClickable(itemCategoryAnchorTag));
	}
	
	/**
	 * insertDescription: inserts the provided description into the item description field
	 * @param desc
	 */
	public void insertDescription(String desc) {
		log.info("insertDescription: insert the provided description into the item description field");
		try {
			WebElement descTextArea = WebElements.waitUntilElementFound(driver, descriptionTextArea, ELEMENT_WAIT_TIME);
			WebElements.waitAndClick(driver, descTextArea, ELEMENT_WAIT_TIME);
			descTextArea.sendKeys(desc);
		} catch(Exception e) {
			log.error("ERROR: could not find description text area", e);
		}
	}
}
