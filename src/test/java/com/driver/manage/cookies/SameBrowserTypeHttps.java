package com.driver.manage.cookies;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SameBrowserTypeHttps {

	public static void main(String[] args)throws Exception {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		driver.get("http://www.gmail.com");
		Thread.sleep(3000);
		driver.manage().window().maximize();
		
		driver.findElement(By.name("identifier")).sendKeys("info.anku527@gmail.com");
		driver.findElement(By.xpath("//span[text()='Next']/parent::button")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.name("password")).sendKeys("ankush9145204527",Keys.ENTER);
		//driver.findElement(By.xpath("//span[text()='Next']/parent::button")).click();
		Thread.sleep(5000);
		
		//create a new Window and switch to window and launch same site
		driver.switchTo().newWindow(WindowType.TAB);
		Set<String> s=driver.getWindowHandles();
		List<String> l=new ArrayList<String>(s);
		
		driver.switchTo().window(l.get(1));
		driver.get("http://www.gmail.com");

		if(driver.findElement(By.xpath("//div[text()='Compose']")).isDisplayed()) {
			System.out.println("in same browser session cookie is working");
		}else {
			System.out.println("in same browser session cookie is not working");
		}
		
		driver.quit();

	}
}
