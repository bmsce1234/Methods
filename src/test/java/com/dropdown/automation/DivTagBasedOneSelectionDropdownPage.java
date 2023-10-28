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

public class DivTagBasedOneSelectionDropdownPage {

	private RemoteWebDriver driver;
	
	@FindBy(xpath = "//a[@id='selection']/following-sibling::div[2]")
	private WebElement dropdown;
	
	@FindBys({
		@FindBy(xpath = "//a[@id='selection']/following-sibling::div[2]/div[2]/div")
	})
	private List<WebElement> dropdownitems;
	
	
	public DivTagBasedOneSelectionDropdownPage(RemoteWebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public int getDropdownItemsCount() {
		return dropdownitems.size();
	}
	
	public List<String> getDropdownItemsList()throws Exception{
		dropdown.click();
		Thread.sleep(3000);
		
		List<String> names= new ArrayList<String>();
		
		for(WebElement item:dropdownitems) {
			names.add(item.getText());
		}
		
		dropdown.sendKeys(Keys.ESCAPE);
		Thread.sleep(2000);
		return names;
	}
	
	public void selectItemOnIndex(int index)throws Exception {
		dropdown.click();
		Thread.sleep(5000);
		if(index>=dropdownitems.size()||index<0) {
			System.out.println("wrong index,as selected default item as 1st item");
			dropdownitems.get(0).click();
		}else {
			dropdownitems.get(index).click();
		}
	}
	
	public void selectItemOnName(String name)throws Exception {
		
		dropdown.click();
		Thread.sleep(5000);
		
		int flag=0;
		for(WebElement item:dropdownitems) {
			if(item.getText().equalsIgnoreCase(name)) {
				item.click();
				Thread.sleep(3000);
				flag=1;
				break;
			}
		}
		
		if(flag==0) {
			System.out.println("wrong index,as selected default item as 1st item");
			dropdownitems.get(0).click();
			Thread.sleep(3000);
		}
	}
	
	public String getSelecteddropdownItem() {
		return dropdown.findElement(By.xpath("child::div[1]")).getText();
	}
}
