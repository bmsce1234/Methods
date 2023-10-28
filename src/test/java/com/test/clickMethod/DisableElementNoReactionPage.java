package com.test.clickMethod;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class DisableElementNoReactionPage {
	
	private RemoteWebDriver driver;
	
	@FindBy(name="lname")
	private WebElement invisibleTextBox;
	
	public DisableElementNoReactionPage(RemoteWebDriver driver) {
		this.driver=driver;
		
		AjaxElementLocatorFactory aFactory= new AjaxElementLocatorFactory(driver, 20);
		PageFactory.initElements(aFactory, this);
	}
	
	public void clickInvisible() {
		driver.switchTo().frame("iframeResult");
		invisibleTextBox.click();
	}

}
