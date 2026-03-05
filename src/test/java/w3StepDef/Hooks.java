package w3StepDef;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import w3Base.W3TestBase;

public class Hooks
{
	@BeforeAll
	public static void setup()
	{
		W3TestBase.initDriver();
	}

	@After
	public void tearDown(Scenario scenario)
	{
		if(scenario.isFailed())
		{
			TakesScreenshot screen = (TakesScreenshot) W3TestBase.getDriver();
			byte[] img = screen.getScreenshotAs(OutputType.BYTES);
			scenario.attach(img, "image/png", "FailedScenarioPage");	
		}
			
	}
	
}
