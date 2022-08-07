package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resources.Base;

public class TestTwo extends Base  {
	
	
	public WebDriver driver;
	@Test
	
	public void testtwomethod() throws IOException, InterruptedException {
		System.out.println("Inside test two");
		 
		 driver = initializeDriver();
		 
		driver.get("http://tutorialsninja.com/demo");
				
		Thread.sleep(2000);
		
		driver.close();
		
	}

}
