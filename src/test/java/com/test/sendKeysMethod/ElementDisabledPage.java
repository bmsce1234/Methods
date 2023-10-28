package com.test.sendKeysMethod;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class ElementDisabledPage {

	private RemoteWebDriver driver;
	
	@FindBy(name="lname")
	private WebElement disabledElement;
	
	
	public ElementDisabledPage(RemoteWebDriver driver) {
		this.driver=driver;
		
		AjaxElementLocatorFactory aFactory=new AjaxElementLocatorFactory(driver, 20);
		
		PageFactory.initElements(aFactory, this);
	}
	
	public void fillDisabledElement(String value) {
		driver.switchTo().frame("iframeResult");
		disabledElement.sendKeys(value);
	}
}
