package com.dropdown.automation;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class SingleSelectDropdownPracticePage {
	private RemoteWebDriver driver;

	@FindBy(xpath = "(//div[@class='ui fluid selection dropdown'])[1]")
	private WebElement nameDropdown;
	
	@FindBys({
		@FindBy(xpath = "//input[@name='user']/following-sibling::div[2]/div")
	})
	private List<WebElement> nameDropdownItems;
	
	public SingleSelectDropdownPracticePage(RemoteWebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public int getCountOfItems() {
		return nameDropdownItems.size();
	}
	
	public List<String> getDropdownItemsList()throws Exception{
		nameDropdown.click();
		Thread.sleep(3000);
		List<String> names=new ArrayList<String>();
		
		for(WebElement item:nameDropdownItems) {
			String n=(String)driver.executeScript("return(arguments[0].textContent);", item);
			n=n.trim();
			names.add(n);
		}
		
		nameDropdown.sendKeys(Keys.ESCAPE);
		Thread.sleep(3000);
		
		return names;
	}
	
	public void selectDropdownItemByIndex(int index)throws Exception {
		nameDropdown.click();
		Thread.sleep(3000);
		if(index>=nameDropdownItems.size()||index<0) {
			System.out.println("wrong index,as selected first name default");
			nameDropdownItems.get(0).click();
			Thread.sleep(3000);
		}else {
			nameDropdownItems.get(index).click();
		}
	}
	
	public void selectDropdownItemByName(String name)throws Exception {
		nameDropdown.click();
		Thread.sleep(3000);
		int flag=0;
		for(WebElement item:nameDropdownItems) {
			String s=(String)driver.executeScript("return(arguments[0].textContent);", item);
			s=s.trim();
			if(s.equalsIgnoreCase(name)) {
				item.click();
				flag=1;
				break;
			}
		}
		
		if(flag==0) {
			System.out.println("wrong index,as selected first name default");
			nameDropdownItems.get(0).click();
			Thread.sleep(3000);
		}
	}
	
	public String getSelectedDropdownName() {
		return nameDropdown.findElement(By.xpath("child::div[1]")).getText();
	}
}
