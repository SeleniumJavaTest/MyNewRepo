package com.test;

import org.testng.annotations.Test;

public class ChkDependsOn {
	
	@Test
	public void method1()
	{
		System.out.println("Method1:");
		int j=7/0;
		System.out.println(j);
	}
	
	@Test(dependsOnMethods = {"method1"})
	public void method2() {
		System.out.println("Method2");
	}

	
	//method2 will be executed only if method 1 is passed ow it will be skipped
}
