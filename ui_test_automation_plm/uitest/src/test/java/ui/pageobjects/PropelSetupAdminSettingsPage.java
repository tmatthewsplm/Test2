package ui.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import uitest.framework.AbstractPage;

public class PropelSetupAdminSettingsPage extends AbstractPage{

	private By hiddenSpinnerLocator = By.cssSelector("#root > div > div:nth-child(4) > div.slds-tabs-default.slds-m-horizontal--small > div:nth-child(3) > div > div:nth-child(5) > div.slds-spinner_container.slds-transition-hide");

	protected PropelSetupAdminSettingsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void waitForPageToLoad() {
		log.info("waitForPageToLoad: waiting for the propel setup - user settings to load");
		WebDriverWait wait = new WebDriverWait(driver, PAGE_WAIT_TIME);
		wait.until(ExpectedConditions.presenceOfElementLocated(hiddenSpinnerLocator));
	}

}
