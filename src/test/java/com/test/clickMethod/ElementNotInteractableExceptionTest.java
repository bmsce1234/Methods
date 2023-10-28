package com.test.clickMethod;

import org.openqa.selenium.remote.RemoteWebDriver;

import stevejobs.WebsiteUtilities;

public class ElementNotInteractableExceptionTest {

	public static void main(String[] args) throws Exception {
		WebsiteUtilities utilities=new WebsiteUtilities();
		
		RemoteWebDriver driver= utilities.getBrowserName("chrome");
		
		utilities.launchSite(driver, "http://www.gmail.com", 5000);//ElementNotInteractableException
		
		ElementNotInteractableException cl=new ElementNotInteractableException(driver);
		
		cl.clickHiddenButton();
		Thread.sleep(5000);

	}

}
