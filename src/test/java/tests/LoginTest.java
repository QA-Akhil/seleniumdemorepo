package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import pageobjects.AccountPage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resources.Base;

public class LoginTest extends Base {
	
	WebDriver driver;
	
	@Test
	public void login() throws IOException {
		
	    driver = initializeDriver();  //We are directly calling the initializeDriver method of the base class 
		driver.get(prop.getProperty("url")); // now we are getting url also from the properties file
		
		//Creating an object for landing page in the LoginTest test case to call the constructor Landing page
		
		LandingPage landingpage = new LandingPage(driver);
		landingpage.myaccountdd().click();
		landingpage.loginbtn().click();
		
		//For Login using the Login Page objects 
		
		LoginPage login = new LoginPage(driver);
		login.email().sendKeys(prop.getProperty("email"));
		login.password().sendKeys(prop.getProperty("password"));
		login.userloginbtn().click();
		
		//Verifying whether we have logged in properly
		
		AccountPage account = new AccountPage(driver);
		
		// Asserting whether Edit your account information is displayed to check if we have logged in properly
		
		Assert.assertTrue(account.edityourinfolink().isDisplayed());
				
	}

	@AfterMethod
	
	public void tearDown() {
		
		driver.close();
		
	}
}
