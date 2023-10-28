package com.test.clearMethod;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ElementHideByAnotherPage {
	
	@FindBy(how=How.NAME,using="q")
	private WebElement search;
	
	@FindBy(xpath = "(//button)[2]")
	private WebElement cancel;
	
	public ElementHideByAnotherPage(RemoteWebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void fillSearch(String value) {
		search.sendKeys(value);
	}
	
	public void clearSearch() {
		search.clear();
	}
	
	public void clickCancle() {
		cancel.click();
	}

}
