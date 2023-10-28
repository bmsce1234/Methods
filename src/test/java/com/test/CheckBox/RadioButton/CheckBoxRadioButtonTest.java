package com.test.CheckBox.RadioButton;

import java.util.Scanner;

import org.openqa.selenium.remote.RemoteWebDriver;

import stevejobs.WebsiteUtilities;

public class CheckBoxRadioButtonTest {

	public static void main(String[] args)throws Exception {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter Browser name:: ");
		String browserName=sc.nextLine();
		
		System.out.println("Enter checkBox index:: ");
		int CBindex=sc.nextInt();
		
		System.out.println("Enter RadioBtn index:: ");
		int RBindex=sc.nextInt();
		sc.close();
	
		WebsiteUtilities utility= new WebsiteUtilities();
		
		RemoteWebDriver driver=utility.getBrowserName(browserName);
		
		utility.launchSite(driver, "https://www.phpforkids.com/html/html-form-check-boxes-radio-buttons.php", 5000);

		TestCheckBoxRadioButtonPage page=new TestCheckBoxRadioButtonPage(driver);
		
		//call
		page.selectCheckBox(CBindex);
		Thread.sleep(5000);
		
		//observe the check box
		if(page.verifyCheckBox(CBindex)) {
			System.out.println("checkbox test passed");
		}else {
			System.out.println("check box test failed");
		}
		
		Thread.sleep(5000);
		page.deSelectCheckBox(CBindex);
		
		//click radio button
		Thread.sleep(5000);
		page.clickRadioButton(RBindex);
		Thread.sleep(5000);
		
		if(page.verifyRadioButton(RBindex)) {
			System.out.println("radio button test passed");
		}else {
			System.out.println("radio button test failed");
		}
		
		//close site
		utility.closeBrowser(driver);
	}

}
