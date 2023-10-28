package com.test.sendKeysMethod;

import org.openqa.selenium.remote.RemoteWebDriver;

import stevejobs.WebsiteUtilities;

public class ElementHideByAnotherTest {

	public static void main(String[] args) throws Exception {
		WebsiteUtilities utilities=new WebsiteUtilities();
		
		RemoteWebDriver driver=utilities.getBrowserName("chrome");
		
		utilities.launchSite(driver, "https://www.flipkart.com/", 5000);
		
		ElementHideByAnother element=new ElementHideByAnother(driver);
		
		element.fillSearchBox("shooes");
		
		utilities.closeBrowser(driver);

	}

}
