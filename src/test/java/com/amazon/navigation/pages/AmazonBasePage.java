/**
 * 
 */
package com.amazon.navigation.pages;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import com.common.core.framework.base.BasePage;
import com.commoon.core.framework.web.utils.ElementActions;

/**
 * @author umangkumar
 *
 */
public class AmazonBasePage extends BasePage{


	protected ElementActions elementActions;
	
	public AmazonBasePage(RemoteWebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
		elementActions = new ElementActions(this.driver);
	}
	
}
