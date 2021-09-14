package com.ap.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	private WebDriver driver = null;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Sign in')]")
	public WebElement btn_signIn;
	
	@FindBy(xpath="//a[contains(text(),'Sign out')]")
	public WebElement btn_signout;
	
	public void navToLoginPage() {
		btn_signIn.click();
	}
	
	public void signOut() {
		btn_signout.click();
	}

}
