package com.test.clearMethod;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HiddenElementPage {
	

	@FindBy(name="hiddenPassword")
	private WebElement uName;
	
	public HiddenElementPage(RemoteWebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void fillUName(String value) {
		uName.sendKeys(value);
	}
	
	public void clearUName() {
		uName.clear();
	}
}
