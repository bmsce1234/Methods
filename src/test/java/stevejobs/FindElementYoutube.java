package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class FindElementYoutube {

	public static void main(String[] args) throws Exception {
		WebsiteUtilities utilities=new WebsiteUtilities();
		RemoteWebDriver driver=utilities.getBrowserName("chrome");
		
		utilities.launchSite(driver, "https://www.youtube.com", 5000);
		
		driver.findElement(By.id("search")).sendKeys("new songs");
		
		driver.findElement(By.id("search-icon-legacy")).click();
		

	}

}
