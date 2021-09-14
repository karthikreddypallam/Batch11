package com.ap.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ap.pages.CartPage;
import com.ap.pages.HomePage;
import com.ap.pages.LoginPage;

public class CartTest extends BaseTest {

	CartPage cp =null; 	
	LoginPage lp=null;
	HomePage hp=null;
	
	@BeforeMethod
	public void init() {
		cp =new CartPage(driver);
		hp=new HomePage(driver);
		lp =new LoginPage(driver);
		
	}
	@Test
	public void Testwishlist() {
		hp.navToLoginPage();
		lp.login("dem7@gmail.com", "xyzabc" );
		sleep();
		cp.NavToWishlist();
		cp.SelecttoWishlist();
		sleep();
		cp.AddToCart();
		cp.navtoCheckout();
	}	
				
	

}
