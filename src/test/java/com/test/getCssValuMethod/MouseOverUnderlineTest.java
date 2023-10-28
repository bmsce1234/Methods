package com.test.getCssValuMethod;

import org.openqa.selenium.remote.RemoteWebDriver;

import stevejobs.WebsiteUtilities;

public class MouseOverUnderlineTest {

	public static void main(String[] args) throws Exception {
		WebsiteUtilities utilities=new WebsiteUtilities();
		
		RemoteWebDriver driver=utilities.getBrowserName("chrome");
		
		utilities.launchSite(driver, "http://www.google.com", 5000);
		
		MouseOverUnderlinedPage page=new MouseOverUnderlinedPage(driver);
		
		page.moveMouse();
		
		if(page.validatelink("underline solid rgba(0, 0, 0, 0.87)")) {
			System.out.println("test passed");
		}else {
			System.out.println("test failed");
		}
		
		driver.close();
	}
}
