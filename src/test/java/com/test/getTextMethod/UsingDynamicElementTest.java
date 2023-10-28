package com.test.getTextMethod;

import org.openqa.selenium.remote.RemoteWebDriver;

import stevejobs.WebsiteUtilities;

public class UsingDynamicElementTest {

	public static void main(String[] args)throws Exception {
		WebsiteUtilities utilities=new WebsiteUtilities();
		RemoteWebDriver driver=utilities.getBrowserName("chrome");
		utilities.launchSite(driver, "https://www.worldometers.info/world-population/",5000);
		
		UsingDynamicElementTextPage page=new UsingDynamicElementTextPage(driver);
		
		for(int i=0;i<=10;i++) {
			System.out.println(page.getTextOfDynamicEle());
			Thread.sleep(1000);
		}
		
		utilities.closeBrowser(driver);

	}

}
