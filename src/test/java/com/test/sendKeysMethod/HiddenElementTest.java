package com.test.sendKeysMethod;

import org.openqa.selenium.remote.RemoteWebDriver;

import stevejobs.WebsiteUtilities;

public class HiddenElementTest {

	public static void main(String[] args) throws Exception {
		WebsiteUtilities utilities=new WebsiteUtilities();
		
		RemoteWebDriver driver=utilities.getBrowserName("chrome");
		
		utilities.launchSite(driver, "http://www.gmail.com", 5000);
		
		HiddenElementPage page=new HiddenElementPage(driver);
		
		page.fillHiddenElement("ankush");
		
		utilities.closeBrowser(driver);

	}

}
