package com.driver.manage.cookies;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CookiesExample {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com");
		
		//1) getCookies
		Set<Cookie> allCookies=driver.manage().getCookies();
		List<Cookie> cookiesList=new ArrayList<>(allCookies);
		
		System.out.println("size of all cookies:: "+cookiesList.size());
		
		for(Cookie c:allCookies) {
			System.out.println(c.getName()+"  "+c.getDomain()+" "+c.getPath()+" "+c.getValue()+" "+c.getExpiry());
		}
		//2) addCookie //create a new Cookie and add it
		Cookie c1=new Cookie("magniti", "ankush");
		driver.manage().addCookie(c1);
		
		//3) getCookieNamed	
		System.out.println(driver.manage().getCookieNamed(cookiesList.get(0).getName()));
		
		//4) deleteCookie  
		driver.manage().deleteCookie(cookiesList.get(1));
		
		//5) deleteCookieNamed
		driver.manage().deleteCookieNamed(cookiesList.get(0).getName());
		
		//6) deleteAllCookies
		driver.manage().deleteAllCookies();
		
		//close driver
		driver.close();

	}
}
