package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomXPath {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Eclipse\\workspace\\Selenium\\EXE\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();		
		driver.manage().deleteAllCookies();
		
		driver.get("https://www.ebay.com/");
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Java");
		driver.findElement(By.xpath("//input[contains(@type,'text')]")).sendKeys("Java");		
		driver.findElement(By.xpath("//input[contains(text(),'text')]")).sendKeys("Java");
		driver.findElement(By.xpath("//input[starts-with(@type,'text_')]")).sendKeys("Java");
		driver.findElement(By.xpath("//input[ends-with(@type,'_text')]")).sendKeys("Java");
		
		driver.findElement(By.xpath("//a[text()='Features']")).click();
		

	}

}
