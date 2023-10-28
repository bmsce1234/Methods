package com.test.getCssValuMethod;

import org.openqa.selenium.remote.RemoteWebDriver;

import stevejobs.WebsiteUtilities;

public class GetColorOfFPTest {

	public static void main(String[] args) throws Exception {

		WebsiteUtilities utilities=new WebsiteUtilities();
		
		RemoteWebDriver driver=utilities.getBrowserName("chrome");
		
		utilities.launchSite(driver, "http://www.gmail.com", 5000);
		
		GetColorOfFPPage page=new GetColorOfFPPage(driver);
		
		if(page.verifyColor("rgba(26, 115, 232, 1)")) {
			System.out.println("test passed");
		}else {
			System.out.println("test failed");
		}
		
		utilities.closeBrowser(driver);

	}

}
