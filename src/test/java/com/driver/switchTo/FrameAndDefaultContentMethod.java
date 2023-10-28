package com.driver.switchTo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameAndDefaultContentMethod {

	public static void main(String[] args)throws Exception {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_input_test");
		driver.manage().window().fullscreen();
		
		//way 1 using id or name
	    //driver.switchTo().frame("iframeResult");
		
		//way 2 using index
		//driver.switchTo().frame(2);
		
		
		//way 3 using element
		WebElement e = driver.findElement(By.name("iframeResult"));
		driver.switchTo().frame(e);
		
		driver.findElement(By.name("fname")).sendKeys("ankush");
		Thread.sleep(5000);
		driver.findElement(By.name("lname")).sendKeys("dongre");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		Thread.sleep(5000);
		
		driver.switchTo().defaultContent();
		
		driver.close();
	}
}