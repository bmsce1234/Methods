package com.test.BrokenLinks;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class BrokenLinksPage {

	private RemoteWebDriver driver;
	
	@FindBys({
		@FindBy(xpath = "//*")
	})
	private List<WebElement> allEle;
	
	public BrokenLinksPage(RemoteWebDriver driver) {
		PageFactory.initElements(driver, this); 
	}
	
	public List<String> findBrokenLinks()throws Exception{
		List<String> brokenLinks=new ArrayList<String>();
		
		for(WebElement ele:allEle) {
			if(ele.getAttribute("href")!=null) {
				String address=ele.getAttribute("href");
				
				if(address.startsWith("https")||address.startsWith("http")) {
					URL url=new URL(address);
					
					HttpURLConnection httpurl=(HttpURLConnection) url.openConnection();
					
					httpurl.connect();
					
					if(httpurl.getResponseCode()!=200) {
						brokenLinks.add(address);
					}//if
					httpurl.disconnect();
				}//if
			}//if
		}//for
		
		return brokenLinks;
	}//method
	
	public String isBrokenLink(WebElement e)throws Exception {
		if(e.getAttribute("href")!=null) {
			String address=e.getAttribute("href");
			if(address.startsWith("https")||address.startsWith("http")) {
				URL url=new URL(address);
				
				HttpURLConnection hurl=(HttpURLConnection) url.openConnection();
				
				hurl.connect();
				
				if(hurl.getResponseCode()!=200) {
					return "broken link";
				}else {
					return "working link";
				}
			}
		}
		return "not a hyper link";
	}
}
