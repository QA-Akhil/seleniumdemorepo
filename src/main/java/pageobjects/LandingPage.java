package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

	WebDriver driver;

	public LandingPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@title='My Account']")
	WebElement myaccountdd;

	@FindBy(linkText = "Login")
	WebElement loginbtn;

	// We have to return the web Element to be used by the test class

	public WebElement myaccountdd() {

		return myaccountdd;
	}

	public WebElement loginbtn() {

		return loginbtn;

	}

}
