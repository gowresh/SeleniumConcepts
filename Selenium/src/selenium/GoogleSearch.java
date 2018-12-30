package selenium;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class GoogleSearch {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Eclipse\\workspace\\Selenium\\EXE\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();		
		driver.manage().deleteAllCookies();
			
		driver.get("https://www.google.com/");
		
		//Page to completely load
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);	
		//To wait for elements before throwing exception 
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.name("q")).sendKeys("Java");
		
		List<WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']/li/descendant::div[@role='option']/div/span"));
		System.out.println("Number of suggestions "+list.size());
		
		for(int i = 0; i < list.size(); i++){
			if(list.get(i).getText().contains("java tutorial"));
			{
				list.get(i).click();
				break;
			}
		}
		
		
		

	}

}
