package com.test.getTagName;

import org.openqa.selenium.remote.RemoteWebDriver;

import stevejobs.WebsiteUtilities;

public class TestRunner {

	public static void main(String[] args)throws Exception {
		WebsiteUtilities utility=new WebsiteUtilities();
		
		RemoteWebDriver driver=utility.getBrowserName("chrome");
		
		utility.launchSite(driver, "http://www.google.com", 5000);
		
		TestPage page =new TestPage(driver);
		
		//System.out.println(page.getTagName());
		
		if(page.verifyTagName("input"))
			System.out.println("test passed");
		else
			System.out.println("test failed");
		
		utility.closeBrowser(driver);

	}

}
