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

public class MultipleSelectInDivTagPage {
	
	private RemoteWebDriver driver;
	
	@FindBy(xpath = "//a[@id='multiple-selection']/following-sibling::div")
	private WebElement skillsDropDown;
	
	@FindBys({
		@FindBy(xpath = "//a[@id='multiple-selection']/following-sibling::div/child::div[2]/div")
	})
	private List<WebElement> dropDownItems;
	
	//constructor method
	public MultipleSelectInDivTagPage(RemoteWebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//operational method
	//get count of items in dropdown
	public int getDropDownItemsCount() {
		return dropDownItems.size();
	}
	
	//open dropdown
	public void openDropDown() {
		skillsDropDown.click();
	}
	
	//close dropdown
	public void closeDropDown() {
		skillsDropDown.sendKeys(Keys.ESCAPE);
	}
	
	//get list of all items in dropdown
	public List<String> getDropDownItemsList(){
		
		List<String> names=new ArrayList<String>();
		
		for(WebElement item:dropDownItems) {
			names.add((String)driver.executeScript("return(arguments[0].textContent);", item));
		}//for
		
		return names;
	}//getDropDownItemsList
	
	//select item in dropdown by index
	public void selectDropDownItemByIndex(int index)throws Exception {
		if(index>=dropDownItems.size()||index<0) {
			System.out.println("Wrong index, as default 1st item selected");
			dropDownItems.get(0).click();
		}else {
			dropDownItems.get(index).click();
			Thread.sleep(2000);
		}
	}//selectDropDownItemByIndex
	
	//select item in dropdown by name
	public void selectDropDownItemByName(String name)throws Exception {
		int flag=0;
		for(WebElement item:dropDownItems) {
			String actual=item.getText();
			if(actual.equals(name)) {
				item.click();
				Thread.sleep(2000);
				flag=1;
				break;
			}//if
		}//for
		
		if(flag==0) {
			System.out.println("Wrong name, as default 1st item selected");
			dropDownItems.get(0).click();
			Thread.sleep(2000);
		}//if
	}//selectDropDownItemByName
	
	//get all selected items in dropdown
	public List<String> getAllSelectedItems(){
		 List<WebElement> names= skillsDropDown.findElements(By.xpath("child::a"));
		 List<String> l=new ArrayList<String>();
		 for(WebElement name:names) {
			 l.add(name.getText());
		 }
		 return l;
	}//getAllSelectedItems
	
	//get first selected item in dropdown
	public String getFirstSelectedItem() {
	    return skillsDropDown.findElements(By.xpath("child::a")).get(0).getText();
	}//getFirstSelectedItem
	
	public String getLastSelectedItem() {
		List<WebElement> names=skillsDropDown.findElements(By.xpath("child::a"));
		return names.get(names.size()-1).getText();
	}//getLastSelectedItem
	
	
	public void selectAll()throws Exception {
		for(WebElement item:dropDownItems) {
			item.click();
			Thread.sleep(2000);
		}
	}//selectAll
	
	
	public void selectItemInRange(int ll,int ul)throws Exception {
			for(int i=ll;i<ul;i++) {
				dropDownItems.get(i).click();
				Thread.sleep(3000);
			}//for
	}//selectItemInRange
	
	
	public void deselectItemByIndex(int index)throws Exception {
		if(index>=dropDownItems.size()||index<0) {
			System.out.println("wrong index give the correct index 0 to"+(dropDownItems.size()-1));
		}else {
			List<WebElement>names=skillsDropDown.findElements(By.xpath("child::a"));
			System.out.println(names.size());
			names.get(index).findElement(By.xpath("child::i")).click();
			Thread.sleep(2000);
		}
	}//deselectItemByIndex
	
	public void deselectByName(String name)throws Exception {
		int flag=0;
		List<WebElement>names=skillsDropDown.findElements(By.xpath("child::a"));
		for(WebElement item:names) {
			String actual=item.getText();
			if(actual.equals(name)) {
				item.findElement(By.xpath("child::i")).click();
				Thread.sleep(2000);
				flag=1;
				break;
			}//if
		}//for
		
		if(flag==0) {
			System.out.println("wrong name give a correct name");
		}
	}//deselectByName
	
	//de-select all selected items
	public void deselectAll()throws Exception {
		List<WebElement> eles=skillsDropDown.findElements(By.xpath("child::a"));
		
		for(WebElement ele:eles) {
			ele.findElement(By.xpath("child::i")).click();
			Thread.sleep(1000);
		}//for
	}//deselectAll
}
