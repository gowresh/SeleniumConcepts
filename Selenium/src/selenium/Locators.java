package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Eclipse\\workspace\\Selenium\\EXE\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://scgi.half.ebay.com/ws/eBayISAPI.dll?RegisterEnterInfo&usage=2943&ru");
		driver.manage().window().maximize();
		
		//8 locators 
		
		//id
		driver.findElement(By.id("firstname")).sendKeys("id");;		
		
		//name
		driver.findElement(By.name("lastname")).sendKeys("name");;
	
		//xpath
		driver.findElement(By.xpath("//input[@name='address1']")).sendKeys("xpath");
		
		//CSS selector
		driver.findElement(By.cssSelector("#city")).sendKeys("css");
		
		//Class Name
		driver.findElement(By.className("btn")).click();;
				
		//Tag Name
		driver.findElement(By.tagName("a"));
								
		//LinkText
		driver.findElement(By.linkText("Sign in")).click();		
		driver.navigate().back();
		
		//Partial Link Text
		driver.findElement(By.partialLinkText("Want to register")).click();
		driver.navigate().back();
		
		
	

	}

}
