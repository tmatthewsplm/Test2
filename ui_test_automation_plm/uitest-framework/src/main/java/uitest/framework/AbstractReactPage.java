package uitest.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import uitest.framework.AbstractPage;

public abstract class AbstractReactPage extends AbstractPage{

	By sldsClass = By.cssSelector(".slds");

	
	protected AbstractReactPage(WebDriver driver) {
		super(driver);
	}
	
	public void waitForPageToLoad() {
		log.info("waitForPageToLoad: waiting for the react page to load");
		WebDriverWait wait = new WebDriverWait(driver, PAGE_WAIT_TIME);
		wait.until(ExpectedConditions.attributeContains(sldsClass, "class", "slds"));
	}
	
	public boolean sldsExists() {
		log.info("sldsExists: checking if slds class exists on react page");
		int i = driver.getPageSource().indexOf("div class=\"slds\"");
		if(i == -1) {
			return false;
		}
		return true;
	}
	

}
