package com.testng;

import org.testng.annotations.*;;

public class InvocationCountTest {

	//to run the test n number of times use invocationCount
	@Test(invocationCount=2)
	public void Test() {
		System.out.println("Test");
	}
	
	
	//invocationTimeOut=2000 to terminate the infinite loop
	@Test(timeOut=2000)
	public void infinitLoopTest() {
		int i = 1;
		while(i==1) {
			System.out.println(i);
		}
	}
	
	//We are expecting this exception but run the test
	@Test(expectedExceptions=NumberFormatException.class)
	public void Exception() {
		String x  = "100x";
		Integer.parseInt(x);
	}
	
	
	
	
}
