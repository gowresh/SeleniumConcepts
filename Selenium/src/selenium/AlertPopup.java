package selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertPopup {

	public static void main(String[] args) {
			
		System.setProperty("webdriver.chrome.driver", "C:\\Eclipse\\workspace\\Selenium\\EXE\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.rediff.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.linkText("Sign in")).click();
		
		driver.findElement(By.name("proceed")).click();
		
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.hashCode());
		System.out.println(alert.toString());
		System.out.println(alert.getText());
		alert.accept();
		

	}

}
