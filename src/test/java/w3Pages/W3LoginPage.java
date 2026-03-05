package w3Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class W3LoginPage 
{
	WebDriver driver;
	@FindBy(name ="email")
	WebElement uname;
	
	@FindBy(name="password")
	WebElement pwd;
	
	@FindBy(xpath="//button[contains(text(),'Login')]")
	WebElement loginBtn;
	
	@FindBy(linkText="New Article")
	WebElement newArt;
	
	@FindBy(xpath="//img[@alt='Agalya']")
	WebElement succLogin;	
	
	public W3LoginPage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
	}
	
	//Login to the Article portal
	public void loginIntoApp(String strUser,String StrPwd)
	{
		System.out.println("LOGIN METHOD");
		uname.sendKeys(strUser);
		pwd.sendKeys(StrPwd);
		loginBtn.click();
		newArt.click();					
	}
	
	//Checking for successful Login
	public boolean isLoginPage()
	{
		if(succLogin.isDisplayed())
		{
			System.out.println("Login is Successfull!!!");
			return true;			
		}
		else
		{
			return false;
		}
	}

}
