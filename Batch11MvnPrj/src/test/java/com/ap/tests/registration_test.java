package com.ap.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.ap.pages.HomePage;
import com.ap.pages.LoginPage;
import com.ap.pages.Registration_page;

public class registration_test extends BaseTest{
	
	HomePage hp=null;
	Registration_page Rp=null;
	LoginPage lp=null;
	
	
	@BeforeMethod
	public void init() {
		hp=new HomePage(driver);
		Rp=new Registration_page(driver);
		lp=new LoginPage(driver);
	}
	

	@Test(priority=1)
	public void CreateEmail_address() {
		hp.navToLoginPage();
		Rp.CreateEmailId("gev4@gmail.com");
		Rp.click();
		sleep();
		String title = driver.getTitle();
		System.out.println(title);
		assertTrue(isElementPresent(Rp.check_submit ));
	}
	
	@Test(priority=2)
	public void validRegister() {
		sleep();
		Rp.Fillapplication("xyz", "abc", "xyzabc", "dydyruyfufuf","fffffjhgkj" ,  "00000",  "56366586");
		Rp.submit();
		String title1 = driver.getTitle();
		System.out.println(title1);
		assertEquals("My account - My Store", title1);
		hp.signOut();
	}

	@Test(priority=3)
	public void testValidLogin() {
		hp.navToLoginPage();
		lp.login("gev4@gmail.com", "xyzabc");
		assertFalse(isElementPresent(lp.btn_Submit));
		hp.signOut();	
		}
	
	@Test(priority=4)
	public void CreateEmail_addressForInvalidRegister() {
		Rp.CreateEmailId("dev5@gmail.com");
		Rp.click();
		sleep();
		String title = driver.getTitle();
		System.out.println(title);
		assertTrue(isElementPresent(Rp.check_submit ));
	}
	
	@Test(priority=5)
	public void InvalidRegister() {
		sleep();
		Rp.Fillapplication("xyz", "abc", "xyzabc", "dydyruyfufuf","fffffjhgkj" ,  "000",  "56366586");
		Rp.submit();
	}
	
	@Test(priority=6)
	public void testInValidLogin() {
		hp.navToLoginPage();
		lp.login("dev5@gmail.com", "xyzabc");
        assertTrue(isElementPresent(Rp.butn_Create));
			
		}
	}
	
	

