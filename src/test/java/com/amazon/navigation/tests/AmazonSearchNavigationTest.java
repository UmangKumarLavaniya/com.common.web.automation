package com.amazon.navigation.tests;

import org.testng.annotations.Test;

import com.amazon.navigation.dataproviders.AmazonTestDP;
import com.amazon.navigation.pages.CartPage;
import com.amazon.navigation.pages.HomePage;
import com.common.core.framework.constants.Constant;

/**
 * @author umangkumar
 *
 */
public class AmazonSearchNavigationTest extends AmazonBaseTest {

	
	@Test(priority = 1, dataProvider = "searchMultipleItemsDP", dataProviderClass = AmazonTestDP.class)
	public void multipleTextSearch(String searchString) {
		HomePage homePage = new HomePage(driver);
		this.driver=homePage.driver;
		homePage.searchAnItem(searchString);
		this.driver=homePage.driver;
	}

	@Test(priority = 2, dataProvider = "searchItemsDP", dataProviderClass = AmazonTestDP.class)
	public void selectHeadPhones(String searchString) throws InterruptedException {
		HomePage homePage = new HomePage(this.driver);
		CartPage cartPage = new CartPage(homePage.driver);
		homePage.searchAnItem();
		String productOneTitle = homePage.selectSearchedItemByIndex(Constant.SEARCH_ITEM_BY_INDEX_ONE);
		cartPage.addItemToCart(Constant.SELECT_QUANTIY_ONE);
		homePage.searchAnItem(searchString);
		homePage.selectSearchedItemByIndex(Constant.SEARCH_ITEM_BY_INDEX_TWO);
		cartPage.addItemToCart(Constant.SELECT_QUANTIY_TWO);
		cartPage.goToCartPage();
		cartPage.deleteItemFromCart(productOneTitle);
		cartPage.changeCartItemQuantity(Constant.SELECT_QUANTIY_ONE);
		cartPage.proceedToCheckout();
	}

}
