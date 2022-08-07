package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resources.Base;

public class TestThree extends Base {	
	
	public WebDriver driver;
	@Test
	public void testthreemethod() throws InterruptedException, IOException {
		
		System.out.println("Inside Test three");
		
		driver = initializeDriver();
		 
		driver.get("http://tutorialsninja.com/demo");
				
		Thread.sleep(2000);
		
		driver.close();
		
		
	}

}
