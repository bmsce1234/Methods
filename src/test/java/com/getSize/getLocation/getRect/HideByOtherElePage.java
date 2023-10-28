package com.getSize.getLocation.getRect;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HideByOtherElePage {

	@FindBy(xpath = "//img[@alt='Electronics']")
	private WebElement electrEle;
	
	public HideByOtherElePage(RemoteWebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public int[] getDetails1() {
		int details[]=new int[4];
		details[0]=electrEle.getSize().height;
		details[1]=electrEle.getSize().width;
		details[2]=electrEle.getLocation().getX();
		details[3]=electrEle.getLocation().getY();
		return details;
	}
	
	public int[] getDetails2() {
		int details[]=new int[4];
		details[0]=electrEle.getRect().getHeight();
		details[1]=electrEle.getRect().getWidth();
		details[2]=electrEle.getRect().getX();
		details[3]=electrEle.getRect().getY();
		return details;
	}
}
