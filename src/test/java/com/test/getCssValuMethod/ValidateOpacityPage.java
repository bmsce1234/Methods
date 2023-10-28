package com.test.getCssValuMethod;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ValidateOpacityPage {
	
	private RemoteWebDriver driver;
	
	@FindBy(xpath = "//img[@alt='Forest']")
	private WebElement overForestImg;
	
	@FindBy(xpath = "//img[@alt='Mountains']")
	private WebElement overMountainImg;
	
	@FindBy(xpath = "//img[@alt='Italy']")
	private WebElement overItalyImg;
	
	public ValidateOpacityPage(RemoteWebDriver driver) {
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}
	
	public void overMouse() throws InterruptedException {
		driver.switchTo().frame("iframeResult");
		Actions action=new Actions(driver);
		action.moveToElement(overForestImg).perform();
		
		/*Thread.sleep(5000);
		action.moveToElement(overMountainImg).perform();
		
		Thread.sleep(5000);
		action.moveToElement(overItalyImg).perform();*/
	}
	
	public boolean verifyOpacity() {
		try {
			String o1=overForestImg.getCssValue("opacity");
			String o2=overMountainImg.getCssValue("opacity");
			String o3=overItalyImg.getCssValue("opacity");
			System.out.println(o1+" "+o2+" "+o3);
			//if(o1.equals("1")&&o2.equals("1")&&o3.equals("1")) {
			if(o1.equals("1")) {
				return true;
			}else {
				return false;
			}
		}catch (Exception e) {
			return false;
		}
	}
}
