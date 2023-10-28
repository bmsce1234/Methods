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

public class HiddenElementPage {

	@FindBy(name="hiddenPassword")
	private WebElement hiddenPwd;
	
	public HiddenElementPage(RemoteWebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public String getScreenshot()throws Exception {
		SimpleDateFormat dFormat=new SimpleDateFormat("dd-MMM-yyyy-hh-mm-ss");
		Date date=new Date();
		String dateFormat=dFormat.format(date);
		
		File src=hiddenPwd.getScreenshotAs(OutputType.FILE);
		File dest=new File("target\\"+dateFormat+".png");
		FileHandler.copy(src, dest);
		String filePath=dest.getAbsolutePath();
		return filePath;
	}
}