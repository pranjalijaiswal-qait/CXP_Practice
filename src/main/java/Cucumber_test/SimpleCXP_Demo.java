package Cucumber_test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SimpleCXP_Demo {
	
	private static WebDriver driver=null;
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C:/Users/pranjalijaiswal/Downloads/chromedriver_win32 (1)/chromedriver.exe");
		driver =new ChromeDriver();
		///driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://s-cxp.cengage.com/activityservice/test");
		//driver.findElement(By.xpath("html/body/ul/li[2]/a")).click();
		//driver.findElement(By.xpath("html/body/div[1]/form/div[1]/div[4]/select")).click();
		Select dropdown = new Select(driver.findElement(By.xpath("html/body/div[1]/form/div[1]/div[4]/select")));
		dropdown.selectByIndex(6);
		driver.findElement(By.name("take")).submit();
		Thread.sleep(1000);
		driver.findElement(By.name("take")).click();
		driver.switchTo().frame(driver.findElement(By.id("easyXDM_activityService_target_provider")));
		for(int index=0;index<3;index++)
	    {
		driver.findElement(By.xpath("//input[@class='ci-input' and @value='1']")).click();
		//driver.switchTo().defaultContent();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("div.button.submit-button.enabled")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".sel-next.enabled")).click();
	    }
		driver.findElement(By.xpath("//input[@class='ci-input' and @value='1']")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("div.button.submit-button.enabled")).click();
		//driver.findElement(By.xpath(".//*[@id='dcb6fc054001fe9']/div[1]/div[2]/div[2]/span[1]/span[1]/input"));
		//driver.findElement(By.xpath("html/body/div[1]/form/div[1]/div[1]/input")).click();
	}

}
