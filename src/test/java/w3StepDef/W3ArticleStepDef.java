package w3StepDef;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import w3Base.W3TestBase;
import w3Pages.W3DeleteArticle;
import w3Pages.W3EditArticle;
import w3Pages.W3LoginPage;
import w3Pages.W3NewArticle;

public class W3ArticleStepDef 
{
	WebDriver driver;
	W3LoginPage loginPage;
	W3NewArticle newArticle;
	W3EditArticle uptArticle;
	W3DeleteArticle deleteArticle;
	
	
	//Driver initialization for all pages class
	public W3ArticleStepDef()
	{
		driver=W3TestBase.getDriver();
		loginPage = new W3LoginPage(driver);
		newArticle = new W3NewArticle(driver);
		uptArticle = new W3EditArticle(driver);
		deleteArticle = new W3DeleteArticle(driver);	
		
	}
		
	//USER LOGIN Scenario
	@Given("User is on login page")
	public void user_is_on_login_page() 
	{
		W3TestBase.openUrl("https://conduit-realworld-example-app.fly.dev/#/login");
	}
	
	@When("User enters {string} and {string}")
	public void user_enters_and(String strUsr, String strPWd)
	{
		loginPage.loginIntoApp(strUsr, strPWd);
	}
	
	@Then("User should be on Home Page")
	public void user_should_be_on_home_page() 
	{
		Assert.assertTrue(loginPage.isLoginPage());
	}		

	//CREATE NEW ARTICLE		
	@When("User creates new article {string} {string} {string} {string}")
	public void user_creates_new_article(String artTitle, String artDesc, String artMain, String artTag)
	{
		//System.out.println("Article information : "+ artTitle + artDesc+artMain+artTag);
		newArticle.articleInput(artTitle, artDesc, artMain, artTag);
	}
		
	@Then("Article is Created {string}")
	public void article_is_created(String strTitle) throws InterruptedException 
	{
		Assert.assertTrue(newArticle.isArticleCreated(strTitle));		
	}
	
	//UPDATE ARTICLE - receiving inputs as Lists
	@When("User updates article")
	public void user_updates_article(DataTable dataTable) throws InterruptedException 
	{
		List<List<String>> uptTit =  dataTable.asLists();
		String tit = uptTit.get(0).get(0);
		//System.out.println("ARTICLE TO update is : "+tit);
		uptArticle.updateArticle(tit);
	}
	
	@Then("Article is Updated {string}")
	public void article_is_updated(String strTitle) throws InterruptedException
	{
		Assert.assertTrue(uptArticle.isArticleUpdated(strTitle));
	}
	
	//DELETE ARTICLE - receiving inputs as Maps
	@When("User deletes article")
	public void user_deletes_article(DataTable dataTable) 
	{
		List<Map<String,String>> uptTit =  dataTable.asMaps();
		String tit = uptTit.get(0).get("title");
		//System.out.println("ARTICLE TO delete is : "+tit);
		deleteArticle.removeArticle(tit);
	}
	
	@Then("Article is Deleted {string}")
	public void article_is_deleted(String strTit) 
	{
		Assert.assertTrue(deleteArticle.isArticleDeleted(strTit));
	}
}
