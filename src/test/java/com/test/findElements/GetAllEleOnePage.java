package com.test.findElements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetAllEleOnePage {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		RemoteWebDriver driver=new ChromeDriver();
		
		driver.get("http://www.google.com");
		
		List<WebElement> allEle=driver.findElements(By.xpath("//*"));
		
		System.out.println(allEle.size());
		
		driver.close();

	}

}
