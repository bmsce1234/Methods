package com.driver.manage.cookies;
import java.io.File;
import java.util.Date;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreatingOwnCookiesTwoWays {

	public static void main(String[] args)throws Exception {
		
		//way 1) create a session cookie using " Cookie" class
		Cookie cookie1=new Cookie("magnitia","abdul kalam");
		
		//add tomorrow expiry 
		Date today=new Date();
		Date tomorrow=new Date(today.getTime()+(1000*60*60*24));
		
		//way 2) create any type of cookie using "Cookie.Builder" inner class
		Cookie.Builder builder=new Cookie.Builder("id name", "team work");
		Cookie cookie2=builder.domain("www.youtube.com").path("/").expiresOn(tomorrow).isSecure(true).build();

	
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		driver.get("https://www.youtube.com");
		Thread.sleep(3000);
		driver.manage().window().maximize();
		
		
		//before adding cookies take screen-shot
		File dest1=new File("target\\beforeAddingCookies.png");
		File src1=driver.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src1, dest1);
		Thread.sleep(3000);
		
		
		//add our cookies to browser and refresh it
		driver.manage().addCookie(cookie1);
		driver.manage().addCookie(cookie2);
		driver.navigate().refresh();
		
		
		//after adding cookies take screen-shot
		File dest2=new File("target\\AfterAddingCookies.png");
		File src2=driver.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src2,dest2);
		
		//collect all present cookies
		Set<Cookie> allCookies=driver.manage().getCookies();
		for(Cookie c:allCookies) {
			System.out.println(c.getName());
		}
		
		//close driver
		driver.close();
	}

}
