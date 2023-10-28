package com.test.getCssValuMethod;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MouseOverUnderlinedPage {
	
	private RemoteWebDriver driver;

	@FindBy(how=How.LINK_TEXT,using = "Images")
	private WebElement imagesLink;
	
	public MouseOverUnderlinedPage(RemoteWebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void moveMouse() {
		Actions action=new Actions(driver);
		action.moveToElement(imagesLink).perform();
	}
	
	public boolean validatelink(String expected) {
		try {
			String actual= imagesLink.getCssValue("text-decoration");
			System.out.println(actual);
			
			return(actual.endsWith(expected))?true:false;
		}catch(Exception e) {
			System.out.println("catch block");
			return false;
		}
	}
}
