package com.driver.switchTo;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameAndDefaultContentAndParentFrame {

	public static void main(String[] args)throws Exception {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		
		driver.manage().window().maximize();
		//1-switch to frame 1
		driver.switchTo().frame(0);
		
		//2-fill the textbox
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Job lagude lovekar");
		Thread.sleep(3000);
		//3-switch inside frame inside frame
		driver.switchTo().frame(0);
		
		//4- select the checkbox
		driver.findElement(By.id("a")).click();
		Thread.sleep(3000);
		
		//5- come back to parent frame
		driver.switchTo().parentFrame();
		
		//6-clear the textbox
		driver.findElement(By.xpath("//input[@type='text']")).clear();
		Thread.sleep(3000);
		
		//7-back to page
		driver.switchTo().defaultContent();
		
		//8-switch to second frame
		driver.switchTo().frame(1);
		
		//9-select the drop-down
		driver.findElement(By.id("animals")).click();
		Thread.sleep(3000);
		
		//10- come out to page level
		driver.switchTo().defaultContent();
		
		
		//close driver
		//driver.close();

	}
}