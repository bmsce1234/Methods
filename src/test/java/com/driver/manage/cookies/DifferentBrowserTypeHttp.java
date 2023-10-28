package com.driver.manage.cookies;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DifferentBrowserTypeHttp {

	public static void main(String[] args) throws Exception{
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://expenseus.com");
		Thread.sleep(3000);
		
		driver.findElement(By.linkText("Login")).click();
		Thread.sleep(3000);
		driver.findElement(By.name("user[email]")).sendKeys("magnitiait@gmail.com");
		driver.findElement(By.name("user[password]")).sendKeys("abdulkalam");
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		Thread.sleep(3000);
		
		//on firefox browser
		WebDriverManager.firefoxdriver().setup();
		RemoteWebDriver driver2=new FirefoxDriver();
		driver.manage().window().maximize();
		
		//get all cookies from chrome browser
		Set<Cookie> s=driver.manage().getCookies();
		
		//add to firefox browser
		for(Cookie c:s) {
			driver2.manage().addCookie(c);
		}
		
		driver.get("http://expenseus.com");
		Thread.sleep(3000);
		

		if(driver.findElement(By.linkText("Logout")).isDisplayed()) {
			System.out.println("in same browser session cookie is working");
		}else {
			System.out.println("in same browser session cookie is not working");
		}
		
		driver.quit();
	}
}
