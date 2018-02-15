package uitest.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * this is not for the salesforce Home page tab button this is for the default splash page 
 * @author theo
 *
 */
public class AbstractHomePage extends AbstractPage{
	By newBtnLocator = By.cssSelector("#hotlist > table > tbody > tr > td.pbButton > input");
	By viewGoBtnLocator = By.cssSelector("#filter_element > div > span > span.fBody > input");
	By viewEditBtnLocator = By.cssSelector("#filter_element > div > span > span.fFooter > a:nth-child(1)");
	By createNewViewBtnLocator = By.cssSelector("#filter_element > div > span > span.fFooter > a:nth-child(2)");
	By pageTypeLocator = By.cssSelector("#bodyCell > div.bPageTitle > div.ptBody > div.content > h1");
	private String homePageType;
	protected AbstractHomePage(WebDriver driver) {
		super(driver);
	}

	/**
	 * 
	 */
	public void waitForPageToLoad() {
		log.info("waitForPageToLoad: waiting for the basic page type home page to load");
		WebDriverWait wait = new WebDriverWait(driver, PAGE_WAIT_TIME);
		wait.until(ExpectedConditions.elementToBeClickable(newBtnLocator));
		wait.until(ExpectedConditions.elementToBeClickable(viewGoBtnLocator));
	}

	/**
	 * 
	 * @return
	 */
	public String getHomePageType() {
		log.info("getHomePageType: get the home page type");
		return driver.findElement(pageTypeLocator).getText();
	}
	
	/**
	 * 
	 * @param homePageType
	 */
	public void setHomePageType(String homePageType) {
		log.info("setHomePageType: set the home page type");
		this.homePageType = homePageType;
	}
}
