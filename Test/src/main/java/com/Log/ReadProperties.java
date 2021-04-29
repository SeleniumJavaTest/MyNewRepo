package com.Log;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class ReadProperties {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		WebDriver driver = null;
		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream("C:\\Users\\prasa\\eclipse-workspace\\Test\\Config.properties");
		
		prop.load(ip);
		
		String BrowerName = prop.getProperty("Browser");
		System.out.println(BrowerName);
		
		if(BrowerName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","c:\\Selenium\\chromedriver.exe");
			driver = new ChromeDriver();
			
		}
		else if (BrowerName.equals("FF")) {
		//	System.setProperty("webdriver.chrome.driver","c:\\Selenium\\chromedriver.exe");
			driver = new FirefoxDriver();
		}
		else if (BrowerName.equals("safari")) {
			//	System.setProperty("webdriver.chrome.driver","c:\\Selenium\\chromedriver.exe");
				driver = new SafariDriver();
			}
		else if (BrowerName.equals("IE")) {
			//	System.setProperty("webdriver.chrome.driver","c:\\Selenium\\chromedriver.exe");
				driver = new InternetExplorerDriver();
			}
		else
			System.out.println("No browser value is given");
		
		System.out.println(prop.getProperty("url"));
		driver.get(prop.getProperty("url"));

		//driver.findElement(By.)
	}

}
