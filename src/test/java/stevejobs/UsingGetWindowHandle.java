package stevejobs;

import org.openqa.selenium.remote.RemoteWebDriver;

public class UsingGetWindowHandle {

	public static void main(String[] args) throws Exception {
		WebsiteUtilities utilities=new WebsiteUtilities();
		RemoteWebDriver driver=utilities.getBrowserName("chrome");
		utilities.launchSite(driver, "http://www.google.com", 2000);
		String s=driver.getWindowHandle();
		System.out.println(s);
		utilities.closeBrowser(driver);

	}

}
