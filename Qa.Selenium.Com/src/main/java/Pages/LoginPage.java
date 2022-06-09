package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPage {
	
	
	@Test(priority=1)
	public void login()
	{
		/*
		 * WebDriverManager.chromedriver().capabilities(null).setup(); WebDriver driver
		 * = new ChromeDriver();
		 * 
		 * driver.get("https://www.google.co.in/"); //Assert.assertEquals("Google",
		 * driver.getTitle());
		 * 
		 * SoftAssert sft= new SoftAssert(); sft.assertEquals("Google",
		 * driver.getTitle()); System.out.println("Executed"); driver.quit();
		 */
		
		System.out.println("login page");
	}
	
	@Test(priority=-1 , groups ="UAT")
	public void signUp()
	{
		System.out.println("sign up page");
		Assert.assertTrue(2<5);
	}
	
	@Test(priority=-2 , groups ="UAT")
	public void register()
	{
		System.out.println("Register");	
	}
	
	@Test(priority=0 , invocationCount=10, timeOut = 0)
	public void logOut()
	{
		System.out.println("LogOut pagge");
	}
	
	@Test(priority=-3 , dependsOnMethods ="register")
	public void home()
	{
		System.out.println("Home page");
	}
	
	@Test(priority=3 , groups ="UAT", enabled=true)
	public void about()
	{
		System.out.println("About page");
	}

}
