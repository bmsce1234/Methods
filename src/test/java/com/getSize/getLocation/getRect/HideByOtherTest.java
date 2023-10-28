package com.getSize.getLocation.getRect;

import org.openqa.selenium.remote.RemoteWebDriver;

import stevejobs.WebsiteUtilities;

public class HideByOtherTest {

	public static void main(String[] args)throws Exception {
		WebsiteUtilities utility=new WebsiteUtilities();
		
		RemoteWebDriver driver=utility.getBrowserName("chrome");
		
		utility.launchSite(driver, "http://www.flipkart.com", 5000);
		
		HideByOtherElePage page=new HideByOtherElePage(driver);
		
		int x[]=page.getDetails1();
		int y[]=page.getDetails2();
		
		for(int a:x) {
			System.out.println(a);
		}
		
		for(int b:y) {
			System.out.println(b);
		}
		
		utility.closeBrowser(driver);

	}

}
