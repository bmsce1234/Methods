package com.test.clearMethod;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DisabledElementPage {
	
	private RemoteWebDriver driver;

	@FindBy(how=How.NAME,using = "lname")
	private WebElement lName;
	
	public DisabledElementPage(RemoteWebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void fillLName(String value) {
		driver.switchTo().frame("iframeResult");
		lName.sendKeys(value);
	}
	
	public void clearLName() {
		driver.switchTo().frame("iframeResult");
		lName.clear();
	}
}
