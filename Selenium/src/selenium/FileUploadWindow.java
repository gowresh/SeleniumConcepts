package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadWindow {

	public static void main(String[] args) {	
		System.setProperty("webdriver.chrome.driver", "C:\\Eclipse\\workspace\\Selenium\\EXE\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://html.com/input-type-file/");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("fileupload")).sendKeys("C:\\Users\\gnagesh\\Desktop\\DP.png");;
		

	}

}
