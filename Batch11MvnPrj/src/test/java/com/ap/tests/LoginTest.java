package com.ap.tests;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
	
	@Test
	public void testinValidLogin() {
	//	test = reports.createTest(new Object(){}.getClass().getEnclosingMethod().getName());
		hp.navToLoginPage(); // navigate to login page
		test.pass("Navigated to Login Page Successfully"); 
		lp.login("karthik@gmail.com", "test123"); // entering username and password and click on sign in button
		test.info("Entered User name and Password and clicked on Submit Button");
		assertFalse(isElementPresent(lp.btn_Submit)); // verifying navigated to home page or not
		test.pass("Success. Not navigated to Home page");
	}
	
	@Test
	public void testValidLogin() {
	//	test = reports.createTest(new Object(){}.getClass().getEnclosingMethod().getName());
		hp.navToLoginPage();
		test.pass("navigated to Login Page Successfully");
		lp.login("dem7@gmail.com", "xyzabc");
		test.info("Entered User name and Password and clicked on Submit Button");
		assertFalse(isElementPresent(lp.btn_Submit));
		test.pass("Navigated to Home Page Successfully");
	}
	// @Test(retryAnalyzer = Retry.class)
	@Test
	public void testEmptyLogin() {
	//	test = reports.createTest(new Object(){}.getClass().getEnclosingMethod().getName());
		hp.navToLoginPage();
		lp.login("", "");
		test.info("Entered User name and Password and clicked on Submit Button");
		assertTrue(isElementPresent(lp.btn_Submit));
		test.pass("Success. Not navigated to Home page");
	}

}
