package Pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class softAssert {
	
	@Test (enabled=false)
	public void login()
	{
		
		 WebDriverManager.chromedriver().capabilities(null).setup();
		 WebDriver driver = new ChromeDriver();
		 
		 driver.get("https://www.google.co.in/"); 
		  
		  SoftAssert sft= new SoftAssert(); sft.assertEquals("Googgle", driver.getTitle());
		 
		  driver.quit();
		  sft.assertAll();
		 
	}
	
	@Test
	public void links()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.navigate().to("https://www.google.co.in/");
		driver.manage().window().maximize();
		
		
		//List<WebElement> wb = driver.findElements(By.xpath(".//a[@href]"));
		
		List<WebElement> wb = driver.findElements(By.tagName("a"));
		
		for(WebElement link : wb)
		{
			System.out.println(link.getAttribute("href"));
		}
		
		driver.quit();
		
	}

}
