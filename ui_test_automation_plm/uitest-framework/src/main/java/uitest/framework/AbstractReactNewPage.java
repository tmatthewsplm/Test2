package uitest.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractReactNewPage extends AbstractReactPage{
	
	By categoryField = By.cssSelector("div input[class='slds-input'][role]");
	By cancelBtn = By.cssSelector("div.slds-col.slds-no-flex > div > a");
	By saveBtn = By.cssSelector("div.slds-col.slds-no-flex > div > button");
	By saveAndCreateNewBtn = By.cssSelector("div.slds-col.slds-no-flex > button");
//	private String jsSldsScript = "document.querySelector(\'"+sldsClass+"\').valueOf()";
	
	protected AbstractReactNewPage(WebDriver driver) {
		super(driver);
	}
	
//	/**
//	 * verifySldsClassExists: verify whether or not the slds class exists 
//	 * @return boolean value of wehther or not the class exists
//	 */
//	private boolean verifySldsClassExists() {
//		log.info("verifySldsClassExists: verifying whether or not the slds class exists");
//		WebElement ele = (WebElement) js.executeScript(jsSldsScript);
//		return ele.getAttribute("class").contains("slds");
//	}
//	
	/**
	 * waitForPageToLoad
	 */
	public void waitForPageToLoad() {
		log.info("waitForPageToLoad: waiting for the react page to load");
		WebDriverWait wait = new WebDriverWait(driver, PAGE_WAIT_TIME);
		wait.until(ExpectedConditions.elementToBeClickable(cancelBtn));
		wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
		wait.until(ExpectedConditions.elementToBeClickable(saveAndCreateNewBtn));
	}
	
	public void clickAndEnterCategoryField(String input) {
		log.info("clickAndEnterCategoryField: click and enter in an input for the category");
		try {
			WebElement catField = WebElements.waitUntilElementFound(driver, categoryField, ELEMENT_WAIT_TIME);
			catField.click();
			catField.sendKeys(input);
		} catch(Exception e) {
			log.error("ERROR: Issue while clicking or sending keys to category field.", e);
		}
		
	}
}
