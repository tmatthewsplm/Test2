package ui.pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.core.env.Environment;
import uitest.framework.AbstractHomePage;
import uitest.framework.WebElements;

public class ItemsHomePage extends AbstractHomePage{

	By newBtnLocator = By.cssSelector("#hotlist > table > tbody > tr > td.pbButton > input");

	
	public ItemsHomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public static void gotoSplahPageFromEnv(Environment env, WebDriver driver, String usernameProperty, String passwordProperty) {
		LoginPage.doLoginFromEnv(env, driver, usernameProperty, passwordProperty);
	}
	
	/**
	 * getTitle: get page title
	 * @return page title
	 */
	public String getTitle() {
		log.info("getTitle: get page title");
		return super.pageTitle();
	}
	
	/**
	 * 
	 */
	public ItemsNewPage clickNewBtn() {
		log.info("clickNewBtn: creating a new " + getHomePageType() + " object");
		WebElements.waitAndClick(driver, newBtnLocator, ELEMENT_WAIT_TIME);
		return new ItemsNewPage(driver);
	}
	
}
