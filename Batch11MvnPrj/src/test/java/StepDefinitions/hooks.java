package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import utils.Iconstants;

public class hooks {
	
	public static WebDriver driver = null;
	@Before
	public void setupBrowser() {
		System.setProperty("webdriver.chrome.driver",Iconstants.chromeDriverPath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://automationpractice.com/index.php");
	}
	
	
	@After
	public void quitBrowser() {
		driver.quit();
	}
	
	public static String getTitle() {
		return driver.getTitle();
	}
	

}
