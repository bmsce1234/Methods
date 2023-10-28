package com.WebElement.GetScreenshotAs;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class getScreenShotElementPage {

	
	@FindBy(xpath = "//div[@class='InyRMC _3Il5oO']")
	WebElement ele;
	
	public getScreenShotElementPage(RemoteWebDriver driver) {
		AjaxElementLocatorFactory afactory =new AjaxElementLocatorFactory(driver,20);
		
		PageFactory.initElements(afactory, this);
	}
	
	public String getScreenshot()throws Exception {
		/*File src= ele.getScreenshotAs(OutputType.FILE);
		File dest=new File("target\\screenshot.png");
		FileHandler.copy(src, dest);
		String filepath=dest.getAbsolutePath();
		return filepath;*/
		
		
		SimpleDateFormat dFormat=new SimpleDateFormat("dd-MMM-yyyy-hh-mm-ss");
		Date date=new Date();
		//String datePattern=dFormat.format(date);
		
		File src=ele.getScreenshotAs(OutputType.FILE);
		//File dest=new File("target\\"+datePattern+".png");
		File dest=new File("target\\"+dFormat.format(date)+".png");
		FileHandler.copy(src, dest);
		String filePath=src.getAbsolutePath();
		return filePath;
	}
	
}
