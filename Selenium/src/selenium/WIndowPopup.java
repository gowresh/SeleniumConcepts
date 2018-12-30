package selenium;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WIndowPopup {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Eclipse\\workspace\\Selenium\\EXE\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();		
		driver.manage().deleteAllCookies();
			
		//driver.get("http://popuptest.com/goodpopups.html");
		driver.get("http://popuptest.com/");
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//driver.findElement(By.className("black")).click();
		driver.findElement(By.linkText("Multi-PopUp Test")).click();
		
		//Close all the child window 
		String parentTitle = driver.getWindowHandle(); 
		System.out.println("Parent Window - "+parentTitle);
		System.out.println("Parent Window Title is "+driver.getTitle());
		
		Set<String> windows = driver.getWindowHandles();
		
		System.out.println("Number of windows opened are "+(windows.size() -1));
		Iterator<String> iterator = windows.iterator();
		
		while(iterator.hasNext()) {
			String window = iterator.next();
			if(!window.equalsIgnoreCase(parentTitle)) {
				driver.switchTo().window(window);
				System.out.println("Child Window "+window);
				System.out.println("Child Window Title is "+driver.getTitle());
				driver.close();				
			}
		}
		
		driver.switchTo().window(parentTitle);
		driver.quit();
		

	}

}
