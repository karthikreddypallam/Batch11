package com.ap.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
private WebDriver driver = null;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="email")
	public WebElement txtFld_EmailAddress;
	
	@FindBy(id="passwd")
	public WebElement txtFld_Password;
	
	@FindBy(xpath="//button[@id='SubmitLogin']")
	public WebElement btn_Submit;
	
	public void login(String userName,String password) {
		txtFld_EmailAddress.sendKeys(userName);
		txtFld_Password.sendKeys(password);
		btn_Submit.click();
	}

}
