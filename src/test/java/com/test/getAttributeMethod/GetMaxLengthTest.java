package com.test.getAttributeMethod;

import org.openqa.selenium.remote.RemoteWebDriver;

import stevejobs.WebsiteUtilities;

public class GetMaxLengthTest {

	public static void main(String[] args) throws Exception {

		//create object of utility class
		WebsiteUtilities utilities=new WebsiteUtilities();
		
		//get browser
		RemoteWebDriver driver=utilities.getBrowserName("chrome");
		
		//launch site
		utilities.launchSite(driver, "http://www.google.com", 5000);
		
		//create obj of page class
		GetMaxLengthPage page=new GetMaxLengthPage(driver);
		
		//call the method
		//boolean check=page.verifyMaxlLength(2048);
		
		//check test script
		if(page.verifyMaxlLength(2048)) {
			System.out.println("test pass");
		}else {
			System.out.println("test fail");
		}
		
		//close driver
		driver.close();
		
	}
}
