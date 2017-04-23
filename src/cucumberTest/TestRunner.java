package cucumberTest;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.junit.Cucumber;
import stepDefination.Reporter;
 
@RunWith(Cucumber.class)
@CucumberOptions(
		features = "Feature"
		,glue={"stepDefination"},
		plugin={"html:target/reports"}
		 
		)
 

public class TestRunner {
	@BeforeClass
	public static void start() {
		Reporter.initialize();
		
		
	}

	   
	
	   
}