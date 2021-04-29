package com.test;

import org.testng.annotations.Test;

public class ChkGroups {
	
	@Test(groups="G1")
	public void Method1()
	{
		System.out.println("Method1");
	}

	@Test(groups="G2")
	public void Method2()
	{
		System.out.println("Method2");
	}
	@Test(groups="G2")
	public void Method3()
	{
		System.out.println("Method3");
	}
	@Test(groups="G1")
	public void Method4()
	{
		System.out.println("Method4");
	}
	@Test
	public void Method5()
	{
		System.out.println("Method5");
	}
}
