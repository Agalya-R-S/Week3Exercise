package w3Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
		features = "src\\test\\resources\\features\\",
		
		glue = {"w3StepDef"},	
		
		//Cucumber reports
		plugin= {"html:test-output/report/HTMLReport.html",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		}
		)

public class articleCRUDrunner extends AbstractTestNGCucumberTests
{
  
}
