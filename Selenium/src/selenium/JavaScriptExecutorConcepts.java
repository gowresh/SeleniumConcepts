package selenium;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutorConcepts {

	public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Eclipse\\workspace\\Selenium\\EXE\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();		
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://www.freecrm.com/index.html");
		
		driver.findElement(By.name("username")).sendKeys("gowreshn04");
		driver.findElement(By.name("password")).sendKeys("9880562207");
		WebElement element = driver.findElement(By.className("btn"));
		
		Flash(driver, element); //Highlight the element
		DrawBorder(driver, element); //Draw a border and take screenshot
		CreateAlert(driver, "Bug screenshot taken"); //Create Alert
		Alert al = driver.switchTo().alert();
		al.accept();
		
		ClickElementByJS(driver, element); //Click Element		
		RefreshBrowserByJS(driver); //Navigate back
		
		System.out.println(GetTitleByJS(driver)); //Get Title
		System.out.println(GetPageInnerTextByJS(driver)); //Get Innertext
		
		//ScrollPageDown(driver); //Scroll page down
		ScrollIntoView(driver, driver.findElement(By.linkText("Forgot Password?")));
		
		

	}
	
	
	public static void Flash(WebDriver driver, WebElement element) {
		String bcolor = element.getCssValue("backgroundColor");
		for(int i = 0; i <100 ; i++) {
			ChangeColor(driver, element, "rgb(0,200,0)");
			ChangeColor(driver, element, bcolor);			
		}
	}
	
	public static void ChangeColor(WebDriver driver, WebElement element, String color) {
		
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].style.backgroundColor = '"+color+"'", element);
		
		try {
			
			Thread.sleep(10);
		}catch(Exception e ) {
			e.printStackTrace();
		}
	}
	
	
	public static void DrawBorder(WebDriver driver, WebElement element) throws IOException {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].style.border = '3px solid red'", element);
		TakeScreenShot(driver);
		
		
	}
	
	public static void TakeScreenShot(WebDriver driver) throws IOException {
		File op = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(op, new File("C:\\Eclipse\\workspace\\Selenium\\src\\selenium\\bug.png"));
		
	}
	
	public static void CreateAlert(WebDriver driver, String message) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("alert('"+message+"')");
	}
	
	public static void ClickElementByJS(WebDriver driver, WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].click();", element);
	}
	
	public static void RefreshBrowserByJS(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("history.go(-1)");
	}
	
	public static String GetTitleByJS(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		return js.executeScript("return document.title;").toString();
	}
	
	public static String GetPageInnerTextByJS(WebDriver driver) {
		
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		return js.executeScript("return document.documentElement.innerText;").toString();
	}
	
	public static void ScrollPageDown(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	
	public static void ScrollIntoView(WebDriver driver, WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

}
