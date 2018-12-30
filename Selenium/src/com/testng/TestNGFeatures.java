package com.testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGFeatures {

	
	//dependsOnMethods execute only after Test2 method and Test2 method should be passed else it will skip
	@Test(dependsOnMethods="Test2")
	public void Test1() {
		System.out.println("Test1");
	}
	
	public void Test2() {
		System.out.println("Test2");
		Assert.fail();
	}
	

	@Test(dependsOnMethods="Test1")
	public void Test3() {
		System.out.println("Test3");
	}
	


	@Test()
	public void Test4() {
		System.out.println("Test4");
	}
	


	
}
