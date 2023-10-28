package com.getSize.getLocation.getRect;

import org.openqa.selenium.remote.RemoteWebDriver;

import stevejobs.WebsiteUtilities;

public class HiddeElementGetDetailsRunner {

	public static void main(String[] args) throws Exception {
		WebsiteUtilities utility=new WebsiteUtilities();
		RemoteWebDriver driver=utility.getBrowserName("chrome");
		utility.launchSite(driver, "http://www.gmail.com", 5000);
		
		HiddenElementGetDetails page=new HiddenElementGetDetails(driver);
		int x[]=page.getDetails(1);
		int y[]=page.getDetails(2);
		
		for(int a:x) {
			System.out.println(a);
		}
		for(int b:y) {
			System.out.println(b);
		}
		
		utility.closeBrowser(driver);

	}

}
