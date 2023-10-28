package stevejobs;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class UsingGetWindowHandles {

	public static void main(String[] args) throws Exception {
		WebsiteUtilities utilities =new WebsiteUtilities();
		//get chrome driver
		RemoteWebDriver driver=utilities.getBrowserName("chrome");
		//launch website
		utilities.launchSite(driver, "https://www.w3schools.com", 5000);
		driver.findElement(By.linkText("Try it Yourself")).click();
		Thread.sleep(5000);
		
		/*Set<String> s=driver.getWindowHandles();
		List<String> l=new ArrayList<String>(s);*/
		
		List<String> l=utilities.getWindowHandlesList(driver);
		 System.out.println(l.get(0));
		 System.err.println(l.get(1));
		
		utilities.closeWindowOrTab(driver, l.get(1));
		 Thread.sleep(6000);
		utilities.closeBrowser(driver);
	}
}
