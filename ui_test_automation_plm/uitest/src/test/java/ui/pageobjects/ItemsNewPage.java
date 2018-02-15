package ui.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import uitest.framework.AbstractReactNewPage;
import uitest.framework.WebElements;

public class ItemsNewPage extends AbstractReactNewPage{

//	By categoryField = By.cssSelector("[class='slds-lookup']");
	By categoryList = By.cssSelector(".slds-lookup__list > li > a > p");
	By itemNumberField = By.cssSelector("#Name");
	By saveBtn = By.cssSelector("div.slds-col.slds-no-flex > div > button");

	protected ItemsNewPage(WebDriver driver) {
		super(driver);
		
	}
	
	public void enterCategoryType(String input) {
		log.info("enterCategoryType: enter the category type of the item");
		try{
			super.clickAndEnterCategoryField(input);
			super.pause(2000);
			//List<WebElement> catList = js.executeScript("document.querySelectorAll('.slds-lookup__list > li > a > p')");
			List<WebElement> catList = driver.findElements(categoryList);
			//List<WebElement> catList = WebElements.waitUntilAllElementsFound(driver, categoryList, ELEMENT_WAIT_TIME);
			log.info("created the list element which has " + String.valueOf(catList.size()) + " elements");
			for(WebElement e : catList) {
				log.info(e.getText());
				if(e.getText().equalsIgnoreCase(input)){
					log.info("clicking the list item category " + e.getText());
					e.click();
				}
			}
		} catch(Exception e) {
			log.error("ERROR: could not find element category field");
		}
	}
	
	public boolean itemNumberFieldPopulated() {
		log.info("itemNumberPopulated: verify if item number field populated");
		try {
			super.pause(3000);
			String itemNumber = WebElements.waitUntilElementFound(driver, itemNumberField, ELEMENT_WAIT_TIME).getAttribute("value");
			log.info(itemNumber);
			return !itemNumber.isEmpty();
		} catch(Exception e) {
			log.error("ERROR: Issue while verifying the item number field is populated");
		}
		return false;
	}
	
	/**
	 * 
	 */
	public ItemsDisplayPage clickSaveBtn() {
		log.info("clickSaveBtn: clicking save button");
		try {
			WebElements.waitAndClick(driver, saveBtn, ELEMENT_WAIT_TIME);
			return new ItemsDisplayPage(driver);
		} catch(Exception e) {
			log.error("ERROR: could not find save button");
		}
		return null;
	}
	
	
}
