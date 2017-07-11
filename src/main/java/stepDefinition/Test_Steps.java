package stepDefinition;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.Algorithm_Test;
import pages.HomePage;

public class Test_Steps {
	static WebDriver driver=null;
	HomePage home=new HomePage();
	Algorithm_Test algo=new Algorithm_Test();
	@Given("^open browser$")
	public void open_browser()  
	{
		System.setProperty("webdriver.chrome.driver","C:/Users/pranjalijaiswal/Downloads/chromedriver_win32 (1)/chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		
	}

	@Given("^user is on the test activity page$")
	public void user_is_on_the_test_activity_page() 
	{
		home.HomePageInitial(driver);
		home.getHomePageDashboard();
		
	
	}

	@When("^user selects a some random pre-defined example$")
	public void user_selects_a_some_random_pre_defined_example() throws InterruptedException  {
		algo.initial(driver);
		algo.initiate();
		
	}

	@When("^questions of different test are answered$")
	public void questions_of_different_test_are_answered() throws InterruptedException, IOException 
	{
		algo.firstThree();
	}

	@When("^yet another question answered$")
	public void yet_another_question_answered() throws InterruptedException 
	{
		algo.lastQuestion();
	}

	@Then("^display message test over$")
	public void display_message_test_over() throws Throwable {
	    System.out.println("test over");
	}
}
