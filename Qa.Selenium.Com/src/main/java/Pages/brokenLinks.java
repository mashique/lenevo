package Pages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class brokenLinks {
	
	@Test
	public void brokenLink() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.co.in/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		List<WebElement> links=driver.findElements(By.tagName("a"));
		
		for(WebElement lnk : links)
		{
			String ul= lnk.getAttribute("href");
			URL  url = new URL(ul);
			
			HttpURLConnection httpConn= (HttpURLConnection) url.openConnection();
			
			Thread.sleep(2000);
			int respCode= httpConn.getResponseCode();
			
			if(respCode>=400)
			{
				System.out.println(ul + " Borken Link  " + "-->Response Code " + respCode  );
			}
			else
			{
				System.out.println(ul + " Non Borken Link  " + "-->Response Code " + respCode );
			}
			
		}
		
		System.out.println("Total Number of Links " +links.size());
		
		driver.quit();
		
	}

}
