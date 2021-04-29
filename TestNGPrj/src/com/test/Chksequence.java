package com.test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.FindBys;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Chksequence {
	
	WebDriver driver;
	@BeforeMethod
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "c:\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("https://google.com");
	}
	
	@Test(priority=-1)
	public void ChkGoogle() {
		String PageTitle = driver.getTitle();
		System.out.println(PageTitle);
		Assert.assertEquals(PageTitle, "Google", "Wrong Title");
	}
	
	@Test(priority=0, enabled=true)
	public void GoogleLogoTest()
	{
		//@FindBy(xpath="//*[@id=\\\"logo\\\"]")
		//public WebElement logo;
		boolean b = driver.findElement(By.xpath("//*[@id=\"logo\"]")).isDisplayed();
		System.out.println(b);
	}
	
	@Test(priority=-2)
	public void GmailLinkTest()
	{
		boolean b = driver.findElement(By.linkText("Gmail")).isDisplayed();
		System.out.println(b);
	}
	
	@AfterMethod
	public void teardown() {
		driver.close();
	}
	

}
