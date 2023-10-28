package com.test.getAttributeMethod;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HiddenElementPage {
	
	@FindBy(name="hiddenPassword")
	private WebElement testEle;
	
	public HiddenElementPage(RemoteWebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public String getValue(String value) {
		return testEle.getAttribute(value);
	}
}
