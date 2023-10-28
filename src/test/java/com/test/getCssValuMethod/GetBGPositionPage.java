package com.test.getCssValuMethod;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class GetBGPositionPage {

	/*@FindBy(how=How.XPATH,using="//a[@aria-label='Google apps']")
	private WebElement clickGoogleApps;*/
	
	//@FindBy(xpath  ="(//div[@class='CXW8mj'])[2]")
	@FindBy(xpath = "(//div[text()='Fashion']/preceding-sibling::div)/div")
	private WebElement fashion;
	
	public GetBGPositionPage(RemoteWebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	/*public void clickGoogleApps() {
		clickGoogleApps.click();
	}*/
	
	public boolean verifyBGPosition(String expected) {
		try {
		   String actual=fashion.getCssValue("position");
		 System.out.println(actual);
		   return(actual.equals(expected))?true:false;
		}catch(Exception e) {
			System.out.println("catch block"+ e.getMessage());
			return false;
		}
	}
}
