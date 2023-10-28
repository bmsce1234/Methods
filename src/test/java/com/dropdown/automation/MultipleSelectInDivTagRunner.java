package com.dropdown.automation;

import java.util.List;

import org.openqa.selenium.remote.RemoteWebDriver;

import stevejobs.WebsiteUtilities;

public class MultipleSelectInDivTagRunner {

	public static void main(String[] args)throws Exception {
		WebsiteUtilities utility=new WebsiteUtilities();
		RemoteWebDriver driver=utility.getBrowserName("chrome");
		utility.launchSite(driver, "https://semantic-ui.com/modules/dropdown.html", 5000);
		
		MultipleSelectInDivTagPage page =new MultipleSelectInDivTagPage(driver);
		System.out.println(page.getDropDownItemsCount());
		
		//take all items in list
		List<String> items=page.getDropDownItemsList();
		System.out.println(items);
		/*for(String item:items) {
			page.openDropDown();
			Thread.sleep(1000);
			page.selectDropDownItemByName(item);
			Thread.sleep(1000);
			String actual=page.getFirstSelectedItem();
			
			if(actual.equalsIgnoreCase(item)) {
				System.out.println(item+" test passes");
			}else {
				System.out.println(item+" test failed");
			}
			
			page.deselectByName(item);
			page.closeDropDown();
			Thread.sleep(1000);
		}//for*/
		
		//open drop down
		/*page.openDropDown();
		for(String item:items) {
			page.selectDropDownItemByName(item);
			if(page.getLastSelectedItem().equals(item)) {
				System.out.println(item+" test passed");
			}else {
				System.out.println(item+" test failed");
			}
		}//for
		
		page.closeDropDown();
		page.deselectAll();*/
		
		/*for(int i=0;i<items.size();i++) {
			page.openDropDown();
			Thread.sleep(2000);
			page.selectDropDownItemByIndex(i);
			Thread.sleep(1000);
			System.out.println(page.getFirstSelectedItem());
			if(page.getFirstSelectedItem().equals(items.get(i))) {
				System.out.println(items.get(i)+" test passed");
			}else {
				System.out.println(items.get(i)+" test failed");
			}
			
			page.deselectByName(items.get(i));
			Thread.sleep(1000);
			page.closeDropDown();
		}//for*/
		
		/*page.openDropDown();
		
		for(int i=0;i<items.size();i++) {
			page.selectDropDownItemByIndex(i);
			Thread.sleep(2000);
			if(page.getLastSelectedItem().equals(items.get(i))) {
				System.out.println(items.get(i)+" test passed");
			}else {
				System.out.println(items.get(i)+" test failed");
			}
		}//for
		page.closeDropDown();
		Thread.sleep(1000);
		page.deselectAll();*/
		
		page.openDropDown();
		
		page.selectItemInRange(0, 6);
		
		page.closeDropDown();
		
		for(int i=0;i<6;i++) {
			page.deselectItemByIndex(i);
		}
		
		page.openDropDown();
		
		page.selectAll();
		
		//close driver
		utility.closeBrowser(driver);

	}

}
