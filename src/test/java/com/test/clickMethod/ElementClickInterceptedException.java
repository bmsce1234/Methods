package com.test.clickMethod;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class ElementClickInterceptedException {
	
	private RemoteWebDriver driver;
	
	@FindBy(linkText = "Kendo UI for Vue")
	private WebElement clickElement;

	public ElementClickInterceptedException(RemoteWebDriver driver) {
		this.driver=driver;
		
		AjaxElementLocatorFactory aFactory=new AjaxElementLocatorFactory(driver, 20);
		PageFactory.initElements(aFactory, this);
	}
	
	public void clickElement() {
		clickElement.click();
	}
}
