package com.test.carouselSlider;

import org.openqa.selenium.remote.RemoteWebDriver;

import stevejobs.WebsiteUtilities;

public class UlTagCarouselSliderRunner {

	public static void main(String[] args)throws Exception {
		WebsiteUtilities utility =new WebsiteUtilities();
		RemoteWebDriver driver = utility.getBrowserName("chrome");
		
		utility.launchSite(driver, "https://www.ebay.com", 5000);
		ULTagAarouselSliderPage page =new ULTagAarouselSliderPage(driver);
		
		System.out.println(page.getCountOfAllSlides());
		
		System.out.println(page.getTypeOfMovingSlides());
		
		if(page.areSlidesMoving()) {
			System.out.println("slides are moving");
			
			System.out.println(page.getDirectionOfSlidesInCarouselSlider());
			
			System.out.println(page.getAdditionalInfoOfSlidesInCarsoulerSlider());
			
			if(page.verifyMovingSlidesInCarouselSlider()) {
				System.out.println("slides are moving correctly");
			}else {
				System.out.println("slides are not moving correctly");
			}
			
		}else {
			System.out.println("slides are not moving");
		}
		
		utility.closeBrowser(driver);
	}
}
