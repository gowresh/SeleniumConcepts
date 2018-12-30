package selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElements {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Eclipse\\workspace\\Selenium\\EXE\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();		
		driver.manage().deleteAllCookies();
		
		driver.get("https://www.ebay.com/");
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		if(links.size() < 1) {
			System.out.println("No Links");
		}else {
			System.out.println("# of Links : "+links.size());
			
			for(WebElement link : links) {
				System.out.println(link.getText());
			}
		}

	}

}
