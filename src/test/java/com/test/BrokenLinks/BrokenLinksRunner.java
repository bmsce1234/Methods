package com.test.BrokenLinks;

import java.util.List;

import org.openqa.selenium.remote.RemoteWebDriver;

import stevejobs.WebsiteUtilities;

public class BrokenLinksRunner {

	public static void main(String[] args)throws Exception {
		WebsiteUtilities utilities=new WebsiteUtilities();
		
		RemoteWebDriver driver=utilities.getBrowserName("chrome");
		
		utilities.launchSite(driver, "http://www.amazon.com", 5000);
		
		BrokenLinksPage page =new BrokenLinksPage(driver);
		
		//WebElement e=driver.findElement(By.linkText("Gmail"));
		
		//System.out.println(page.isBrokenLink(e));
		
		List<String> l=page.findBrokenLinks();
		
		System.out.println(l.size());
		
		for(String s:l) {
			System.out.println(s);
		}
		
		utilities.closeBrowser(driver);
	}
}
