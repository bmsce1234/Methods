package com.test.clearMethod;

import org.openqa.selenium.remote.RemoteWebDriver;

import stevejobs.WebsiteUtilities;

public class HiddenElementTest {

	public static void main(String[] args)throws Exception {

		WebsiteUtilities utilities=new WebsiteUtilities();
		
		RemoteWebDriver driver=utilities.getBrowserName("chrome");
		
		utilities.launchSite(driver, "http://www.gmail.com", 5000);
		
		HiddenElementPage page=new HiddenElementPage(driver);
		
		/*page.fillUName("ankush.dongare143@gmail.com");
		Thread.sleep(5000);
		
		page.clearUName();
		Thread.sleep(5000);*/
		
		page.clearUName();//ElementNotInteractableException
		Thread.sleep(5000);
		
		utilities.closeBrowser(driver);
	}

}
