package com.test.BrokenLinks;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBrokenLinks {

	public static void main(String[] args)throws Exception {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		driver.get("http://www.amazon.com");
		
		List<WebElement> allElements=driver.findElements(By.xpath("//*"));
		int allhyperLinks=0;
		int brokenlinksCount=0;
		for(WebElement ele:allElements) {
			if(ele.getAttribute("href")!=null) {
				String linkText=ele.getAttribute("href");
				if(linkText.startsWith("https")||linkText.startsWith("http")) {//hyper links
					allhyperLinks++;
					URL u=new URL(linkText);
					
					HttpURLConnection uconnect=(HttpURLConnection) u.openConnection();
					//URLConnection uconnect=u.openConnection();
					uconnect.connect();
					
					if(uconnect.getResponseCode()==200) {
						System.out.println("link is working link");
					}else {
						System.out.println("link is broken link because"+uconnect.getResponseMessage());
						brokenlinksCount++;
					}
					uconnect.disconnect();
				}
			}
		}
		
		System.out.println("all hyperlinks count is  "+allhyperLinks);
		System.out.println("all broken hyperlinks count is "+brokenlinksCount);
		//close driver
		driver.close();
		
	}
}
