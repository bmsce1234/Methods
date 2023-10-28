package com.test.findElements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ByWrongSyntaxAndEle {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		RemoteWebDriver driver=new ChromeDriver();
		
		driver.get("http://www.google.com");
		
		//List<WebElement> ele=driver.findElements(By.xpath("//input[@name=q']"));
		//syntax wrong InvaliSelectorException
		
		List<WebElement> ele=driver.findElements(By.xpath("//input[@name='magn']"));
		System.out.println(ele.size());//wrong element return empty list
		
		driver.close();

	}

}
