package com.test.getAttributeMethod;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class GetMaxLengthPage {
	
	//declare and locate element
	@FindBy(how=How.NAME,using="q")
	private WebElement search;
	
	
	//constructor
	public GetMaxLengthPage(RemoteWebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyMaxlLength(int expected) {
		
		try {
			String value=search.getAttribute("maxlngth");
			System.out.println(value);
			int actual= Integer.parseInt(value);
			
			System.out.println(actual);
			return(actual==expected)?true:false;//ternary operator
		}catch (Exception e) {
			System.out.println("else block executed");
			return false;
		}
		
		
	}

}
