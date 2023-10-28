package com.WebElement.GetScreenshotAs;

import org.openqa.selenium.remote.RemoteWebDriver;

import stevejobs.WebsiteUtilities;

public class HiddenElementTest {

	public static void main(String[] args)throws Exception {
		WebsiteUtilities utility =new WebsiteUtilities();
		
		RemoteWebDriver driver=utility.getBrowserName("chrome");
		
		utility.launchSite(driver, "http://www.gmail.com", 5000);
		
		HiddenElementPage page=new HiddenElementPage(driver);
		
		String filePath=page.getScreenshot();
		System.out.println(filePath);
		
		utility.closeBrowser(driver);

	}

}
