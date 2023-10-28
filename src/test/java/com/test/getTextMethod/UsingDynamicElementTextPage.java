package com.test.getTextMethod;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class UsingDynamicElementTextPage {

	@FindBy(how=How.XPATH,using="//span[@rel='current_population']/child::span[8]")
	private WebElement dynamicEle;
	 
	public UsingDynamicElementTextPage(RemoteWebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public String getTextOfDynamicEle() {
		return dynamicEle.getText();
	}
}
