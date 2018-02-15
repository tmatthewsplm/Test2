package ui.pageobjects;

import uitest.framework.AbstractPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChatterPage extends AbstractPage{
	private By postBtnLocator = By.cssSelector("#publisherAttachTextPost > span.publisherattachtext");
	private By fileBtnLocator = By.cssSelector("#publisherAttachContentPost > span.publisherattachtext");
	private By linkBtnLocator = By.cssSelector("#publisherAttachLinkPost > span.publisherattachtext");
	private By feedBtnLocator = By.cssSelector("#mainNavigation > ul > li.feedTypeList.hasIcon.hasSubNav > div.primaryNavSection > a");
	
	
    ChatterPage(WebDriver driver){
        super(driver);
    }
    
    public void waitForPageToLoad() {
    		log.info("waitForPageToLoad: waiting for side element of chatter to load / post file link");
    		WebDriverWait wait = new WebDriverWait(driver, PAGE_WAIT_TIME);
    		wait.until(ExpectedConditions.elementToBeClickable(postBtnLocator));
    		wait.until(ExpectedConditions.elementToBeClickable(fileBtnLocator));
    		wait.until(ExpectedConditions.elementToBeClickable(linkBtnLocator));
    		wait.until(ExpectedConditions.elementToBeClickable(feedBtnLocator));
    		//TODO add more checks...
    }
    /**
     * getTitle gets title from web page
     * @return web page title
     */
    public String getTitle() {
    		log.info("getTitle: getting page title");
    		return super.pageTitle();
    }
}