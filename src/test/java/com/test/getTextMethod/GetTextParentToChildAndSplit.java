package com.test.getTextMethod;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetTextParentToChildAndSplit {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("http://www.gmail.com");
		
		//getting text of parent element it will return descedant text also
		WebElement e1=driver.findElement(By.xpath("//div[starts-with(text(),'Not your computer?')]"));
		String x=e1.getText();
		System.out.println(x);
		
		WebElement e2=driver.findElement(By.xpath("//div[starts-with(text(),'Not your computer?')]"));
		System.out.println(driver.executeScript("return(arguments[0].childNodes[0].textContent)", e2));
		/*String x="ankush-dongre";
		String y[]=x.split("-");
		System.out.println(y.length);
		System.out.println(y[0]);
		System.out.println(y[1]);*/
		
		
		driver.close();
	}

}
