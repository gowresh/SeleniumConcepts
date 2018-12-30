package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frames {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Eclipse\\workspace\\Selenium\\EXE\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();		
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://www.freecrm.com/index.html");
		
		driver.findElement(By.name("username")).sendKeys("gowreshn04");
		driver.findElement(By.name("password")).sendKeys("9880562207");
		driver.findElement(By.className("btn")).submit();

		Thread.sleep(5000);
		
		driver.switchTo().frame("mainpanel");
		driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
		
		driver.switchTo().defaultContent();
		
		
	}

}
