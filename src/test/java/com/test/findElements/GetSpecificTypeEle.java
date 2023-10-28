package com.test.findElements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetSpecificTypeEle {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		RemoteWebDriver driver=new ChromeDriver();
		
		driver.get("http://www.gmail.com");
		
		List<WebElement> tableEle=driver.findElements(By.xpath("//table"));
		System.out.println(tableEle.size());
		
		List<WebElement> inputTypeEle=driver.findElements(By.xpath("//input[@type='text']"));
		System.out.println(inputTypeEle.size());
		
		List<WebElement> linkEle=driver.findElements(By.xpath("(//a)|(//href)|(//link)|(//base)"));
		System.out.println(linkEle.size());

	}

}