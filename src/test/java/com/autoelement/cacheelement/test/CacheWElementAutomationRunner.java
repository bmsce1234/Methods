package com.autoelement.cacheelement.test;

import org.openqa.selenium.remote.RemoteWebDriver;

import stevejobs.WebsiteUtilities;

public class CacheWElementAutomationRunner {

	public static void main(String[] args)throws Exception {
		WebsiteUtilities utility=new WebsiteUtilities();
		RemoteWebDriver driver=utility.getBrowserName("chrome");
		utility.launchSite(driver, "https://www.youtube.com", 5000);
		
		CacheElementAutomation page=new CacheElementAutomation(driver);
		page.setSearchBox("kalam");
		Thread.sleep(10000);
		
		System.out.println(page.gatCountOfAllSuggestions());
		System.out.println(page.getTextOfSpecificSuggestion(2));
		System.out.println(page.getTextOfAllSuggestions());
		
		if(page.verifyAllSuggestions("kalam")) {
			System.out.println("test passed");
		}else {
			System.out.println("test failed");
		}
		
		System.out.println(page.verifyUnmatchedSuggestion("kalam"));

		utility.closeBrowser(driver);
	}

}
