package w3TestScript;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import w3Base.W3TestBase;
import w3Pages.W3DeleteArticle;
import w3Pages.W3EditArticle;
import w3Pages.W3LoginPage;
import w3Pages.W3NewArticle;

public class W3ArticleScript 
{
	WebDriver driver1;
	W3LoginPage w2LoginPage;
	W3NewArticle newArticle;
	W3EditArticle editArticle;
	W3DeleteArticle deleteArticle;
	int artNum = 44, artNum1=404;
	String strT;
	
	@BeforeTest
	  public void setup()
	  {
		W3TestBase.initDriver();
		driver1 = W3TestBase.getDriver();
		W3TestBase.openUrl("https://conduit-realworld-example-app.fly.dev/#/login");
		w2LoginPage = new W3LoginPage(driver1); 
		newArticle = new W3NewArticle(driver1);
		editArticle = new W3EditArticle(driver1);
		deleteArticle = new W3DeleteArticle(driver1);			
	  }
	
	@Test(priority = 1)
	public void loginTest() 
	{
		System.out.println("LOGIN PAGE");
		w2LoginPage.loginIntoApp("agalya.s@gmail.com", "agalya");
		
	}
	
	@Test(priority = 2)
	public void newArticleTest()
	{
		strT = "Go Lang"+String.valueOf(artNum);
		newArticle.articleInput(strT, "Go Language", "Go Language by Google", "#GoGoogle");
	}
	
	@Test(priority = 3)
	public void EditArticleTest() throws InterruptedException
	{
		strT = "Go Lang"+String.valueOf(artNum1);
		editArticle.updateArticle(strT);
	}
	
	@Test(priority = 4)
	public void DeleteArticleTest() throws InterruptedException
	{
		deleteArticle.removeArticle(strT);
	}
}
