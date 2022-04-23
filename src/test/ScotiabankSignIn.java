package test;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ScotiabankSignIn {

	public static void main(String[] args) throws InterruptedException, IOException {
		
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
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.scotiabank.com/ca/en/personal.html");
		driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.id("usernameInput-input")).sendKeys("fdsfds");
		driver.findElement(By.id("password-input")).sendKeys("dbghds");
		driver.findElement(By.id("signIn")).click();
		
		String expected= "Please check your card number / username or password and try again.";
		String actual = driver.findElement(By.id("globalError")).getText();
		System.out.println(actual);
		
		if(expected.equals(actual)) {
			System.out.println("test pass");
		}else {
			System.out.println("test fail");
		}
		driver.close();
		
	}

}
