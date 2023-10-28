package com.driver.switchTo;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SwitchToAndActiveElement {

	public static void main(String[] args) throws Exception{
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		
		driver.switchTo().activeElement().sendKeys("ankushd.tech527@gmail.com",Keys.TAB);
		driver.switchTo().activeElement().sendKeys("ankush914520427",Keys.TAB,Keys.TAB);
		Thread.sleep(2000);
		driver.switchTo().activeElement().click();
		Thread.sleep(2000);
		
		driver.close();

	}

}
