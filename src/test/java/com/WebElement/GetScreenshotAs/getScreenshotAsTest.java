package com.WebElement.GetScreenshotAs;

import org.openqa.selenium.remote.RemoteWebDriver;

import stevejobs.WebsiteUtilities;

public class getScreenshotAsTest {

	public static void main(String[] args) throws Exception {
		WebsiteUtilities utility=new WebsiteUtilities();
		
		RemoteWebDriver driver=utility.getBrowserName("chrome");
		
		utility.launchSite(driver, "http://www.flipkart.com", 5000);
		
		getScreenShotElementPage page=new getScreenShotElementPage(driver);
		Thread.sleep(5000);
		String filepath=page.getScreenshot();
		
		System.out.println(filepath);
		
		utility.closeBrowser(driver);

	}

}
