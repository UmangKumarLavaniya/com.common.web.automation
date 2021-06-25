package com.amazon.navigation.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import com.commoon.core.framework.web.utils.ElementActions;

/**
 * @author umangkumar
 *
 */
public class HomePage extends AmazonBasePage{
	
	protected ElementActions elementActions;

	private static final Logger logger = Logger.getLogger(HomePage.class);

	public HomePage(RemoteWebDriver driver) {
		super(driver);
		elementActions = new ElementActions(this.driver);
	}

	@FindBy(xpath="//span[contains(text(),'Hello, Sign in')]")
	protected WebElement signInPageLink;
	
	@FindBy(xpath = "//span[text()='Departments']")
	protected WebElement departmentTab;

	@FindBy(xpath = "//span[text()='Electronics']")
	protected WebElement electronicLink;
	
	@FindBy(xpath = "//span[contains(text(),'HEADPHONES')]")
	protected WebElement headPhonesLink;
	
	@FindBy(id="twotabsearchtextbox")
	protected WebElement searchTextArea;
	
	@FindBy(xpath="//span[@id='nav-cart-count']")
	protected WebElement cartIcon;

	@FindBy(xpath="//span[text()='Sign Out']")
	protected WebElement signOutLink;
	
	@FindBy(id="nav-link-accountList")
	protected WebElement accountAndListTab;
	
	@FindBy(id="productTitle")
	protected WebElement productTitleTxt; 
	
	public void searchAnItem()
	{
		elementActions.mouseHover(departmentTab);
		elementActions.click(electronicLink);
		elementActions.click(headPhonesLink);
	}
	
	public void searchAnItem(String itemDescription)
	{
		logger.info("Searching for : "+itemDescription);
		elementActions.clear(searchTextArea);
		elementActions.sendKeys(searchTextArea, itemDescription+Keys.ENTER);
	}
	
	public String selectSearchedItemByIndex(int itemIndex)
	{	
		logger.info("Selecting the searched item by index : " + itemIndex);
		elementActions.click(driver.findElement(By.xpath("//div[contains(@class,'s-result-list s-search-results sg-row')]/div["+itemIndex+"]//img")));
		return productTitleTxt.getText();
	}
	
	public void signOut()
	{
		logger.info("Signing out");
		elementActions.mouseHover(accountAndListTab);
		elementActions.click(signOutLink);
	}
	
	public void goToSignInPage()
	{
		logger.info("Clicking on signing link");
		elementActions.click(signInPageLink);
	}
}
