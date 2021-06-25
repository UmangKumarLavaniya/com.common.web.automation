package com.amazon.navigation.tests;

import org.testng.annotations.Test;

import com.amazon.navigation.dataproviders.AmazonTestDP;
import com.amazon.navigation.pages.HomePage;
import com.amazon.navigation.pages.SignInPage;

/**
 * @author umangkumar
 *
 */
public class SignInSignOutTest extends AmazonBaseTest {

	
	
	@Test(dataProvider = "signInSignOutDP", dataProviderClass = AmazonTestDP.class)
	public void signInSignOutTest(String email, String password, String userName) throws InterruptedException {
		HomePage homePage = new HomePage(driver);
		this.driver=homePage.driver;
		SignInPage signInPage = new SignInPage(homePage.driver);
		homePage.goToSignInPage();
		signInPage.signIn(email, password, userName);
		homePage.signOut();
	}
}
