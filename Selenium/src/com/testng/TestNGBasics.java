package com.testng;


import org.testng.annotations.*;;

public class TestNGBasics {
	
	@BeforeSuite
	public void BeforeSuite() {
		System.out.println("@BeforeSuite");
	}
	
	@BeforeTest
	public void BeforeTest() {
		System.out.println("@BeforeTest");
	}
	
		
	@BeforeClass
	public void BeforeClass() {
		System.out.println("@BeforeClass");
	}
	
	
	
	@BeforeMethod
	public void BeforeMethod() {
		System.out.println("@BeforeMethod");
	}
	
	
	//Priority , Groups
	@Test(priority=1,groups="User")
	public void Test1() {
		System.out.println("@Test1");
	}
	
	
	@Test(priority=2, groups="User")
	public void Test2() {
		System.out.println("@Test2");
	}
	
	@Test(priority=3, groups="Main")
	public void Test3() {
		System.out.println("@Test3");
	}
	
	@Test(priority=4, groups="Main")
	public void Test4() {
		System.out.println("@Test4");
	}
	
	
	
	
	
	@AfterMethod
	public void AfterMethod() {
		System.out.println("@AfterMethod");
	}
	
	@AfterTest
	public void AfterTest() {
		System.out.println("@AfterTest");
	}
	
	
	@AfterClass()
	public void AfterClas() {
		System.out.println("@AfterClass");
	}
	
	@AfterSuite
	public void AfterSuite() {
		System.out.println("@AfterSuite()");
	}
	
	
	

}
