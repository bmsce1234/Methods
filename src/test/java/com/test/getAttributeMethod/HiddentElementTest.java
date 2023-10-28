package com.test.getAttributeMethod;

import org.openqa.selenium.remote.RemoteWebDriver;

import stevejobs.WebsiteUtilities;

public class HiddentElementTest {

	public static void main(String[] args) throws Exception {

		WebsiteUtilities utilities=new WebsiteUtilities();
		
		RemoteWebDriver driver=utilities.getBrowserName("chrome");
		
		utilities.launchSite(driver, "http://www.gmail.com", 5000);
		
		HiddenElementPage page=new HiddenElementPage(driver);
		
		System.out.println(page.getValue("aria-hidden"));
		
		utilities.closeBrowser(driver);
	}

}
