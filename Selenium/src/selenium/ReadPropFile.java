package selenium;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadPropFile {

	public static void main(String[] args) throws IOException {
				
		Properties properties = new Properties();
		FileInputStream file = new FileInputStream("C:\\Eclipse\\workspace\\Selenium\\src\\selenium\\config.properties");		
		properties.load(file);	
		
		System.out.println(properties.getProperty("URL"));
	}

}
