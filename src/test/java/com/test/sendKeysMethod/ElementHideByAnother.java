package com.test.sendKeysMethod;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class ElementHideByAnother {

	
	private RemoteWebDriver driver;
	
	@FindBy(xpath = "//input[@placeholder='Search for products, brands and more']")
	private WebElement search;
	
	public ElementHideByAnother(RemoteWebDriver driver) {
		this.driver=driver;
		
		AjaxElementLocatorFactory aFactory=new AjaxElementLocatorFactory(driver, 20);
		
		PageFactory.initElements(aFactory,this);
	}
	
	public void fillSearchBox(String value) {
		search.sendKeys(value);
	}
}
