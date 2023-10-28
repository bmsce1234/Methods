package com.getSize.getLocation.getRect;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Test51Page {
	
	@FindBy(xpath = "//div[text()='Search Flight']")
	private WebElement getDetailEle;
	
	public Test51Page(RemoteWebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public int[] getDetails1() {
		int details[]=new int[4];
		details[0]=getDetailEle.getSize().height;
		details[1]=getDetailEle.getSize().width;
		details[2]=getDetailEle.getLocation().getX();
		details[3]=getDetailEle.getLocation().getY();
		return details;
	}
	
	public int[] getDetails2() {
		int details[]=new int[4];
		details[0]=getDetailEle.getRect().getHeight();
		details[1]=getDetailEle.getRect().getWidth();
		details[2]=getDetailEle.getRect().getX();
		details[3]=getDetailEle.getRect().getY();
		return details;
	}

}
