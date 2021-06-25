package com.amazon.navigation.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.commoon.core.framework.web.utils.ElementActions;

/**
 * @author umangkumar
 *
 */
public class SignInPage extends AmazonBasePage{
	
	protected ElementActions elementActions;
	private RemoteWebDriver driver;

	private static final Logger logger = Logger.getLogger(HomePage.class);

	public SignInPage(RemoteWebDriver driver) {
		super(driver);
		this.driver=driver;
		elementActions = new ElementActions(this.driver);
	}
	
	@FindBy(id="ap_email")
	protected WebElement emailTextBox;
	
	@FindBy(id="ap_password")
	protected WebElement passwordTextBox;
	
	@FindBy(id="signInSubmit")
	protected WebElement submitButton;
	
	@FindBy(id="continue")
	protected WebElement continueButton;
	
	
	public void signIn(String email,String password,String userName)
	{
		logger.info("Starting sign in process");
		elementActions.sendKeys(emailTextBox, email);
		elementActions.click(continueButton);
		elementActions.sendKeys(passwordTextBox, password);
		elementActions.click(submitButton);
		WebElement userWelcomeText=driver.findElement(By.xpath("//div[@id='nav-tools']//span[text()='Hello, "+userName+"']"));
		Assert.assertTrue(userWelcomeText.isDisplayed());
	}
	
	
}
