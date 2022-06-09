package Pages;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HomePage {
	
	@Test
	public void homePage() throws IOException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.co.in/");
		
		Reporter.log("Using Chrome browser for this Test");
		System.out.println("delete this line ");
		
		TakesScreenshot tsc= (TakesScreenshot)driver;
		File img =tsc.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(img, new File("C:\\Users\\Lenovo\\eclipse-workspace\\Qa.Selenium.Com\\ScreenShot\\test.png"));
		org.openqa.selenium.io.FileHandler.copy(img, new File(".\\ScreenShot\\test1.png"));
		Assert.assertTrue(false);
		driver.close();
	}
	
	@Test(dependsOnMethods = "homePage")
	public void secondPage()
	{
		System.out.println("Second page");
	}
	
	

}
