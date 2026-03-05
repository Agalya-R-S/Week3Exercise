package w3Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class W3NewArticle 
{
	
	WebDriver driver;
	WebDriverWait expWait;
	
	@FindBy(xpath="//input[@name='title']")
	WebElement artTitle;
	
	@FindBy(xpath="//input[@name='description']")
	WebElement artDesc;
	
	@FindBy(xpath="//textarea[@name='body']")
	WebElement artMain;
	
	@FindBy(xpath="//input[@name='tags']")
	WebElement artTags;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement publishArt;
	
	@FindBy(tagName="h1")
	WebElement chkNewArt;
	
	public W3NewArticle(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		expWait = new WebDriverWait(driver,Duration.ofSeconds(20));
	}
	
	public void articleInput(String strTitle, String strDesc,String strMain, String strTag)
	{
		artTitle.sendKeys(strTitle);
		artDesc.sendKeys(strDesc);
		artMain.sendKeys(strMain);
		artTags.sendKeys(strTag);
		publishArt.click();
	}
	
	//Checking Article is created
	public boolean isArticleCreated(String strTit)
	{

		//Explicit wait method to check for Article Title
		expWait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.tagName("h1")),strTit));
		
		if(chkNewArt.isDisplayed())
		{
			System.out.println("Article Creation is successfull!");
			return true;
		}
		else
		{
			//System.out.println("H1 tag is not available:New Article");
			return false;
		}
	}
}



