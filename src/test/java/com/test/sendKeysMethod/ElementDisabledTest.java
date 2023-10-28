package com.test.sendKeysMethod;

import org.openqa.selenium.remote.RemoteWebDriver;

import stevejobs.WebsiteUtilities;

public class ElementDisabledTest {

	public static void main(String[] args) throws Exception {
		WebsiteUtilities utilities=new WebsiteUtilities();
		
		RemoteWebDriver driver=utilities.getBrowserName("chrome");
		
		utilities.launchSite(driver, "https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_input_disabled", 5000);
		
		ElementDisabledPage page=new ElementDisabledPage(driver);
		
		page.fillDisabledElement("ankush");
		
		utilities.closeBrowser(driver);

	}

}
