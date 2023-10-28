package com.test.findElements;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AllVisibleEleDisplayDetails {
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		RemoteWebDriver driver=new ChromeDriver();
		
		driver.get("http://www.gmail.com");
		
		List<WebElement> allEle=driver.findElements(By.xpath("//*"));
		
		List<WebElement> visibleEle=new ArrayList<WebElement>();
		
		for(WebElement ele:allEle) {
			try {
				if(ele.isDisplayed())
					visibleEle.add(ele);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		for(WebElement ele:visibleEle) {
			try {
				String tagName=ele.getTagName();
				String attrName=ele.getDomAttribute("class");
				String propertyName=ele.getDomProperty("className");
				String color=ele.getCssValue("background-color");
				System.out.printf("%s, %s, %s, %s%n",tagName,attrName,propertyName,color);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}	
		}//for
	}
}
