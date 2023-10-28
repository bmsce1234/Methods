package com.test.WebTableAutomation;

import java.util.Scanner;

import org.openqa.selenium.remote.RemoteWebDriver;

import stevejobs.WebsiteUtilities;

public class WebTableAutomationOnGmailTest {

	public static void main(String[] args) throws Exception{
		/*Scanner sc=new Scanner(System.in);
		System.out.println("Enter browser name:: ");
		String bn=sc.nextLine();
		System.out.println("Enter username:: ");
		String uid=sc.nextLine();
		System.out.println("Enter password:: ");
		String pwd=sc.nextLine();
		sc.close();*/
		
		WebsiteUtilities utility=new WebsiteUtilities();
		RemoteWebDriver driver=utility.getBrowserName("chrome");
		utility.launchSite(driver, "https://www.gmail.com", 5000);
		
		WebTableAutomationOnGmail page=new WebTableAutomationOnGmail(driver);
		page.setUserId("info.anku527@gmail.com");
		page.clickUidNext();
		Thread.sleep(5000);
		
		page.setPassword("ankush9145204527");
		page.clickPassNext();
		Thread.sleep(5000);
		
		/*System.out.println("all mails:: "+page.getCountofAllMails());
		System.out.println("Unread mails:: "+page.getCountofUnreadMails());
		System.out.println("read mails:: "+page.getCountofReadMails());
		System.out.println("attachment mails:: "+page.getCountOfAttachment());
		System.out.println("from id mails:: "+page.getCountfromId("no-reply@accounts.google.com"));
		System.out.println("on date:: "+page.getCountOfMailOnDate(2021,"september", 15));*/
		
		int allMails=page.getCountofAllMails();
		int deletemail=page.deleteMailOnFromId("google-noreply@google.com");
		int allMails2=page.getCountofAllMails();
		System.out.println(allMails);
		System.out.println(deletemail);
		System.out.println(allMails2);
		if(allMails==allMails2+deletemail) {
			System.out.println("test passed");
		}
		
		utility.closeBrowser(driver);

	}

}
