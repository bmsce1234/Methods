package com.test.clearMethod;

import org.openqa.selenium.remote.RemoteWebDriver;

import stevejobs.WebsiteUtilities;

public class DisabledElementTest {

	public static void main(String[] args) throws Exception {

		WebsiteUtilities utilities=new WebsiteUtilities();
		
		RemoteWebDriver driver=utilities.getBrowserName("chrome");
		
		utilities.launchSite(driver, "https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_input_disabled", 5000);
       
		DisabledElementPage ele=new DisabledElementPage(driver);
		
		//ele.fillLName("hey"); ElementNotInteractableException
		
		ele.clearLName();//InvalidElementStateException
	}

}
