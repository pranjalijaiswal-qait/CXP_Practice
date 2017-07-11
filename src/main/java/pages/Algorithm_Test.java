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

public class Algorithm_Test {
	WebDriver driver;
	By dropdown_list=By.xpath("html/body/div[1]/form/div[1]/div[4]/select");
	By take=By.name("take");
	By frame=By.id("easyXDM_activityService_target_provider");
	By answer=By.xpath("//input[@class='ci-input' and @value='1']");
	By submit=By.cssSelector("div.button.submit-button");
	By another_version=By.cssSelector(".button.retry-button");
	By next=By.cssSelector(".sel-next.enabled");
	public void Algorithm_Test() {
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
	 }
	 public void firstThree() throws InterruptedException, IOException
	 {
		    driver.switchTo().frame(driver.findElement(frame));
			for(int index=0;index<3;index++)
		    {
			driver.findElement(answer).click();
			thread(3000);
			//assertion for a blank submit
			Assert.assertEquals(driver.findElement(submit).getAttribute("class").contains("enabled"),true);
			driver.findElement(submit).click(); 
			thread(3000);
			//Execute JavaScript using Selenium
			//JavascriptExecutor js = (JavascriptExecutor) driver;  
			//boolean temp=(Boolean) js.executeScript("return $('.submit-button').is(':visible')");
		    Assert.assertEquals(driver.findElement(submit).getAttribute("class").contains("enabled"),false);
		    Assert.assertEquals(driver.findElement(another_version).isEnabled(), true);
			thread(3000);
			driver.findElement(next).click();
			thread(3000);
		    }
	 }
	 public void lastQuestion() throws InterruptedException
	 {
		    
		    driver.findElement(answer).click();
		    thread(3000);
			driver.findElement(submit).click();
	 }
	 
}
