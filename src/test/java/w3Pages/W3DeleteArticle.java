package w3Pages;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class W3DeleteArticle 
{
	WebDriver driver;
	@FindBy(xpath="//button[contains(text(),' Delete Article')]")
	WebElement delArt;
	
	@FindBy(xpath="//button[@class='nav-link ']")
	WebElement gblFeed;
	
	@FindAll({@FindBy(tagName="h1")})
	List<WebElement> chkTag;
	
	/*@FindAll({@FindBy(how = How.TAG_NAME,using="div.summary_info")})
	List<WebElement> summaryItems; */
	
	public W3DeleteArticle(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void removeArticle(String strArtTitle)
	{
		
		delArt.click();
		//Get current driver session
		String parenWin = driver.getWindowHandle();
		
		// Handling Alerts
		Alert delAlert = driver.switchTo().alert();
		delAlert.accept();	
		
		//Switch to parent window
		driver.switchTo().window(parenWin);			
		gblFeed.click();	
		
		//System.out.println("My Article name is :"+strArtTitle);		
	}
	
	public boolean isArticleDeleted(String strTit)
	{
		//To check Article is deleted successfully
		String tmpTitle;
		for(int i=0; i<chkTag.size(); i++)
		{
			tmpTitle = chkTag.get(i).getText();
			//System.out.println("Article Found is :"+tmpTitle);
			if(!tmpTitle.equalsIgnoreCase(strTit))
			{
				System.out.println("Article Deletion is successfull!!");
				return true;
			}
		}
		return false;	
	}
	
}
