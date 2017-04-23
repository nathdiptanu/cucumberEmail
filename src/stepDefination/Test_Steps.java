package stepDefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Test_Steps {
	public static WebDriver driver;
	static long startTime = System.currentTimeMillis();
	

	@Given("^User is on Home Page$")
	public void user_is_on_Home_Page() throws Throwable {
		driver = new HtmlUnitDriver();
		driver.get("https://www.google.co.in");
		System.out.println("Opened Browser");
	}

	@When("^User Navigate to LogIn Page$")
	public void user_Navigate_to_LogIn_Page() throws Throwable {
		driver.findElement(By.xpath("//*[@id='lst-ib']")).click();
		System.out.println("Opened Browser and clicked");
	}

	@When("^User enters UserName and Password$")
	public void user_enters_UserName_and_Password() throws Throwable {
		driver.findElement(By.xpath("//*[@id='lst-ib']")).sendKeys("testuser_1");
		System.out.println("Opened Browser and clicked and send keys");
	}

	@Then("^Message displayed Login Successfully$")
	public void message_displayed_Login_Successfully() throws Throwable {
		System.out.println("Test Successfully");
	}

	@After
	public void cleanUp(Scenario scenario) {
		driver.close();
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println(totalTime);
		
		String TestCase = scenario.getName().toString();
		String TestResult = scenario.getStatus().toString();
		System.out.println(TestCase + TestResult);
		Reporter.report(TestCase, TestResult,totalTime);
		Reporter.writeResults();
	}

}