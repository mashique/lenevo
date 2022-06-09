package Pages;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.apache.hc.core5.util.Timeout;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class selenium {
	
	@Test (enabled = false)
	public void demo()
	{
		WebDriverManager.chromedriver().setup();
//		ChromeOptions op= new ChromeOptions();
//		op.addArguments("headless");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.co.in/");
		System.out.println(driver.getTitle());
		
		driver.switchTo().newWindow(WindowType.TAB).get("https://www.flipkart.com/");	
		driver.switchTo().newWindow(WindowType.WINDOW).get("https://www.amazon.in/");
		
		String current= driver.getWindowHandle();
		
		System.out.println(driver.getTitle());
		
		Set<String> wind = driver.getWindowHandles();
		
		for(String st : wind)
		{
			System.out.println(st);
			System.out.println(driver.switchTo().window(st).getTitle());
		}
		
	
	}
	
	
	@Test (enabled = false)
	public void waitt()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.co.in/");
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.visibilityOf(null)).submit();
		
		WebElement we= driver.findElement(By.xpath("//input[@name='q']"));
		
		Actions ac= new Actions(driver);
		ac.contextClick(we).perform();
		//ac.doubleClick().perform();
		
		
		
		
	}
	
	
	@Test (expectedExceptions = NoSuchElementException.class , enabled=false)
	public void addEle()
	{
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
		driver.findElement(By.xpath("//button[text()='Add Element']")).click();
		driver.findElement(By.xpath("//button[@onclick='addElement()']")).click();
		
		
	}
	
	@Test(enabled =false)
	public void javaScript()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.co.in/");
		JavascriptExecutor js= (JavascriptExecutor)driver;
		
		WebElement wb= driver.findElement(By.name("q"));
		js.executeScript("arguments[0].value='Automation'", wb);
				
	}
	
	@Test
	public void alertTest() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/delete_customer.php");
		driver.findElement(By.name("cusid")).sendKeys("1234");
		driver.findElement(By.name("submit")).submit();
		
		Thread.sleep(1230);

		String txt=driver.switchTo().alert().getText();
		System.out.println(txt);
		
		driver.switchTo().alert().accept();	
		
		
	}
	
	@Test(enabled =false)
	public void windAuth(){
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		
	}

	@Test(enabled =false)
	public void brokenlinks() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/status_codes");
		driver.manage().window().maximize();
		
		List<WebElement> links= driver.findElements(By.tagName("a"));
		
		for(WebElement link : links)
		{
			String ul = link.getAttribute("href");
			
			URL url= new URL(ul);
			
			HttpURLConnection httpConn= (HttpURLConnection) url.openConnection();
			
			httpConn.connect();
			
			Thread.sleep(2000);
			
			int respCode = httpConn.getResponseCode();
			
			if(respCode >= 400)
			{
				System.out.println(url +" Is borken link "  + "Response Code :" + respCode);
			}
			else
			{
				System.out.println(url +" Is not borken link "  + "Response Code :" + respCode);
			}
		}
		
		System.out.println("Total number of links  " + links.size());
		
		
	}

}
