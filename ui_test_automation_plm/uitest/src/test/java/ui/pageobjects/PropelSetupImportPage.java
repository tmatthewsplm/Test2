package ui.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import uitest.framework.AbstractPage;

public class PropelSetupImportPage extends AbstractPage{

	private By itemsCheckboxLocator = By.cssSelector("div:nth-child(1) > div > div:nth-child(2) > span > label > span.slds-checkbox--faux");
	private By itemsAddAndUpdateRBLocator = By.cssSelector("div:nth-child(2) > div > div:nth-child(1) > label > span.slds-radio--faux");
	private By itemsAddOnlyRBLocator = By.cssSelector("div:nth-child(2) > div > div:nth-child(2) > label > span.slds-radio--faux");
	protected PropelSetupImportPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void waitForPageToLoad() {
		log.info("waitForPageToLoad: waiting for the propel setup - user settings to load");
		WebDriverWait wait = new WebDriverWait(driver, PAGE_WAIT_TIME);
		wait.until(ExpectedConditions.presenceOfElementLocated(itemsCheckboxLocator));
	}
	
	public void clickItemCheckbox() {
		log.info("clickItemCheckbox:");
	}
	
	public void clickItemsAddAndUpdate() {
		log.info("clickItemsAddAndUpdate:");
	}
	
	public void clickItemsAddOnly() {
		log.info("clickItemsAddOnly:");
	}

}
