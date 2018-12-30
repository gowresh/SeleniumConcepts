package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClass {

	public static void main(String[] args) throws InterruptedException {
		//MouseMovementConcept
		
		System.setProperty("webdriver.chrome.driver", "C:\\Eclipse\\workspace\\Selenium\\EXE\\chromedriver.exe");
		
		//MouseHoverAndClick();
		DragAndDrop();
			

	}
	
	public static void MouseHoverAndClick() throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.id("highlight-addons"))).build().perform();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"header-addons\"]/ul/li[2]/a")).click();
		
		driver.quit();
		
	}
	
	public static void DragAndDrop() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		Thread.sleep(3000);
		
		driver.switchTo().frame(0);
		Actions action = new Actions(driver);
		action.dragAndDrop(driver.findElement(By.id("draggable")), driver.findElement(By.id("droppable"))).build().perform();
		Thread.sleep(5000);
		
		driver.quit();
		
	}

}
