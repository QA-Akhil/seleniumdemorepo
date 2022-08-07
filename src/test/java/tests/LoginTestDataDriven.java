package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.AccountPage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resources.Base;

public class LoginTestDataDriven extends Base {

	public WebDriver driver;

	// Connecting data provider with the test method
	@Test(dataProvider = "getLoginData")

	// Here we have to create three parameters for the three input values from the
	// getLoginData data provider
	public void login(String email, String password, String expectedStatus) throws IOException, InterruptedException {

		// Creating an object for landing page in the LoginTest test case to call the
		// constructor Landing page

		LandingPage landingpage = new LandingPage(driver);
		Thread.sleep(3000);
		landingpage.myaccountdd().click();
		landingpage.loginbtn().click();

		// For Login using the Login Page objects

		LoginPage login = new LoginPage(driver);
		login.email().sendKeys(email);// dataprovider parameter email
		login.password().sendKeys(password); // dataprovider parameter password
		login.userloginbtn().click();

		// Verifying whether we have logged in properly

		AccountPage account = new AccountPage(driver);

		// Asserting whether Edit your account information is displayed to check if we
		// have logged in properly

		// Assert.assertTrue(account.edityourinfolink().isDisplayed());

		String actualResult = null;

		try {

			if (account.edityourinfolink().isDisplayed())

				actualResult = "Success";

			Assert.assertEquals(actualResult, expectedStatus);

		} catch (Exception e) {

		}

	}

	@BeforeMethod
	public void openApplication() throws IOException {

		driver = initializeDriver(); // We are directly calling the initializeDriver method of the base class
		driver.get(prop.getProperty("url")); // now we are getting url also from the properties file
	}

	@AfterMethod

	public void tearDown() {

		driver.close();
	}

	// Data Driven

	@DataProvider

	public Object[][] getLoginData() {

		Object[][] data = { { "arun.selenium@gmail.com", "Second@123", "Success" },
				{ "dummy@gmail.com", "abcd@123", "Failure" } };
		return data;

	}
}
