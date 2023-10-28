package com.test.clickMethod;

import org.openqa.selenium.remote.RemoteWebDriver;

import stevejobs.WebsiteUtilities;

public class ElementClickInterceptedExceptionTest {

	public static void main(String[] args) throws Exception {
		WebsiteUtilities utilities=new WebsiteUtilities();
		
		RemoteWebDriver driver=utilities.getBrowserName("chrome");
		
		utilities.launchSite(driver, "https://www.telerik.com/support", 5000);
		
		ElementClickInterceptedException page=new ElementClickInterceptedException(driver);
		
		page.clickElement();
		Thread.sleep(5000);
		
		utilities.closeBrowser(driver);

	}

}
