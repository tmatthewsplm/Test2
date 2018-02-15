package ui.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import uitest.framework.AbstractPage;
import uitest.framework.WebElements;

public class UnsavedChangesModal extends AbstractPage{

	By saveChangesBtn = By.cssSelector("div.slds-modal__footer > button.slds-button.slds-button--brand");
	public UnsavedChangesModal(WebDriver driver) {
		super(driver);
	}
	
	public void waitForModalToLoad() {
		log.info("waitForModalToLoad: wait for modal to load");
		WebDriverWait wait = new WebDriverWait(driver, PAGE_WAIT_TIME);
		wait.until(ExpectedConditions.elementToBeClickable(saveChangesBtn));
	}
	
	/**
	 * 
	 */
	public void clickSaveChangesBtn() {
		log.info("clickSaveChangesBtn: click save changes btn");
		try {
			WebElements.waitAndClick(driver, saveChangesBtn, ELEMENT_WAIT_TIME);			
		} catch(Exception e) {
			log.error("ERROR:could not find element save changes btn");
		}
	}
	

}
