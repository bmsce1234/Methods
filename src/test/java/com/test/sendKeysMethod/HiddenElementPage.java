package com.test.sendKeysMethod;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class HiddenElementPage {

	private RemoteWebDriver driver;
	
	@FindBy(name="hiddenPassword")
	private WebElement hiddenElement;
	
	public HiddenElementPage(RemoteWebDriver driver) {
		this.driver=driver;
		
		AjaxElementLocatorFactory aFactory=new AjaxElementLocatorFactory(driver,20);
		
		PageFactory.initElements(aFactory, this);
	}
	
	
	public void fillHiddenElement(String value) {
		driver.switchTo().frame("iframeResult");
		hiddenElement.sendKeys(value);
	}
}
