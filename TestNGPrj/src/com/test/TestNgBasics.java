package com.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNgBasics 
{
	@BeforeSuite
	public void setup()
	{
		System.out.println("setup System for chrome");
	}
	@BeforeTest
	public void LaunchBrowser()
	{
		System.out.println("Launching Chrome Browser");
		
	}
	@BeforeClass
	public void login()
	{
		System.out.println("Login method");
	}
	@BeforeMethod
	public void EnterUrl() 
	{
		System.out.println("Enter Url");
	}
	
	@Test
	public void googleTitletest()
	{
		System.out.println("Google title test");
	}
	
	@Test
	public void searchtest()
	{
		System.out.println("Printing search");
	}
	
	@Test
	public void myTestMethod()
	{
		System.out.println("This is new Test Method");
	}
	@AfterMethod
	public void Logout()
	{
		System.out.println("U have been Logged out");
	}
	
	@AfterTest
	public void Deleteallcookies()
	{
		System.out.println("Delete all cookies");
	}
	@AfterClass
	public void CloseBrowser()
	{
		System.out.println("Close Browser");
	}
	@AfterSuite
	public void generateTestreport()
	{
		System.out.println("Generating reports");
	}
}

