package com.dropdown.automation;

import org.openqa.selenium.remote.RemoteWebDriver;

import stevejobs.WebsiteUtilities;

public class SingleSelectPracticeRunner {

	public static void main(String[] args)throws Exception {
		WebsiteUtilities utilities=new WebsiteUtilities();
		RemoteWebDriver driver=utilities.getBrowserName("chrome");
		utilities.launchSite(driver, "https://semantic-ui.com/modules/dropdown.html", 5000);
		
		SingleSelectDropdownPracticePage page= new SingleSelectDropdownPracticePage(driver);
		
		System.out.println(page.getCountOfItems());
		System.out.println(page.getDropdownItemsList());
		//page.selectDropdownItemByIndex(1);
		page.selectDropdownItemByName("Stevie Feliciano");
		System.out.println(page.getSelectedDropdownName());
		
		utilities.closeBrowser(driver);

	}

}
