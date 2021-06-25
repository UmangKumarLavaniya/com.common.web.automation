package com.amazon.navigation.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.common.core.framework.base.BasePage;
import com.common.core.framework.exception.AutomationException;
import com.commoon.core.framework.web.utils.ElementActions;

/**
 * @author umangkumar
 *
 */
public class CartPage extends BasePage {

	private RemoteWebDriver driver;
	protected ElementActions elementActions;

	private static final Logger logger = Logger.getLogger(HomePage.class);

	public CartPage(RemoteWebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementActions = new ElementActions(this.driver);
	}

	@FindBy(xpath = "//input[@id='add-to-cart-button']")
	protected WebElement addToCartBtn;

	@FindBy(xpath = "//select[@name='quantity']")
	protected WebElement selectQuantityDropDown;

	@FindBy(xpath = "//span[@id='nav-cart-count']")
	protected WebElement cartIcon;

	@FindBy(xpath = "//input[@name='proceedToCheckout']")
	protected WebElement proceedToCheckoutBtn;

	@FindBy(xpath = "//div[@class='uss-o-close-icon uss-o-close-icon-medium']")
	protected WebElement cartSummaryCloseBtn;

	public void addItemToCart(int itemQuantity) {
		logger.info("Adding item to cart");
		if (itemQuantity <= 0 || itemQuantity > 30)
			throw new AutomationException("Operation not possible, cant add " + itemQuantity + "into cart");
		else if (itemQuantity > 1) {
			elementActions.selectOption(selectQuantityDropDown, itemQuantity - 1);
		}
		elementActions.click(addToCartBtn);
	}

	public void deleteItemFromCart(String text) {
		logger.info("Deleting item from cart");
		driver.findElement(By.xpath("//input[@type='submit' and @value='Delete' and contains(@aria-label,'Apple')]"))
				.click();
	}

	public void changeCartItemQuantity(int quantity) {
		logger.info("Changing the quantity");
		elementActions.selectOption(selectQuantityDropDown, quantity - 1);
	}

	public void goToCartPage() {
		logger.info("Clicking on cart icon");
		elementActions.waitForPageLoad();
		try {
			if (cartSummaryCloseBtn.isDisplayed())
				cartSummaryCloseBtn.click();
		} catch (Exception e) {
			logger.info("Cart summary button is not available");
		}
		elementActions.click(cartIcon);
	}

	public void proceedToCheckout() {
		logger.info("Proceeding to checkout");
		elementActions.click(proceedToCheckoutBtn);
	}
}
