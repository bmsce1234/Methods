package com.test.getCssValuMethod;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class GetColorOfFPPage {

	@FindBy(how=How.XPATH,using="//button[text()='Forgot email?']")
	private WebElement forgotPWD;
	
	public GetColorOfFPPage(RemoteWebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyColor(String expectedColor) {
		try{
			String actualColor=forgotPWD.getCssValue("color");
			System.out.println(actualColor);
			return (actualColor.equals(expectedColor))?true:false;
		}catch(Exception e) {
			System.out.println("catch block");
			return false;
		}
	}
}
