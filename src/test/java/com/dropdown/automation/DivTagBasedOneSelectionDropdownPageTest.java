package com.dropdown.automation;

import java.util.List;

import org.openqa.selenium.remote.RemoteWebDriver;

import stevejobs.WebsiteUtilities;

public class DivTagBasedOneSelectionDropdownPageTest {

	public static void main(String[] args)throws Exception {
		WebsiteUtilities utility=new WebsiteUtilities();
		RemoteWebDriver driver=utility.getBrowserName("chrome");
		utility.launchSite(driver, "https://semantic-ui.com/modules/dropdown.html", 5000);
		
		DivTagBasedOneSelectionDropdownPage page= new DivTagBasedOneSelectionDropdownPage(driver);
		System.out.println("all items are:: "+page.getDropdownItemsCount());
		List<String> items=page.getDropdownItemsList();
		
		for(String item:items) {
			page.selectItemOnName(item);
			if(page.getSelecteddropdownItem().equalsIgnoreCase(item)) {
				System.out.println(item+" test passed for given name");
			}else {
				System.out.println(item+" test failed for given name");
			}
		}
		
		page.selectItemOnIndex(0);
		if(page.getSelecteddropdownItem().equalsIgnoreCase("male")) {
			System.out.println("male test passed for given index");
		}else {
			System.out.println("male test failed for given index");
		}
		
		page.selectItemOnIndex(1);
		if(page.getSelecteddropdownItem().equalsIgnoreCase("female")) {
			System.out.println("female test passed for given name");
		}else {
			System.out.println("female test failed for given name");
		}
		
		utility.closeBrowser(driver);

	}

}
