package pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class ScotiaLoginPage {
	WebDriver driver;

	public void openBrowser() throws IOException {
		
		FileInputStream f= new FileInputStream("C:\\Testing\\prop.properties");
		Properties prop=new Properties();
		prop.load(f);
		
		String browser=prop.getProperty("browser");
		System.out.println(browser);
		WebDriver driver;
		if(browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\SeleniumJars\\chromedriver.exe");
			 driver=new ChromeDriver();
		}else if(browser.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\SeleniumJars\\geckodriver.exe");
			 driver=new FirefoxDriver();
		}else{
			System.setProperty("webdriver.safari.driver", "C:\\SeleniumJars\\safaridriver.exe");
			driver=new ChromeDriver();
		}
		
		
		}
	public void closeBrowser() {
		driver.close();
	}
	
	
	
	
}
