package ConvergHub_Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import ConvergHub_Util.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("D:\\QA_Work\\POC\\POC_Java\\Selenium_ConvergHub\\ConvergHub_Test\\src\\main\\java\\ConvergHub_Config\\Config.properties");
			prop.load(ip);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void initialization() {
		String browserName = prop.getProperty("testBrowser");
		String chromeDriver = prop.getProperty("chromeDriverPath");
		if(browserName.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver",chromeDriver);
			driver = new ChromeDriver();
		} else if (browserName.equals("FireFox")){
			
			// Write Geco driver initialization code here
			
		} else if (browserName.equals("anyOtherBrowser")) {
			
			// Write other browser driver initialization code here
			
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_load_timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.implicit_wait, TimeUnit.SECONDS);
		
		//launch the application
		String applicationURL = prop.getProperty("applicationURL");
		driver.get(applicationURL);
	}
	

}
