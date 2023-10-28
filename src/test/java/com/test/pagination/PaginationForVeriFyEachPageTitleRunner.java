package com.test.pagination;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import stevejobs.WebsiteUtilities;

public class PaginationForVeriFyEachPageTitleRunner {

	public static void main(String[] args)throws Exception {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter browser name::");
		String bn=sc.nextLine();
		System.out.println("Enter a word");
		String word=sc.nextLine();
		sc.close();
		
		WebsiteUtilities utility=new WebsiteUtilities();
		RemoteWebDriver driver=utility.getBrowserName(bn);
		utility.launchSite(driver, "http://www.google.com", 5000);
		
		paginationPage page=new paginationPage(driver);
		page.fillAndEnterTxt(word);
		
		int flag=0;
		int pageNo=1;
		while(true) {
			String title=page.getTitle();
			//System.out.println(title);
			if(!title.contains(word)) {
				flag=1;
				break;
			}
			
			try {
				pageNo++;
				page.clickNextPage(pageNo);
			}catch(Exception e) {
				break;
			}
		}
		
		if(flag==0)
			System.out.println("title test passed");
		else
			System.out.println("title test failed");
		
		utility.closeBrowser(driver);
	}
}
