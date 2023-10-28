package com.test.isSelectesMethod;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckRadioButtonIsSelected {
	private RemoteWebDriver driver;
	
	@FindBy(xpath = "//input[@name='fav_language'][1]")
	private WebElement radioCheck;
	
	public CheckRadioButtonIsSelected(RemoteWebDriver driver) {
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}
	public void clickRadioBtn() {
		driver.switchTo().frame("iframeResult");
		radioCheck.click();
	}
	
	public boolean isRadioSelected() {
		if(radioCheck.isDisplayed()) {
			if(radioCheck.isEnabled()) {
				if(radioCheck.isSelected()) {
					return true;
				}else
					return false;
			}else
				return false;
		}else
			return false;
	}
}
