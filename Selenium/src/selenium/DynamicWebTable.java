package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicWebTable {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Eclipse\\workspace\\Selenium\\EXE\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();		
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://www.freecrm.com/index.html");
		
		driver.findElement(By.name("username")).sendKeys("gowreshn04");
		driver.findElement(By.name("password")).sendKeys("9880562207");
		driver.findElement(By.xpath("//input[@type='submit']")).submit();
			
		driver.switchTo().frame("mainpanel");
		driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
		
		
		//Method 1 :
		//*[@id='vContactsForm']/table/tbody/tr[4]/td[2]/a
		String beforeXpath = "//*[@id='vContactsForm']/table/tbody/tr[";
		String afterXpath = "]/td[2]/a";
		
		for(int i = 4; i <8 ; i++ ) {
			if(driver.findElement(By.xpath(beforeXpath + i + afterXpath)).getText().contains("User One") ){
				driver.findElement(By.xpath(beforeXpath+i+"]/td[1]/input")).click();
			}
		}
		
		//Method 2 :
		driver.findElement(By.xpath("//a[contains(text(),'User Two')]/parent::td//preceding-sibling::td//input")).click();

	}

}
