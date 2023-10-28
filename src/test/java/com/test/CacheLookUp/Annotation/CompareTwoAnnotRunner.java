package com.test.CacheLookUp.Annotation;

import org.openqa.selenium.remote.RemoteWebDriver;

import stevejobs.WebsiteUtilities;

public class CompareTwoAnnotRunner {

	public static void main(String[] args)throws Exception {
		
		WebsiteUtilities utility =new WebsiteUtilities();
		
		RemoteWebDriver driver=utility.getBrowserName("chrome");
		utility.launchSite(driver, "http://www.google.com", 5000);
		
		CompareTwoAnnotPage page=new CompareTwoAnnotPage(driver);
		long pre=System.currentTimeMillis();
		for(int i=1;i<=40;i++) {
			page.getText();
		}
		long past=System.currentTimeMillis();
		System.out.println("time taken without using cache "+(float)(past-pre)/1000);
		
		long pre1=System.currentTimeMillis();
		for(int i=1;i<=40;i++) {
			page.getText1();
		}
		long post1=System.currentTimeMillis();
		System.out.println("time taken using Cache "+(float)(post1-pre1)/1000);
		
		utility.closeBrowser(driver);

	}
}
