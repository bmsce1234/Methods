package com.test.carouselSlider;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import stevejobs.WebsiteUtilities;

public class DivTagCarouselSliderRunner {

	public static void main(String[] args)throws Exception {
		WebsiteUtilities utility=new WebsiteUtilities();
		RemoteWebDriver driver=utility.getBrowserName("chrome");
		utility.launchSite(driver, "https://www.flipkart.com", 5000);
		
		try {
			driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
			Thread.sleep(2000);
		}catch(Exception e) {
			System.out.println("banner not came");
		}
		
		DivTagCarouselSliderPage page =new DivTagCarouselSliderPage(driver);
		System.out.println(page.getCountOfSlides());
		System.out.println(page.getTypeOfCarouselSlider());
		
		if(page.areSlidesMoving()) {
			System.out.println(page.getSlidesMovingDirectionInCarouselSlider());
			List<String> values=page.getAdditionalInformationOfSlidesInCarouselSlider();
			
			for(String value:values) {
				System.out.println(value);
			}
			
			
			if(page.verifySlidesRotationInCarouselSlider()) {
				System.out.println("first slide is coming after last slide");
			}
			else{
				System.out.println("first slide is not coming after last slide");
			}
		}else {
			System.out.println("no slides not moving");
		}
		
		//close driver
		utility.closeBrowser(driver);
	}
}