package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePage 
{
	WebDriver driver;
	public HomePage(){}
	 public void HomePageInitial(WebDriver driver)
	 {
	    this.driver = driver;
	 }
	public void getHomePageDashboard()
     {
		driver.get("http://s-cxp.cengage.com/activityservice/test");
		
	 }
}
