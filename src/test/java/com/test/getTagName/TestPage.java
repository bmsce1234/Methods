package com.test.getTagName;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestPage {

	@FindBy(name="q")
	private WebElement getTagName;
	
	public TestPage(RemoteWebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	/*public String getTagName() {
		String text=getTagName.getTagName();
		return text;
	}*/
	
	public boolean verifyTagName(String expected) {
		String actual=getTagName.getTagName();
		
		return actual.endsWith(expected)?true:false;
	}
}
