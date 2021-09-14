package com.ap.tests;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ap.pages.HomePage;
import com.ap.pages.LoginPage;


public class LoginTest extends BaseTest {
	
	LoginPage lp = null;
	HomePage hp = null;
	
	@BeforeMethod
	public void init(ITestResult result) {
		test = reports.createTest(result.getMethod().getMethodName());
		hp = new HomePage(driver);
		lp = new LoginPage(driver);
		test.info("Browser Launched");
		test.info("Launched Home Page");
	}
	
	@Test
	public void testinValidLogin() {
	//	test = reports.createTest(new Object(){}.getClass().getEnclosingMethod().getName());
		hp.navToLoginPage(); // navigate to login page
		test.pass("Navigated to Login Page Successfully");

		lp.login("karthik@gmail.com", "test123"); // entering username and password and click on sign in button
		test.info("Entered User name and Password and clicked on Submit Button");
		assertTrue(isElementPresent(lp.btn_Submit)); // verifying navigated to home page or not
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
	
	@AfterMethod
	public void afterMethod(ITestResult result) {
		
		if(result.getStatus() == ITestResult.SUCCESS) {
			System.out.println(result.getMethod().getMethodName()+" ==> Pass");
			test.pass(result.getMethod().getMethodName()+" Success");
		}
			
		else if(result.getStatus() == ITestResult.FAILURE){
			test.fail(result.getMethod().getMethodName()+" Fail");		

		}else {
			test.skip(result.getMethod().getMethodName()+" Skipped");		

		}
		if(isElementPresent(hp.btn_signout)) {
			hp.signOut();
			test.pass("Signed out Successfully");
		}
	//	driver.navigate().back();
		sleep();
	}
	
	

}
