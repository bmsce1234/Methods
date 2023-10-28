package com.getSize.getLocation.getRect;

import java.util.Scanner;

import org.openqa.selenium.remote.RemoteWebDriver;

import stevejobs.WebsiteUtilities;

public class Test51Runner {

	public static void main(String[] args) throws Exception {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter browser name::");
		String browserName=sc.nextLine();
		sc.close();
		
		WebsiteUtilities utilities=new WebsiteUtilities();
		RemoteWebDriver driver=utilities.getBrowserName(browserName);
		utilities.launchSite(driver, "https://beta.spicejet.com/", 5000);
		
		Test51Page page=new Test51Page(driver);
		
		int details1[]=page.getDetails1();
		/*for(int i=0;i<details1.length;i++) {
			if(i==0)
				System.out.println("height is:: "+details1[i]);
			if(i==1)
				System.out.println("width is:: "+details1[i]);
			if(i==2)
				System.out.println("x-cordinate is:: "+details1[i]);
			if(i==3)
				System.out.println("y-cordinate is:: "+details1[i]);
		}*/
		
		for(int x:details1) {
			System.out.println(x);
		}
		
		int details2[]=page.getDetails2();
		/*for(int i=0;i<details2.length;i++) {
			if(i==0)
				System.out.println("height is:: "+details1[i]);
			if(i==1)
				System.out.println("width is:: "+details1[i]);
			if(i==2)
				System.out.println("x-cordinate is:: "+details1[i]);
			if(i==3)
				System.out.println("y-cordinate is:: "+details1[i]);
		}*/
		
		for(int x:details2) {
			System.out.println(x);
		}
		
		utilities.closeBrowser(driver);

	}
}
