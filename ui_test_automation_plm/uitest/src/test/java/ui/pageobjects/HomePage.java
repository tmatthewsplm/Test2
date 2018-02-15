package ui.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import uitest.framework.AbstractPage;

public class HomePage extends AbstractPage{
	private By postBtnLocator = By.cssSelector("#publisherAttachTextPost > span.publisherattachtext");
	private By fileBtnLocator = By.cssSelector("#publisherAttachContentPost > span.publisherattachtext");
	private By linkBtnLocator = By.cssSelector("#publisherAttachLinkPost > span.publisherattachtext");
	public HomePage(WebDriver driver) {
		super(driver);
	}

	public void waitForPageToLoad() {
		log.info("waitForPageToLoad: waiting for the homepage to load");
		WebDriverWait wait = new WebDriverWait(driver, PAGE_WAIT_TIME);
		wait.until(ExpectedConditions.elementToBeClickable(postBtnLocator));
		wait.until(ExpectedConditions.elementToBeClickable(fileBtnLocator));
		wait.until(ExpectedConditions.elementToBeClickable(linkBtnLocator));
	}
	
	public String getTitle() {
		log.info("getTitle: getting title of webpage");
		return super.pageTitle();
	}




}
