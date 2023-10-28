package com.test.findElements;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CountVisibleAndDisableELE {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		RemoteWebDriver driver=new ChromeDriver();
		
		driver.get("http://www.google.com");
		
		List<WebElement> ele=driver.findElements(By.xpath("//*"));
		
		List<WebElement> hiddenEle=new ArrayList<WebElement>();
		List<WebElement> visibleEle=new ArrayList<WebElement>();
		
		for(WebElement e:ele) {
			if(e.isDisplayed()) 
				visibleEle.add(e);
			else
				hiddenEle.add(e);
		}
		
		System.out.println("all elements in page are "+ele.size());
		System.out.println("visible elements in current page are "+visibleEle.size());
		System.out.println("hidden elements in current page are "+hiddenEle.size());
		
		driver.close();

	}

}
