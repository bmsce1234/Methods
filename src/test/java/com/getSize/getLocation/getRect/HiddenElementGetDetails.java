package com.getSize.getLocation.getRect;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HiddenElementGetDetails {

	@FindBy(name="hiddenPassword")
	private WebElement hiddenPwd;
	
	public HiddenElementGetDetails(RemoteWebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public int[] getDetails(int index) {
		int[] q=new int[4];
		if(index==1) {
			int[] x=new int[4];
			x[0]=hiddenPwd.getSize().getHeight();
			x[1]=hiddenPwd.getSize().getWidth();
			x[2]=hiddenPwd.getLocation().getX();
			x[3]=hiddenPwd.getLocation().getY();
			return x;
		}else if(index==2) {
			int[] x=new int[4];
			x[0]=hiddenPwd.getRect().getHeight();
			x[1]=hiddenPwd.getRect().getWidth();
			x[2]=hiddenPwd.getRect().getX();
			x[3]=hiddenPwd.getRect().getY();
			return x;
		}else {
			System.out.println("wrong index");
			return q;
		}
	}
}