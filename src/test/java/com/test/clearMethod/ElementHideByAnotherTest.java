package com.test.clearMethod;

import org.openqa.selenium.remote.RemoteWebDriver;

import stevejobs.WebsiteUtilities;

public class ElementHideByAnotherTest {

	public static void main(String[] args) throws Exception {

		WebsiteUtilities utilities=new WebsiteUtilities();
		
		RemoteWebDriver driver=utilities.getBrowserName("chrome");
		
		utilities.launchSite(driver, "http://www.flipkart.com", 5000);
		
		ElementHideByAnotherPage page=new ElementHideByAnotherPage(driver);
		
		page.clickCancle();
		Thread.sleep(5000);
		
		page.fillSearch("grocessries");
		Thread.sleep(5000);
		
		page.clearSearch();
		Thread.sleep(5000);
		
		utilities.closeBrowser(driver);
	}

}
