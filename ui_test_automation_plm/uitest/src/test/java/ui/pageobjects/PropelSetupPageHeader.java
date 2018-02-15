package ui.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import uitest.framework.AbstractPage;

public class PropelSetupPageHeader extends AbstractPage{
	
	private By importTabLocator = By.cssSelector("[class^='slds-tabs--default__nav'] > li:nth-child(1)");
	private By userSettingsTabLocator = By.cssSelector("[class^='slds-tabs--default__nav'] > li:nth-child(2)");
	private By adminSettingsTabLocator = By.cssSelector("[class^='slds-tabs--default__nav'] > li:nth-child(3)");
	
	protected PropelSetupPageHeader(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	public void waitForPageToLoad() {
		log.info("waitForPageToLoad: waiting for the propel setup header to load");

		WebDriverWait wait = new WebDriverWait(driver, PAGE_WAIT_TIME);
		wait.until(ExpectedConditions.elementToBeClickable(importTabLocator));
		wait.until(ExpectedConditions.elementToBeClickable(userSettingsTabLocator));
		wait.until(ExpectedConditions.elementToBeClickable(adminSettingsTabLocator));
	}
	
	public void clickImportTab() {
		driver.findElement(importTabLocator).click();
	}
	
	public void clickUserSettingsTab() {
		driver.findElement(userSettingsTabLocator).click();
	}
	
	public void clickAdminSettingsTab() {
		driver.findElement(adminSettingsTabLocator).click();
	}


}
