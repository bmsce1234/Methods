package com.test.pagination;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import stevejobs.WebsiteUtilities;

public class PaginationForEachPageReultRunner {

	public static void main(String[] args)throws Exception {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter browser name::");
		String bn=sc.nextLine();
		System.out.println("Enter a word");
		String word=sc.nextLine();
		
		WebsiteUtilities utilities=new WebsiteUtilities();
		RemoteWebDriver driver=utilities.getBrowserName(bn);
		utilities.launchSite(driver, "https://www.google.com", 5000);
		
		paginationPage page=new paginationPage(driver);
		page.fillAndEnterTxt(word);
		
		int totalCount=0;
		int pageNo=1;
		while(true) {
			List<WebElement> visibleEles=page.getVisibleElements();
			System.out.println("on page-"+ pageNo +" visible results are "+ visibleEles.size());
			totalCount=totalCount+visibleEles.size();
			
			try {
				pageNo++;
				page.clickNextPage(pageNo);
			}catch (Exception e) {
				break;
			}
		}
		
		System.out.println("all page visible results are "+totalCount);
		
		utilities.closeBrowser(driver);

	}

}
