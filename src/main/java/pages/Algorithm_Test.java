package pages;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Algorithm_Test 
{
	WebDriver driver;
	By dropdown_list=By.xpath("html/body/div[1]/form/div[1]/div[4]/select");
	By take=By.name("take");
	By frame=By.id("easyXDM_activityService_target_provider");
	By submit=By.cssSelector("div.button.submit-button");
	By another_version=By.cssSelector(".button.retry-button");
	By next=By.cssSelector(".sel-next.enabled");
	public void Algorithm_Test() 
	{
	}
	 public void initial(WebDriver driver)
	 {
	    this.driver = driver;
	 }
	 public void thread(long timeout) throws InterruptedException
	 {
		 Thread.sleep(timeout); 
	 }
	 
	 public void initiate() throws InterruptedException
	 {
		    Select dropdown = new Select(driver.findElement(dropdown_list));
			dropdown.selectByIndex(6);
			driver.findElement(take).submit();
			thread(1000);
			driver.findElement(take).click();
			driver.switchTo().frame(driver.findElement(frame));
			thread(1000);
	 }
	 public void select_correct() throws InterruptedException
	 {
		    String question=driver.findElement(By.cssSelector(".ci-question")).getText();
		    char answer=question.charAt(0);
		    By ans=By.xpath("//*[@class='ci-choice-descr' and contains(text(),'"+answer+"')]/..//input");
		    thread(1000);
		    driver.findElement(ans).isDisplayed();
		    driver.findElement(ans).click();
			thread(2000);	
	 }
	 public void check_Blank_submit_before_click()
	 {
		 Assert.assertEquals(driver.findElement(submit).getAttribute("class").contains("enabled"),true);
		 //Assert.assertEquals(driver.findElement(another_version).isEnabled(), false);
	 }
	 public void submit_click() throws InterruptedException
	 {
		 driver.findElement(submit).click(); 
		 thread(4000); 
	 }
	 public void check_correct() throws InterruptedException
	 {
		 Assert.assertEquals(driver.findElement(By.cssSelector(".ci-feedback-title")).getText(), "Correct");
		 thread(2000);
	 }
	 public void check_Blank_submit_after_click() throws InterruptedException
	 {
		Assert.assertEquals(driver.findElement(submit).getAttribute("class").contains("enabled"),false);
		//Assert.assertEquals(driver.findElement(another_version).isEnabled(), true);
		thread(3000);
	 }
	public void next_click() throws InterruptedException
	 {
		 driver.findElement(next).click();
		 thread(3000);
	 }
	//Execute JavaScript using Selenium
	//JavascriptExecutor js = (JavascriptExecutor) driver;  
	//boolean temp=(Boolean) js.executeScript("return $('.submit-button').is(':visible')");
	public void select_incorrect() throws InterruptedException
	{
		String question=driver.findElement(By.cssSelector(".ci-question")).getText();
	    char answer=question.charAt(0);
	    By ans=By.xpath("//*[@class='ci-choice-descr' and (not(contains(text(),'"+answer+"')))]/..//input");
	    driver.findElement(ans).click();
	    thread(2000);
	}
	public void check_incorrect() throws InterruptedException
	{
		Assert.assertEquals(driver.findElement(By.cssSelector(".ci-feedback-title")).getText(), "Incorrect");
	    thread(3000);
	}
	public void submit_and_check() throws InterruptedException
	{
		check_Blank_submit_before_click();
		submit_click();
	}
	public void check_and_next() throws InterruptedException
	{
		check_Blank_submit_after_click();
		next_click();
	}
	public void correct_answers() throws InterruptedException
	{
		for(int index=0;index<3;index++)
		{
		select_correct();
		submit_and_check();
		check_correct();
		check_and_next();
		}
	}
	public void incorrect_answer() throws InterruptedException
	{
		select_incorrect();
		submit_and_check();
		check_incorrect();
		check_Blank_submit_after_click();
	}

	 
}
