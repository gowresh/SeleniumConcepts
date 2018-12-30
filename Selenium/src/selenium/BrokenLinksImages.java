package selenium;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinksImages {

	public static void main(String[] args) throws InterruptedException, MalformedURLException, IOException {
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
			
			//1. Get all the links and images
			List<WebElement> linksList = driver.findElements(By.tagName("a"));
			linksList.addAll(driver.findElements(By.tagName("img")));
			
			System.out.println("# of links and images = "+linksList.size());
			
			ArrayList<WebElement> activeList = new ArrayList<WebElement>();
			
			//2. Exclude all the links and images which do not have href
			for(int i = 0; i < linksList.size(); i++) {
				
				String href = linksList.get(i).getAttribute("href");
				boolean httplinks = false;
				if(href != null) {
					 httplinks = linksList.get(i).getAttribute("href").startsWith("http");
				}
				
				if(href != null && httplinks ) {
					activeList.add(linksList.get(i));
				}
			}
			
			System.out.println("# of Active links and images = "+activeList.size());
			
			//3. Check the Url with HTTPConnection api
			for(int i = 0; i < activeList.size(); i ++) {
				
				HttpURLConnection connection = (HttpURLConnection)new URL(activeList.get(i).getAttribute("href")).openConnection();
				String message = connection.getResponseMessage();
				System.out.println(activeList.get(i).getAttribute("href")+"----->"+message);
			}

	}

}
