package com.test.getTextMethod;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class getTextOfOneEle {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("http://www.gmail.com");
		
		WebElement e1=driver.findElement(By.xpath("//a[@jsname='JFyozc']"));
		
		System.out.println(e1.getText());

		driver.close();
	}

}
