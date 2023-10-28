package com.test.pagination;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import stevejobs.WebsiteUtilities;

public class CountEachPageResults {

	public static void main(String[] args)throws Exception {
	
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter browser name:: ");
		String bn=sc.nextLine();
		System.out.println("Enter a word");	
		String word=sc.nextLine();
		sc.close();
		
		WebsiteUtilities utility=new WebsiteUtilities();
		RemoteWebDriver driver=utility.getBrowserName(bn);
		utility.launchSite(driver, "http://www.google.com", 5000);
		
		driver.findElement(By.name("q")).sendKeys(word,Keys.ENTER);
		int pageNumber=1;
		int countAll=0;
		
		while(true) {
			List<WebElement> allResults=driver.findElements(By.xpath("//div[@class='g']"));
			List<WebElement> visibleEle=new ArrayList<WebElement>();
			
			for(WebElement ele:allResults) {
				if(ele.isDisplayed()) {
					visibleEle.add(ele);
				}
			}
			System.out.printf("%d page visible results are %d %n",pageNumber,visibleEle.size());
			countAll=countAll+visibleEle.size();
			
			try {
				pageNumber++;
				driver.findElement(By.linkText(pageNumber+ "")).click();
			}catch (Exception e) {
				break;
			}
			
		}//while
		
		System.out.println("All pages results are "+countAll);
		
		//close driver
		utility.closeBrowser(driver);
	}
}
