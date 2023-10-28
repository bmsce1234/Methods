package com.test.isSelectesMethod;

import java.util.Scanner;

import org.openqa.selenium.remote.RemoteWebDriver;

import stevejobs.WebsiteUtilities;

public class CheckRadioButtonSelectedTest {

	public static void main(String[] args)throws Exception {
		
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter browser name:: ");
		String browserName=sc.nextLine();
		
		WebsiteUtilities utility=new WebsiteUtilities();
		
		RemoteWebDriver driver=utility.getBrowserName(browserName);
		
		utility.launchSite(driver, "https://www.w3schools.com/html/tryit.asp?filename=tryhtml_form_radio",5000);
		
		CheckRadioButtonIsSelected pageObj=new CheckRadioButtonIsSelected(driver);
		
		pageObj.clickRadioBtn();
		
		Thread.sleep(5000);
		
		if(pageObj.isRadioSelected()) 
			System.out.println("test passed");
		else
		    System.out.println("test faile");
		
		utility.closeBrowser(driver);
	}

}
