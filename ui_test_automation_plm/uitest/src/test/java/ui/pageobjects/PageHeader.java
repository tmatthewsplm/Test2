package ui.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import uitest.framework.AbstractPage;
import uitest.framework.WebElements;

public class PageHeader extends AbstractPage{
	By searchBar = By.cssSelector("#phSearchInput");
	By searchBtn = By.cssSelector("#phSearchButton");
	public PageHeader(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * 
	 * @param input
	 */
	public void clickAndSearch(String input) {
		log.info("clickAndSearch: click and search in search bar");
		try{
			WebElement ele = WebElements.waitUntilElementFound(driver, searchBar, ELEMENT_WAIT_TIME);
			ele.click();
			ele.sendKeys(input);
			WebElements.waitAndClick(driver, searchBtn, ELEMENT_WAIT_TIME);
		} catch(Exception e) {
			log.error("ERROR: could not find element search bar", e);
		}
	}
}
