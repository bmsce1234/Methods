package com.test.carouselSlider;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class DivTagCarouselSliderPage {

	private RemoteWebDriver driver;
	
	@FindBy(xpath = "(//div[contains(@style,'transform')])[1]")
	private WebElement carouselSlider;
	
	@FindBys({
		@FindBy(xpath = "(//div[contains(@style,'transform')])[1]/div[@data-clone='false']")
	})
	private List<WebElement> slidesList;
	
	public DivTagCarouselSliderPage(RemoteWebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//test-case(1):: get the count of all slides in carousel slider
	public int getCountOfSlides() {
		return slidesList.size();
	}
	
	//test-case(2):: get the type of slider(2D/3D) in carousel slider
	public String getTypeOfCarouselSlider() {
		String value=carouselSlider.getCssValue("transform");
		if(value.equalsIgnoreCase("none")) {
			value=carouselSlider.getCssValue("transform-style");
		}
		
		if(value.contains("3d")) {
			return "carouselSlider type is 3D";
		}else {
			return "carouselSlider type is 2D";
		}
	}//getTypeOfCarouselSlider
	
	//test-case(3):: check slides are moving or not
	public boolean areSlidesMoving() {
		if(carouselSlider.getCssValue("transform").equalsIgnoreCase("none")) {
			return false;
		}else {
			return true;
		}
	}//areSlidesMoving
	
	//test-case(4):: get direction of moving slider in carousel-slider
	public String getSlidesMovingDirectionInCarouselSlider() {
		//matrix(1, 0, 0, 1, -4560, 0)
		String value=carouselSlider.getCssValue("transform");
		
		//split value by (,) to get x and y offset
		String offset[]=value.split(",");

		//offset[0]=matrix(1
		//offset[1]= 0
		//offset[2]= 0
		//offset[3]= 1
		//offset[4]= -4560
		//offset[5]= 0)
		
		//get x and y offset from offset[]
		String x=offset[4].trim();//x offset
		String y=offset[5].replace(")", "");//y offset
		
		float xoffset=Float.parseFloat(x);
		float yoffset=Float.parseFloat(y);
		
		if(xoffset>0&&yoffset==0) {
			return "slides are moving left to right";
		}else if(xoffset<0&&yoffset==0) {
			return "slides are moving right to left";
		}else if(yoffset>0&&xoffset==0){
			return "slides are moving top to bottom";
		}else {
			return "slides are moving left to right";
		}
	}//getSlidesMovingDirectionInCarouselSlider
	
	
	//test-case(5):: get additional info about slides in carousel slider
	//-> duration of a slide while moving
	//-> effect of slide
	//->delay between slides while moving
	public List<String> getAdditionalInformationOfSlidesInCarouselSlider(){
		List<String> info=new ArrayList<String>();
		//transform 0.2s ease-out 0s, -webkit-transform 0.2s ease-out 0s
		String value=carouselSlider.getCssValue("transition");
		
		//split that value into pieces by space
		String [] piece =value.split(" ");
		//piece[0]=transform
		//piece[1]=0.2s
		//piece[2]=ease-out
		//piece[3]=0s,
		//piece[4]=-webkit-transform
		//piece[5]=0.2s
		//piece[6]=ease-out
		//piece[7]=0s
		
		info.add("duration of a slide while moving "+piece[1]);
		
		if(piece[2].equals("ease-in")) {
			info.add("slow start for each slide");
		}else if(piece[2].equals("ease-out")) {
			info.add("slow end for each slide");
		}else if(piece[2].equals("linear")) {
			info.add("same start for each slide");
		}else {
			info.add("slow start and slow end for each slide");
		}
		
		info.add("delay between slides while moving "+piece[3].replace(",", ""));
		
		return info;
	}//getAdditionalInformationOfSlidesInCarouselSlider
	
	//test-case(6)::verify the slides rotating in same order
	//-> After completion of last slide move first slide coming or not
	
	public boolean verifySlidesRotationInCarouselSlider()throws Exception {
		driver.navigate().refresh();
		Thread.sleep(2000);
		int sTime=0;
		int eTime=0;
		for(WebElement slide:slidesList) {
			sTime=(int) System.currentTimeMillis();
			while(true) {
				if(slide.findElement(By.xpath("descendant::img[1]")).isDisplayed()) {
					break;
				}
			}//while
			eTime=(int) System.currentTimeMillis();
		}//for
		
		Thread.sleep(eTime-sTime+100);
		if(slidesList.get(0).findElement(By.xpath("descendant::img[1]")).isDisplayed()){
			return true;
		}else {
			return false;
		}
		
	}//verifySlidesRotationInCarouselSlider
}
