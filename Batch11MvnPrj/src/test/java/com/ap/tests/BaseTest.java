package com.ap.tests;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.ap.pages.HomePage;
import com.ap.pages.LoginPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import utils.ConfigReader;
import utils.Iconstants;

public class BaseTest {
	
	private static Logger logger = Logger.getLogger(BaseTest.class);

	public WebDriver driver = null;
	ConfigReader cfgRdr = null;
	public static ExtentHtmlReporter htmlReporter = null;
	public static ExtentReports reports = null;
	public static ExtentTest test;
	
	LoginPage lp = null;
	HomePage hp = null;
	
	@BeforeMethod
	public void init(ITestResult result) {
		logger.info("Creating Extent Reports");
		test = reports.createTest(result.getMethod().getMethodName());
		hp = new HomePage(driver);
		lp = new LoginPage(driver);
		test.info("Browser Launched");
		logger.info("Browser Launched");

		test.info("Launched Home Page");
		logger.info("Launched Home Page");

	}
	
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
	
	public void openEdge() {
		System.setProperty("webdriver.edge.driver", Iconstants.edgeDriverPath);
		driver = new EdgeDriver();
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

	
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws Exception {
		
		if(result.getStatus() == ITestResult.SUCCESS) {
			System.out.println(result.getMethod().getMethodName()+" ==> Pass");
			test.pass(result.getMethod().getMethodName()+" Success");
		}
			
		else if(result.getStatus() == ITestResult.FAILURE){
			test.fail(result.getMethod().getMethodName()+" failed");
			test.fail(result.getThrowable(), MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot(result.getMethod().getMethodName()+".png")).build());

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

	@AfterSuite
	public void aftersuite() {
		reports.flush();
	}
	
	public String getScreenshot(String screenshotName) throws Exception {
		//below line is just to append the date format with the screenshot name to avoid duplicate names 
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		//after execution, you could see a folder "FailedTestsScreenshots" under src folder
		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/"+screenshotName+dateName+".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		//Returns the captured file path
		return destination;
	}

	
	public void sleep() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
