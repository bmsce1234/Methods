package com.test.pagination;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.RemoteWebDriver;

import stevejobs.WebsiteUtilities;

public class CheckTitleViaPagination {

	public static void main(String[] args)throws Exception {
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter browser name::");
		String bn=sc.nextLine();
		System.out.println("Enter a word");
		String word=sc.nextLine();
		
		WebsiteUtilities utility=new WebsiteUtilities();
		RemoteWebDriver driver=utility.getBrowserName(bn);
		utility.launchSite(driver, "https://www.google.com", 5000);
		
		driver.findElement(By.name("q")).sendKeys(word,Keys.ENTER);
		
		int pageNo=1;
		int flag=0;
		while(true) {
			String title=driver.getTitle();
			
			if(!title.contains(word)) {
				flag=1;
				break;
			}
			
			try {
				pageNo++;
				driver.findElement(By.linkText(pageNo+"")).click();
			}catch(NoSuchElementException e) {
				break;
			}
		}//while
		
		if(flag==0) {
			System.out.println("tilte test passed");
		}else {
			System.out.println("title test failed");
		}
		
		//close driver
		utility.closeBrowser(driver);
	}
}
