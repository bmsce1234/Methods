package com.driver.manage.cookies;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DifferentBrowserTypeHttps {

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
		
		driver.get("http://www.gmail.com");
		Thread.sleep(3000);
		
		if(driver.findElement(By.linkText("Logout")).isDisplayed()) {
			System.out.println("in same browser session cookie is working");
		}else {
			System.out.println("in same browser session cookie is not working");
		}
		
		driver.quit();
	}
}
