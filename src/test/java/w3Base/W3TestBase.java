package w3Base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class W3TestBase 
{
	//Declaration 
	private static W3TestBase testBase;
	private static WebDriver driver;
	
	//Browser Settings Constructor
	private W3TestBase()
	{
		String strBrowser = "chrome";
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		
		if(strBrowser.equalsIgnoreCase("chrome"))
		{
			//Chrome Preferences
			driver =  new ChromeDriver(options);
		}
		else if(strBrowser.equalsIgnoreCase("edge"))
		{
			driver =  new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().deleteAllCookies();		
	}
	
	//Calling the constructor for Browser initialize
	public static void initDriver()
	{
		if(testBase == null)
		{
			testBase =  new W3TestBase();
		}
	}
	
	public static WebDriver getDriver()
	{
		return driver;
	}
	
	public static void openUrl(String url)
	{
		driver.get(url);
	}
	
	//Close the browser
	public static void tearDown()
	{
		if (driver != null)
		{
			driver.close(); // close current tab
			driver.quit();  // close all opened browser/tabs
		}
		testBase = null;
	}
	
}
