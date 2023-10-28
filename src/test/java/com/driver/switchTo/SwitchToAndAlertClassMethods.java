package com.driver.switchTo;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SwitchToAndAlertClassMethods {

	public static void main(String[] args)throws Exception {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
		driver.manage().window().maximize();
		//1-switch to frame 
		driver.switchTo().frame("iframeResult");
		Thread.sleep(3000);
		//click on button
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		Thread.sleep(3000);
		
		//2-switch to alert  
		driver.switchTo().alert().dismiss();;
		
		//3-driver obj come back to current frame
		Thread.sleep(3000);
		String x=driver.findElement(By.id("demo")).getText();
		System.out.println(x);		
		
		/*//click on the button
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		Thread.sleep(3000);
		
		//4- switch to alert
		driver.switchTo().alert().dismiss();
		
		//5-driver obj come back to current frame
		Thread.sleep(5000);
		String y=driver.findElement(By.id("demo")).getText();
		System.out.println(y);
		//6-come back to current page
		Thread.sleep(3000);*/
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		
		//close driver
		driver.close();
	}
}
