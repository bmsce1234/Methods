package com.test.findElements;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetAllinputTag {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		RemoteWebDriver driver=new ChromeDriver();
		
		driver.get("http://www.google.com");
		
		List<WebElement> ele=driver.findElements(By.xpath("//input"));
		
		List<WebElement> visibleEle=new ArrayList<WebElement>();
		
		for(WebElement e:ele) {
			if(e.isDisplayed())
				visibleEle.add(e);
		}
		
		for(WebElement e:visibleEle) {
			System.out.println(e.getAccessibleName());
		}
		
		System.out.println(visibleEle.size());
		
		System.out.println(ele.size());
		
		driver.close();
	}
}
