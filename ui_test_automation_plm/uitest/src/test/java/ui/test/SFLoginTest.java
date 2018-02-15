package ui.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import ui.pageobjects.HomePage;
import ui.pageobjects.ItemsDisplayDetailsPage;
import ui.pageobjects.ItemsDisplayPage;
import ui.pageobjects.ItemsHomePage;
import ui.pageobjects.ItemsNewPage;
import ui.pageobjects.OrgNavBar;
import ui.pageobjects.PageHeader;
import ui.pageobjects.SearchResultsPage;
import ui.pageobjects.UnsavedChangesModal;
import uitest.framework.AbstractSeleniumTest;


public class SFLoginTest extends AbstractSeleniumTest{

	@Test
	public void navToHomePageTest() {
		String homePageTitle = "Salesforce - Developer Edition";
		ItemsHomePage.gotoSplahPageFromEnv(env, driver, "myUsername", "myPassword");
		OrgNavBar onb = new OrgNavBar(driver);
		onb.waitForPageToLoad();
		HomePage homePage = onb.clickHomeTab();
		homePage.waitForPageToLoad();
		Assert.assertEquals(homePage.getTitle(), homePageTitle);
	}
	
	
	@Test
	public void createItemTest(){
		ItemsHomePage.gotoSplahPageFromEnv(env, driver, "myUsername", "myPassword");
		ItemsHomePage itemsHomePage = new ItemsHomePage(driver);
		itemsHomePage.waitForPageToLoad();
		ItemsNewPage itemsNewPage = itemsHomePage.clickNewBtn();
		itemsNewPage.waitForPageToLoad();
		Assert.assertTrue(itemsNewPage.sldsExists());
		itemsNewPage.enterCategoryType("Part");
		itemsNewPage.waitForPageToLoad();
		Assert.assertTrue(itemsNewPage.itemNumberFieldPopulated());
		ItemsDisplayPage itemsDisplayPage = itemsNewPage.clickSaveBtn();
		itemsDisplayPage.waitForPageToLoad();
		PageHeader ph = new PageHeader(driver);
		itemsDisplayPage.clickEditDraftDoneEditingBtn();
		ItemsDisplayDetailsPage iddp = itemsDisplayPage.clickItemDetailsTab();
		iddp.insertDescription("Test: createItemtest, Desc: This item was created through an automation script");
		iddp.clickEditDraftDoneEditingBtn();
		UnsavedChangesModal ucm = new UnsavedChangesModal(driver);
		ucm.waitForModalToLoad();
		ucm.clickSaveChangesBtn();
		itemsDisplayPage.waitForPageToLoad();
		String itemNumber = itemsDisplayPage.getItemNumber();
		ph.clickAndSearch(itemNumber);
		SearchResultsPage srp = new SearchResultsPage(driver);
		srp.clickSideBarObject("Items");
		Assert.assertTrue(srp.verifyItemExists(itemNumber));
		srp.clickSideBarObject("Item Revisions");
		Assert.assertTrue(srp.verifyItemRevExists(itemNumber));
	}
}
