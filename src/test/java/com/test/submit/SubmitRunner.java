package com.test.submit;

import org.openqa.selenium.remote.RemoteWebDriver;

import stevejobs.WebsiteUtilities;

public class SubmitRunner {

	public static void main(String[] args)throws Exception {
		WebsiteUtilities utility=new WebsiteUtilities();
		
		RemoteWebDriver driver=utility.getBrowserName("chrome");
		utility.launchSite(driver, "http://www.flipkart.com", 5000);

		SubmitPage page=new SubmitPage(driver);
		Thread.sleep(5000);
		page.submitBtn();
		
		utility.closeBrowser(driver);
	}

}
