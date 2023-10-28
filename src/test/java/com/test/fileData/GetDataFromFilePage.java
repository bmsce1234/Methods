package com.test.fileData;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GetDataFromFilePage {

	@FindBy(name="identifier")
	private WebElement uName;
	
	@FindBy(xpath = "//span[text()='Next']/parent::button")
	private WebElement nextBtn;
	
	@FindBy(name = "password")
	private WebElement password;
	
	@FindBy(xpath = "//span[text()='Next']/parent::button")
	private WebElement nextPassBtn;
	
	public GetDataFromFilePage(RemoteWebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void fillUserName(String name) {
		uName.sendKeys(name);
	}
	
	public void clickUNBtn() {
		nextBtn.click();
	}
	
	public void fillPassword(String name) {
		password.sendKeys(name);
	}
	
	public void clickPWDBtn() {
		nextPassBtn.click();
	}
}
