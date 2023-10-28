package com.test.getTextMethod;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HiddenElement {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("https://semantic-ui.com/modules/dropdown.html#/definition");
		
		//WebElement e=driver.findElement(By.xpath("//div[text()='File']"));//get parent text
		
		//WebElement e=driver.findElement(By.name("gender"));
		
		//getting hidden element data but it return null/blank
		WebElement e=driver.findElement(By.xpath("(//div[@class='text'])[1]/following-sibling::div/child::div[1]"));
		
		//getting hidden element data by using javaScript it return value
		String x=(String) driver.executeScript("return(arguments[0].textContent)", e);
		//System.out.println(e.getText());
		System.out.println(x);
		
		driver.close();
	}

}
