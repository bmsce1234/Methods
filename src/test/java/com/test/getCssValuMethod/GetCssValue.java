package com.test.getCssValuMethod;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetCssValue {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("http://www.google.com");
		
		WebElement e1=driver.findElement(By.name("q"));
		
	    System.out.println(e1.getAttribute("name"));
		
		System.out.println(e1.getCssValue("background-color"));
		
		driver.close();
	}

}
