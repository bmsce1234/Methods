package com.test.BrokenLinks;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.RemoteWebDriver;

import stevejobs.WebsiteUtilities;

public class TstBrokenLinksViaPaginationRunner {

	public static void main(String[] args)throws Exception {
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter browser name:: ");
		String bn=sc.nextLine();
		System.out.println("Enter a word:: ");
		String word=sc.nextLine();
		
		WebsiteUtilities utility =new WebsiteUtilities();
		
		RemoteWebDriver driver=utility.getBrowserName(bn);
		utility.launchSite(driver, "http://www.google.com", 5000);
		
		driver.findElement(By.name("q")).sendKeys(word,Keys.ENTER);
		
		BrokenLinksPage page=new BrokenLinksPage(driver);
		int pageNo=1;
		
		while(true) {
			List<String> allBrokenLinks=page.findBrokenLinks();
			for(String s:allBrokenLinks) {
				System.out.println(s);
			}
			
			try {
				pageNo++;
				driver.findElement(By.linkText(pageNo+"")).click();
			}catch(NoSuchElementException exe) {
				break;
			}
		}
	}
}
