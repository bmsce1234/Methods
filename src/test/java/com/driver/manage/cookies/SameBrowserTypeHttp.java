package com.driver.manage.cookies;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SameBrowserTypeHttp {

	public static void main(String[] args)throws Exception {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		driver.get("http://expenseus.com");
		Thread.sleep(3000);
		
		driver.findElement(By.linkText("Login")).click();
		Thread.sleep(3000);
		driver.findElement(By.name("user[email]")).sendKeys("magnitiait@gmail.com");
		driver.findElement(By.name("user[password]")).sendKeys("abdulkalam");
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		Thread.sleep(3000);
		
		//create a new Window and switch to window and launch same site
		driver.switchTo().newWindow(WindowType.TAB);
		Set<String> s=driver.getWindowHandles();
		List<String> l=new ArrayList<String>(s);
		
		driver.switchTo().window(l.get(1));
		driver.get("http://expenseus.com");

		if(driver.findElement(By.linkText("Logout")).isDisplayed()) {
			System.out.println("in same browser session cookie is working");
		}else {
			System.out.println("in same browser session cookie is not working");
		}
		
		driver.quit();
	}
}