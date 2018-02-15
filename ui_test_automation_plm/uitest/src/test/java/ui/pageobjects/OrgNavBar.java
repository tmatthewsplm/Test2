package ui.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.javascript.host.BarProp;

import uitest.framework.AbstractPage;


public class OrgNavBar extends AbstractPage{
    
    private By homeTabLocator = By.cssSelector("#home_Tab > a");
    private By chatterTabLocator = By.cssSelector("#Chatter_Tab > a");
    private By itemsTabLocator = By.cssSelector("[title='Items Tab']");
    private By manPartsTabLocator = By.cssSelector("[title='Manufacturer Parts Tab']");
    private By changesTabLocator = By.cssSelector("[title='Changes Tab']");
    private By qualityTabLocator = By.cssSelector("[title='Quality Tab']");
    private By projectsTabLocator = By.cssSelector("[title='Projects Tab']");
    private By categoriesTabLocator = By.cssSelector("[title='Categories Tab']");
    private By reportsTabLocator = By.cssSelector("[title='Reports Tab']");
    private By propelSetupLocator = By.cssSelector("[title='Propel Setup Tab']");
    private By allTabLocator = By.cssSelector("#AllTab_Tab > a > img");
    
    public OrgNavBar(WebDriver driver){
        super(driver);
    }
    
    public void waitForPageToLoad() {
		log.info("waitForPageToLoad: waiting for the nav bar to load");
		WebDriverWait wait = new WebDriverWait(driver, PAGE_WAIT_TIME);
		wait.until(ExpectedConditions.elementToBeClickable(homeTabLocator));
		wait.until(ExpectedConditions.elementToBeClickable(chatterTabLocator));
		wait.until(ExpectedConditions.elementToBeClickable(itemsTabLocator));
		wait.until(ExpectedConditions.elementToBeClickable(manPartsTabLocator));
		wait.until(ExpectedConditions.elementToBeClickable(changesTabLocator));
		wait.until(ExpectedConditions.elementToBeClickable(qualityTabLocator));
		wait.until(ExpectedConditions.elementToBeClickable(projectsTabLocator));

    }

    /**
     * clickHomeTab: click the home tab on the nav
     * @return HomePage object
     */
    public HomePage clickHomeTab(){
        log.info("clickHomeTab: click the home tab on the nav bar");
        driver.findElement(homeTabLocator).click();
        return new HomePage(driver);
    }

    /**
     * clickChatterTab: click the chatter tab on the nav bar
     * @return ChatterPage Object
     */
    public ChatterPage clickChatterTab(){
    		log.info("clickChatterTab: click the chatter tab on the nav bar");
    		driver.findElement(chatterTabLocator).click();
    		return new ChatterPage(driver);
    		
    }

    /**
     * clickItemsTab: click the item tab on the nav bar
     * @return ItemsHomePage object
     */
    public ItemsHomePage clickItemsTab(){
    		log.info("clickItemstab: click the item tab on the nav bar");
    		driver.findElement(itemsTabLocator).click();
    		return new ItemsHomePage(driver);
    }

    /**
     * clickManufacturerPartsTab: click the manufacturer parts tab on nav bar
     * @return ManufacturerPartsHomePage Object
     */
    public ManufacturerPartsHomePage clickManufacturerPartsTab() {
    		log.info("click the manufacturer parts tab on the nav bar");
    		driver.findElement(manPartsTabLocator).click();
    		return new ManufacturerPartsHomePage(driver);
    }
    
    /**
     * clickChangesTab: click the changes tab on the bnav bar
     * @return ChangesHomePage object
     */
    public ChangesHomePage clickChangesTab() {
    		log.info("click the changes tab on the nav bar");
    		driver.findElement(changesTabLocator).click();
    		return new ChangesHomePage(driver);
    }
    
    /**
     * clickQualityTab: click the quality tab on the nav bar
     * @return QualityHomePage object
     */
    public QualityHomePage clickQualityTab() {
    		log.info("click the quality tab on the nav bar");
    		driver.findElement(qualityTabLocator).click();
    		return new QualityHomePage(driver);
    }
    
    /**
     * clickProjectsTab: click the projects tab on the nav bar
     * @return ProjectsHomePage
     */
    public ProjectsHomePage clickProjectsTab(){
    log.info("clickProjectsTab: click the projects tab on nav bar");
    driver.findElement(projectsTabLocator).click();
    return new ProjectsHomePage(driver);
    }
    
    /**
     * clickCategoriesTab: click the categories tab on the nav bar
     * @return CategoriesHomePage
     */
    public CategoriesHomePage clickCategoriesTab(){
    log.info("clickCategoriesTab: click the categories tab on the nav bar");
    driver.findElement(categoriesTabLocator).click();
    return new CategoriesHomePage(driver);
    }
    
    /**
     * clickReportsTab: click the reports tab on the nav bar
     * @return ReportsHomePage
     */
    public ReportsHomePage clickReportsTab(){
    log.info("clickReportsTab: click the reports tab on the nav bar");
    driver.findElement(reportsTabLocator).click();
    return new ReportsHomePage(driver);
    }
    
    /**
     * clickPropelSetupTab: click the propel setup tab
     * @return PropelSetupUserSettingsPage
     */
    public PropelSetupUserSettingsPage clickPropelSetupTab(){
    log.info("clickPropelSetupTab: click the propel setup tab on the nav bar");
    driver.findElement(propelSetupLocator).click();
    return new PropelSetupUserSettingsPage(driver);
    }
    
    /**
     * clickAllTabsTab: clik the all tabs tab
     * @return AllTabsPage
     */
    public AllTabsPage clickAllTabsTab(){
    log.info("clickAllTabsTab: click the all tabs tab on the nav bar");
    driver.findElement(allTabLocator).click();
    return new AllTabsPage(driver);
    }
}