package w3Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class W3EditArticle
{
	WebDriver driver;
	WebDriverWait expWait;
	
	@FindBy(xpath="//a[text()=' Edit Article']")
	WebElement editArt;
	
	@FindBy(xpath="//input[@name='title']")
	WebElement artTitle;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement updateArt;
	
	@FindBy(tagName="h1")
	WebElement chkUpdArt;
	
	public W3EditArticle(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		expWait = new WebDriverWait(driver,Duration.ofSeconds(20));
	}
	
	public void updateArticle(String strTitle)
	{
		editArt.click();
		artTitle.clear();
		artTitle.sendKeys(strTitle);
		updateArt.click();	
		
	}
	
	//Checking Article is updated
	public boolean isArticleUpdated(String strTit) throws InterruptedException
	{
		//Explicit wait method to check for Article Title
		expWait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.tagName("h1")),strTit));
		
		//Thread.sleep(1000);
		
		//System.out.println("Checking H1 Tag name :"+ chkUpdArt.getText());
		
		if(chkUpdArt.isDisplayed())
		{
			System.out.println("Article Update is Successfull!! " + chkUpdArt.getText());
			return true;
		}
		else
		{
			//System.out.println("H1 tag is not available:Edit Article" + chkUpdArt.getText());
			return false;
		}
	}
}