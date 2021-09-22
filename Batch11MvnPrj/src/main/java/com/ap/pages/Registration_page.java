package com.ap.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Registration_page {
	
public WebDriver driver= null;
	
	public Registration_page(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class='navigation_page']")
	public WebElement check_submit;

	@FindBy(xpath="//input[@name='email_create']")
	public WebElement Email_submit;
	
	@FindBy(xpath="//button[contains(@class,' button-medium')]")
	public WebElement butn_Create;
	

	@FindBy(xpath="//input[@id='customer_firstname']")
	public WebElement txtFld_Firstname;
	
	@FindBy(xpath="//input[@id='customer_lastname']")
	public WebElement txtFld_lastname;
	
	@FindBy(xpath="//input[@id='passwd']")
	public WebElement txtFld_password;
	
	@FindBy(xpath="//input[@id='address1']")
	public WebElement txtFld_address;
	
	
	@FindBy(xpath="//input[@id='city']")
	public WebElement txtFld_city;
	
	@FindBy(xpath="//select[@id='id_state']")
	public WebElement txtFld_state;
	
	@FindBy(xpath="//input[@id='postcode']")
	public WebElement txtFld_zipcode;
	
	@FindBy(xpath="//div[@id='uniform-id_country']")
	public WebElement txtFld_country;
	
	@FindBy(xpath="//input[@id='phone_mobile']")
	public WebElement txtFld_phonenumber;
	
	@FindBy(xpath="//button[@id='submitAccount']")
	public WebElement btn_submit;
	
	public void CreateEmailId(String Emailaddress ){
		Email_submit.sendKeys(Emailaddress);
		
		
	}
	public void click() {
		butn_Create.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void Fillapplication(String firstname,String lastname,String passwrd,String address,String city,
			String Zip,String pnm)
	{
		txtFld_Firstname.sendKeys(firstname);
		
		txtFld_lastname.sendKeys(lastname);
		
		txtFld_password.sendKeys(passwrd);
		txtFld_address.sendKeys(address);
		txtFld_city.sendKeys(city);
		Select select=new Select(txtFld_state);
		select.selectByValue("3");
		txtFld_zipcode.sendKeys(Zip);
		txtFld_phonenumber.sendKeys(pnm);
		
	}
	
	

	public void submit() {
		btn_submit.click();
	}

}
