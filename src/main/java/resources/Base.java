package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	// Method for initializing the browser driver

	WebDriver driver; // Made global for access to all
	
	public Properties prop; // Making it public for other classes to access

	@SuppressWarnings("deprecation")
	public WebDriver initializeDriver() throws IOException {

		// Instead of hard coding the browser names, we can add them in a properties file
		
		prop = new Properties(); //Creating an object for the properties.
		
		String propPath = System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties"; //Path to the properties file
		
		FileInputStream fis = new FileInputStream(propPath); // Adding the path to file input stream
				
		prop.load(fis); //Loading the file
 
		String browserName = prop.getProperty("browser");  

		// equalsignoreCase will ignore the upper/lower case
		// Based on the conditions relevant browser will be initialized

		if (browserName.equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;
	}
  
	public void takescreenshot(String testName,WebDriver driver) throws IOException {
		
		File SourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String DestinationPath = System.getProperty("user.dir")+"\\Screenshots\\"+testName+".png";
		FileUtils.copyFile(SourceFile, new File(DestinationPath));
	}
}
