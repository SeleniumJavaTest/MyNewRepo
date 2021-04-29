package com.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class halfEbayTest {
	WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "c:\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get("https://www.ebay.com/");
	}
	
	
	
	@Test
	public void searchText() throws InterruptedException
	{
		Select ddlcat = new Select(driver.findElement(By.id("gh-cat")));
		ddlcat.selectByValue("2984");
		
		WebElement txtsearch = driver.findElement(By.id("gh-ac"));
		txtsearch.clear();
		txtsearch.sendKeys("toy");
		Thread.sleep(5000);
		List<WebElement> alist = driver.findElements(By.xpath("//a[@class='ghAC_sugg ui-corner-all']"));
		System.out.println(alist.size());
		for(WebElement a:alist)
		{
			//System.out.println(a.getText());
			if(a.getText().equalsIgnoreCase("toys"))
			{
				System.out.println("Record Found");
				a.click();
				break;
			}
		}
		
	}
	
	
	
	@AfterMethod
	public void tearDown()
	{
		//driver.quit();
	}

}
