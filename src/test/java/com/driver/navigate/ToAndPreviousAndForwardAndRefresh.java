package com.driver.navigate;

import java.sql.DriverManager;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ToAndPreviousAndForwardAndRefresh {

	public static void main(String[] args)throws Exception {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//int st=(int)System.currentTimeMillis();
		driver.get("https://www.magnitia.com");//it waits until the page is loading
		Thread.sleep(5000);
		driver.navigate().to("https://www.google.com");
		Thread.sleep(5000);
		//back to previous
		driver.navigate().back();//magnitia page
		Thread.sleep(3000);
		
		driver.navigate().forward();//google page
		Thread.sleep(3000);
		
		driver.navigate().refresh();//google page
		Thread.sleep(3000);
		//int et=(int)System.currentTimeMillis();//it does not wait until page is loading
		//System.out.println("duration is:: "+(et-st));
		
		driver.close();

	}
}
