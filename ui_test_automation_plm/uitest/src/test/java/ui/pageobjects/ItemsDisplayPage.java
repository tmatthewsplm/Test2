package ui.pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import uitest.framework.AbstractPage;
import uitest.framework.WebElements;

public class ItemsDisplayPage extends AbstractPage{

	By detailsTab = By.cssSelector("[data-test-id='item--details-tab']");
	By bomTab = By.cssSelector("[data-test-id='item--bom-tab']");
	By manufacturersTab = By.cssSelector("[data-test-id='item--aml-tab']");
	By attachmentsTab = By.cssSelector("[data-test-id='item--attachments-tab']");
	By whereUsedTab = By.cssSelector("[data-test-id='item-sidebar--whereUsed-tab']");
	By editDraftBtn = By.cssSelector("div:nth-child(1) > div > div > div.slds-button-group > button.slds-button.slds-button--brand");
	By itemNumberField = By.cssSelector("div:nth-child(1) > div:nth-child(1) > div > div.slds-form-element__control > span > span > a");
	List<String> itemDrafts = new ArrayList<String>();
	
	public ItemsDisplayPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * waitForPageToLoad: wait for item display page to load
	 */
	public void waitForPageToLoad() {
		log.info("waitForPageToLoad: waiting for the react page to load");
		WebDriverWait wait = new WebDriverWait(driver, PAGE_WAIT_TIME);
		wait.until(ExpectedConditions.elementToBeClickable(detailsTab));
		wait.until(ExpectedConditions.elementToBeClickable(bomTab));
		wait.until(ExpectedConditions.elementToBeClickable(manufacturersTab));
		wait.until(ExpectedConditions.elementToBeClickable(attachmentsTab));
	}
	
	/**
	 * getItemNumber: gets the item number of the item display page
	 * @return string of item number
	 */
	public String getItemNumber() {
		try {
		WebElement itemNumber = WebElements.waitUntilElementFound(driver, itemNumberField, ELEMENT_WAIT_TIME);
		return itemNumber.getAttribute("innerHTML");
		} catch(Exception e) {
			log.error("ERROR: could not find item number field", e);
		}
		return null;
	}
	
	/**
	 * clickEditDraftDoneEditingBtn: click the edit draft button
	 */
	public void clickEditDraftDoneEditingBtn() {
		log.info("clickEditDraftDoneEditingBtn: click the edit draft button");
		try{
			WebElements.waitAndClick(driver, editDraftBtn, ELEMENT_WAIT_TIME);
		} catch(Exception e) {
			log.error("ERROR: could not find edit draft btn", e);
		}
	}
	
	public ItemsDisplayDetailsPage clickItemDetailsTab() {
		log.info("clickItemDetailsTab: click the item details tab");
		try {
			WebElements.waitAndClick(driver, detailsTab, ELEMENT_WAIT_TIME);
			return new ItemsDisplayDetailsPage(driver);
		} catch(Exception e) {
			log.error("ERROR: could not find item details tab", e);
		}
		return null;
	}
	
	/**
	 * getItemRevision get the item revision of the item on the display page
	 * @return the string of the item revision 
	 */
	public String getItemRevision() {
		try {
			return "";
		} catch(Exception e) {
			log.error("ERROR: could not find item revision field");
		}
		return "";
	}
}
