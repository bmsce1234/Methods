package com.test.clickMethod;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class ElementNotInteractableException {
 
	private RemoteWebDriver driver;
	
	@FindBy(how=How.NAME,using = "hiddenPassword")
	private WebElement hiddenButton;
	
	public ElementNotInteractableException(RemoteWebDriver driver) {
		this.driver=driver;
		
		AjaxElementLocatorFactory alfactory=new AjaxElementLocatorFactory(driver, 20);
		PageFactory.initElements(alfactory, this);
	}
	
	public void clickHiddenButton() {
		hiddenButton.click();
	}
}
