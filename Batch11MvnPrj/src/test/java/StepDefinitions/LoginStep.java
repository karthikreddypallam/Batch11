package StepDefinitions;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;

import com.ap.pages.HomePage;
import com.ap.pages.LoginPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStep {
	
	LoginPage loginPage = new LoginPage(hooks.driver);
	HomePage homePage = new HomePage(hooks.driver);
	
	@Given("^user navigates to the Login page$")
	public void user_navigates_to_the_Login_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		homePage.navToLoginPage();
	}

	@When("^user enters username as \"(.*?)\" and password as \"(.*?)\"$")
	public void user_enters_username_as_and_password_as(String user, String pass) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		loginPage.login(user, pass);
	}

	@Then("^verify user is Logged in$")
	public void verify_user_is_Logged_in() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		assertTrue(isElementPresent(loginPage.btn_Submit));
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


}
