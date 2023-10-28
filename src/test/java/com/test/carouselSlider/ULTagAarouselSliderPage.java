package com.test.carouselSlider;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class ULTagAarouselSliderPage {

	private RemoteWebDriver driver;
	
	@FindBy(className = "carousel__list")
	private WebElement cSlider;
	
	
	@FindBys({
		@FindBy(xpath = "//ul[@class='carousel__list']/li")
	})
	private List<WebElement> sliderList;
	
	
	public ULTagAarouselSliderPage(RemoteWebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//test-case1::get the count of all slider
	public int getCountOfAllSlides() {
		return sliderList.size();
	}//getCountOfAllSlides
	
	
	//test-case2:: get the type of slider(2D/3D)
	public String getTypeOfMovingSlides() {
		String value=cSlider.getCssValue("transform");
		System.out.println(value);

		if(value.equals("none")) {
			value=cSlider.getCssValue("transform-style");
		}
		
		if(value.contains("3d")) {
			return "slider is 3D";
		}else {
			return "slider is 2D";
		}
	}//getTypeOfMovingSlides
	
	
	//test-case3:: check slides are moving or not
	public boolean areSlidesMoving() {
		if(cSlider.getCssValue("transform").equals("none")) {
			return false;
		}else {
			return true;
		}
	}//areSlidesMoving
	
	
	//test-case4:: in which direction slides are moving
	public String getDirectionOfSlidesInCarouselSlider() {
		//matrix(1, 0, 0, 1, -1312, 0)
		
		String value=cSlider.getCssValue("transform");
		String pieces[] =value.split(",");
		float xOffset=Float.parseFloat(pieces[4].trim());
		float yOffset=Float.parseFloat(pieces[5].replace(")","").trim());
		
		if(xOffset<0&&yOffset==0) {
			return "slides are moving right to left";
		}else if(xOffset>0&&yOffset==0) {
			return "slides are moving left to right";
		}else if(xOffset==0&&yOffset<0) {
			return "slides are moving bottom to top";
		}else {
			return "slides are moving top to bottom";
		}
	}//getDirectionOfSlidesInCarouselSlider
	
	//test-case(5):: get additional info about slides in carousel slider
	//-> duration of a slide while moving
	//-> effect of slide
	//->delay between slides while moving
	public List<String> getAdditionalInfoOfSlidesInCarsoulerSlider(){
		List<String> info=new ArrayList<String>();
		
		//transform 0.45s ease-in-out 0s
		String value=cSlider.getCssValue("transition");
		String pieces[]=value.split(" ");
		
        info.add("duration of a slide while moving "+pieces[1]);
		
		if(pieces[2].equals("ease-in")) {
			info.add("slow start for each slide");
		}else if(pieces[2].equals("ease-out")) {
			info.add("slow end for each slide");
		}else if(pieces[2].equals("linear")) {
			info.add("same start for each slide");
		}else {
			info.add("slow start and slow end for each slide");
		}
		
		info.add("delay between slides while moving "+pieces[3].replace(",", ""));
		
		return info;
	}//getAdditionalInfoOfSlidesInCarsoulerSlider
	
	public boolean verifyMovingSlidesInCarouselSlider()throws Exception {
		driver.navigate().refresh();
		int pVal=0;
		int lVal=0;
		for(WebElement slide:sliderList) {
		    pVal=(int)System.currentTimeMillis();
		   
			while(true) {
				if(slide.isDisplayed()) {
					break;
				}
			}//while
			lVal=(int)System.currentTimeMillis();
		}//for
		
		Thread.sleep(2000);
		
		if(sliderList.get(0).isDisplayed()) {
			return true;
		}else {
			return false;
		}
	}//verifyMovingSlidesInCarouselSlider
	
}