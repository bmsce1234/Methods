package com.test.calendar;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import stevejobs.WebsiteUtilities;

public class TestCalendar {

	public static void main(String[] args)throws Exception {
		//take input from keyboard
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter browser name:: ");
		String bn =sc.nextLine();	
		System.out.println("Enter year in yyyy:: "); 
		int year=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter month:: ");
		String month=sc.nextLine();
		System.out.println("Enter date:: ");
		int date=sc.nextInt();
		sc.close();
		
		//System.out.println(bn+""+year+""+month+""+""+date);
		//create utility class object
		WebsiteUtilities utility =new WebsiteUtilities();
		RemoteWebDriver driver= utility.getBrowserName(bn);
		//launch site
		utility.launchSite(driver, "https://jqueryui.com/datepicker", 5000);
		
		CalenderAutomationPage page=new CalenderAutomationPage(driver);
		page.selectDatePicker();
		Thread.sleep(5000);
		//page.selectDate(year, month, date);
		page.selectYear(year);
		page.selectMonth(month);
		page.selectDate(date);
		Thread.sleep(5000);
		
		utility.closeBrowser(driver);
	}
}
