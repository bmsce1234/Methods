package com.test.clickMethod;

import org.openqa.selenium.remote.RemoteWebDriver;

import stevejobs.WebsiteUtilities;

public class NoReactionPageTest {

	public static void main(String[] args) throws Exception {
	   WebsiteUtilities utilities=new WebsiteUtilities();
	   
	   RemoteWebDriver driver=utilities.getBrowserName("chrome");
	   
	   utilities.launchSite(driver, "https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_input_disabled", 5000);
	   
	   DisableElementNoReactionPage page= new DisableElementNoReactionPage(driver);
	   page.clickInvisible();
	  Thread.sleep(5000);
	  
	  
	  utilities.closeBrowser(driver);

	}

}
