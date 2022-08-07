package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import resources.Base;

public class TestFour extends Base {	
	
	public WebDriver driver;
	
	@Test
	public void testfourmethod() throws IOException, InterruptedException {
		
		System.out.println("Inside test four");
		
	    driver = initializeDriver();
		 
		driver.get("http://tutorialsninja.com/demo");
				
		Thread.sleep(2000);
		
		Assert.assertTrue(false);
		
		driver.close();
	}

	@AfterMethod
	
	public void tearDown() {
		
		driver.close();
		
	}
}
