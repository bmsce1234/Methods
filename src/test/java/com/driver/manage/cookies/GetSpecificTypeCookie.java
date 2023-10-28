package com.driver.manage.cookies;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetSpecificTypeCookie {

	public static void main(String[] args)throws Exception {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		driver.get("http://www.gmail.com");
		Thread.sleep(3000);
		driver.manage().window().maximize();
		
		Set<Cookie> s=driver.manage().getCookies();
		System.out.println("size of cookies after launch site:: "+s.size());
		
		driver.findElement(By.name("identifier")).sendKeys("info.anku527@gmail.com");
		driver.findElement(By.xpath("//span[text()='Next']/parent::button")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.name("password")).sendKeys("ankush9145204527",Keys.ENTER);
		//driver.findElement(By.xpath("//span[text()='Next']/parent::button")).click();
		Thread.sleep(5000);
		
		s=driver.manage().getCookies();
		System.out.println("size of cookies after login:: "+s.size());
		
		
		for(Cookie c:s) {
			System.out.println("cookie name "+c.getName());
			if(c.isHttpOnly()) {
				//when cookie is http
				if(c.getName().equalsIgnoreCase("session-id")||c.getName().equalsIgnoreCase("SID")) {
					System.out.println(c.getName()+" is session cookie without secure");
				}else if(c.getName().equalsIgnoreCase("session-id-time")) {
					System.out.println(c.getName()+" persistent cookie without secure");
					System.out.println(c.getName()+" it expires on "+c.getExpiry());
				}else {
					System.out.println(c.getName()+" is http-only cookie");
				}
			}else if(c.isSecure()) {
				if(c.getName().equalsIgnoreCase("session-id")||c.getName().equalsIgnoreCase("SID")) {
					System.out.println(c.getName()+" is session cookie with secure");
				}else if(c.getName().equalsIgnoreCase("session-id-time")) {
					System.out.println(c.getName()+" persistent cookie with secure");
					System.out.println(c.getName()+" it expires on "+c.getExpiry());
				}else {
					System.out.println(c.getName()+" is secure-only cookie");
				}
			}else if(c.getDomain().contains("google.com")) {
				System.out.println(c.getName()+" is super cookie");
			}else if(c.getDomain().contains("gmail.com")) {
				System.out.println(c.getName()+" is same-site cookie");
			}else {
				System.out.println(c.getName()+" is third-party cookie");
			}
		}//for
		
		driver.findElement(By.xpath("//a[contains(@aria-label,'Google Account:')]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[text()='Sign out']")).click();
		Thread.sleep(5000);
		

		s=driver.manage().getCookies();
		System.out.println("size of cookies after logout:: "+s.size());
		
		//close driver
		driver.close();
	}
}