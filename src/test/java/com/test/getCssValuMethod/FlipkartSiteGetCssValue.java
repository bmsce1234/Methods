package com.test.getCssValuMethod;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipkartSiteGetCssValue {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("http://www.flipkart.com");
		
		WebElement e= driver.findElement(By.name("q"));
		String x=e.getCssValue("font-size");
		
		System.out.println(x.length());
		
		if(x.equals("14px")) {
			System.out.println("script executed successfully");
		}else {
			System.out.println("script not executed");
		}
		
		
		driver.close();

	}

}
