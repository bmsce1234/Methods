package com.test.CacheLookUp.Annotation;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompareTwoAnnotPage {

	@FindBy(name="q")
	private WebElement e;
	
	@CacheLookup
	@FindBy(name="q")
	private WebElement e1;
	
	public CompareTwoAnnotPage(RemoteWebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public String getText() {
		return e.getText();
	}
	
	public String getText1() {
		return e1.getText();
	}
}
