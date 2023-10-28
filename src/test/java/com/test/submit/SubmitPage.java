package com.test.submit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubmitPage {

	@FindBy(xpath = "//button[@class='L0Z3Pu']")
	private WebElement submitBtn;
	
	public SubmitPage(RemoteWebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void submitBtn() {
		submitBtn.submit();
		System.out.println("executed successfully");
	}
}
