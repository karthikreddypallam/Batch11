package com.ap.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import utils.ConfigReader;
import utils.Iconstants;

public class BaseTest {

	public WebDriver driver = null;
	ConfigReader cfgRdr = null;
	public static ExtentHtmlReporter htmlReporter = null;
	public static ExtentReports reports = null;
	public static ExtentTest test;
	
	@BeforeSuite
	public void beforeSuite() {
		htmlReporter = new ExtentHtmlReporter("AutomationPractice.html");
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);
		cfgRdr = new ConfigReader();
		cfgRdr.readConfig();
	}

	@BeforeTest
	public void launchBrowser() {
		String browser = cfgRdr.getBrowser();
		if(browser.equalsIgnoreCase("chrome"))
			openChrome();
		else if(browser.equalsIgnoreCase("firefox"))
			openFirefox();
		
		driver.get(cfgRdr.getURL()); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void openChrome() {
		System.setProperty("webdriver.chrome.driver", Iconstants.chromeDriverPath);
		driver = new ChromeDriver();
	}

	public void openIE() {
		System.setProperty("webdriver.ie.driver", Iconstants.ieDriverPath);
		driver = new InternetExplorerDriver();
	}
	
	public void openFirefox() {
		System.setProperty("webdriver.gecko.driver", Iconstants.firefoxDriverPath);
		driver = new FirefoxDriver();
	}

	public boolean isElementPresent(WebElement ele) {
		boolean elePresent = false;

		try {
			if(ele.isDisplayed()&& ele.isEnabled())
				elePresent = true;
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

		return elePresent;
	}

	@AfterTest
	public void terminate() {
		driver.quit();
	}

	public void sleep() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterSuite
	public void aftersuite() {
		reports.flush();
	}


}
