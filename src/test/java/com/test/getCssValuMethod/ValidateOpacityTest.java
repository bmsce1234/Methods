package com.test.getCssValuMethod;

import org.openqa.selenium.remote.RemoteWebDriver;

import stevejobs.WebsiteUtilities;

public class ValidateOpacityTest {

	public static void main(String[] args) throws Exception {
		//create object utilities class
		WebsiteUtilities utilities=new WebsiteUtilities();
		
		//open browser
		RemoteWebDriver driver=utilities.getBrowserName("chrome");
		
		//launch website
		utilities.launchSite(driver, "https://www.w3schools.com/css/tryit.asp?filename=trycss_image_transparency", 5000);
		
		//create page class object
		ValidateOpacityPage page=new ValidateOpacityPage(driver);
		
		page.overMouse();
		Thread.sleep(5000);
		
		if(page.verifyOpacity()) {
			System.out.println("test passed");
		}else {
			System.out.println("test failed");
		}
		
		utilities.closeBrowser(driver);

	}

}
