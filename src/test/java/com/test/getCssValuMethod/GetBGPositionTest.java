package com.test.getCssValuMethod;

import org.openqa.selenium.remote.RemoteWebDriver;

import stevejobs.WebsiteUtilities;

public class GetBGPositionTest {

	public static void main(String[] args) throws Exception {
		WebsiteUtilities utilities=new WebsiteUtilities();
		
		RemoteWebDriver driver=utilities.getBrowserName("chrome");
		
		utilities.launchSite(driver, "http://www.flipkart.com", 5000);
		
		GetBGPositionPage page=new GetBGPositionPage(driver);
		
		//page.clickGoogleApps();
		Thread.sleep(5000);
		
		if(page.verifyBGPosition("relative")) {
			System.out.println("test passed");
		}else {
			System.out.println("test failed");
		}
		
		driver.close();

	}

}
