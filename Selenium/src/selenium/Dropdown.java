package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;



public class Dropdown {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Eclipse\\workspace\\Selenium\\EXE\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://scgi.half.ebay.com/ws/eBayISAPI.dll?RegisterEnterInfo&usage=2943&ru");
		driver.manage().window().maximize();
		
		
		Select select = new Select(driver.findElement(By.id("state")));
		List<WebElement>options = select.getOptions();
		
		
		//To get all options
		for(WebElement option : options){
			System.out.println(option.getText());
		}
		
		select.selectByVisibleText("Colorado");

	}

}
