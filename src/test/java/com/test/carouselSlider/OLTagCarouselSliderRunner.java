package com.test.carouselSlider;

import org.openqa.selenium.remote.RemoteWebDriver;

import stevejobs.WebsiteUtilities;

public class OLTagCarouselSliderRunner {

	public static void main(String[] args)throws Exception {
		WebsiteUtilities utility =new WebsiteUtilities();
		RemoteWebDriver driver = utility.getBrowserName("chrome");
		
		utility.launchSite(driver, "https://www.amazon.com", 5000);
		OLTagCarouselSliderPage page =new OLTagCarouselSliderPage(driver);
		
		System.out.println(page.getCountOfSlides());
		
		System.out.println(page.getTypeOfCarouselSlider());
		
		if(page.areSlidesMoving()) {
			System.out.println("slides are moving");
			
			System.out.println(page.getSlidesMovingDirectionInCarouselSlider());
			
			System.out.println(page.getAdditionalInformationOfSlidesInCarouselSlider());
			
			if(page.verifySlidesRotationInCarouselSlider()) {
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
