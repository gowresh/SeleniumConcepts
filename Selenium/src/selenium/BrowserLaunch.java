package selenium;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;



public class BrowserLaunch {

	public static void main(String[] args) {
		
		//FireFox				
		System.setProperty("webdriver.gecko.driver", "C:\\Eclipse\\workspace\\Selenium\\EXE\\geckodriver.exe");
		WebDriver firefoxDriver = new FirefoxDriver();		
		firefoxDriver.get("http://www.google.com");
		System.out.println(firefoxDriver.getTitle());
		System.out.println(firefoxDriver.getCurrentUrl());
		//System.out.println(firefoxDriver.getPageSource());
		firefoxDriver.quit();
		
		
		//Chrome
		System.setProperty("webdriver.chrome.driver", "C:\\Eclipse\\workspace\\Selenium\\EXE\\chromedriver.exe");
		WebDriver chromeDriver = new ChromeDriver();
		chromeDriver.get("http://www.google.com");
		System.out.println(chromeDriver.getTitle());
		System.out.println(chromeDriver.getCurrentUrl());
		//System.out.println(chromeDriver.getPageSource());
		chromeDriver.quit();
		
		
		//Safari
		WebDriver safariDriver = new SafariDriver();
		safariDriver.get("http://www.google.com");
		safariDriver.get("http://www.google.com");
		System.out.println(safariDriver.getTitle());
		System.out.println(safariDriver.getCurrentUrl());
		safariDriver.quit();
		

	}

}
