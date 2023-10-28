package com.test.getTextMethod;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GettingDynamicDataByStaticParent {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.worldometers.info/world-population/");
		
		/*//it return values of parent and descedent also
		WebElement e=driver.findElement(By.xpath("//span[@rel='current_population']"));
		System.out.println(e.getText());*/
		
		
		/* it also be return 20 time dynamic values no chance of StaleElementReferanceException*/
		for(int i=0;i<=20;i++) {
			WebElement e=driver.findElement(By.xpath("//span[@rel='current_population']"));
			System.out.println(e.getText());
		}
		
		
		/*//it will throw StaleElementReferenceException coz of DOM will change and the element is dynamic
		//its value will change regulerly
		for(int i=0;i<=10;i++) {
			WebElement e=driver.findElement(By.xpath("//span[@rel='current_population']/child::span[8]"));
			System.out.println(e.getText());
		}*/
		
		driver.close();
		
	}
}
