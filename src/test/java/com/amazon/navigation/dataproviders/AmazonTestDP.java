/**
 * 
 */
package com.amazon.navigation.dataproviders;

import org.testng.annotations.DataProvider;

/**
 * @author umangkumar
 *
 */


public class AmazonTestDP {
	
	public static final String EMAIL="temp.test.interview.mail@gmail.com";
	public static final String PASSWORD="Testing@123";
	public static final String USER_NAME="Test";
	
	@DataProvider
	public static Object[][] signInSignOutDP()
	{
		return new Object[][] { { EMAIL,PASSWORD,USER_NAME } };
	}

	
	@DataProvider
	public static Object[][] searchItemsDP()
	{
		return new Object[][] { { "Mobile" } };
	}
	
	@DataProvider
	public static Object[][] searchMultipleItemsDP()
	{
		return new Object[][] { { "Macbook Pro" } ,{"Headphones"},{"Mobile"}};
	}
	
	
	
}
