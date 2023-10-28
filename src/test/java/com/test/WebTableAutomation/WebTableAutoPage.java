package com.test.WebTableAutomation;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class WebTableAutoPage {

	private static final Object String = null;

	private RemoteWebDriver driver;
	
	@FindBy(xpath = "//div[@data-testid='one-way-radio-button']")
	private WebElement onewayTrip;
	
	@FindBy(xpath = "//div[@data-testid='round-trip-radio-button']")
	private WebElement roundTrip;
	
	@FindBy(xpath = "//div[@data-testid='to-testID-origin']//input")
	private WebElement fromCity;
	
	@FindBy(xpath = "//div[@data-testid='to-testID-destination']//input")
	private WebElement toCity;
	
	@FindBy(xpath = "//div[contains(@data-testid,'departure-date')]")
	private WebElement departureDate;
	
	@FindBys({
		@FindBy(xpath = "//div[contains(@data-testid,'undefined-month')]")
	})
	private List<WebElement> monthsBlocks;
	
	@FindBy(xpath = "//div[@data-testid='undefined-calendar-picker']/div[1]")
	private WebElement next;
	
	@FindBy(xpath = "//div[contains(@data-testid,'return-date')]")
	private WebElement returnDate;
	
	@FindBy(xpath = "//div[@data-testid='home-page-flight-cta']")
	private WebElement submit;
	
	@FindBys({
		@FindBy(xpath = "((//div[@data-testid='searchPage-sortingOption-spicemax-child'])[1]/following::div)[1]/div")
	})
	private List<WebElement> departureFlightsList;
	
	@FindBys({
		@FindBy(xpath = "(//div[@data-testid='searchPage-sortingOption-spicemax'])[2]/following::div[1]/div")
	})
	private List<WebElement> returnFlightsList;
	
	
	public WebTableAutoPage(RemoteWebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOneWayTrip() {
		onewayTrip.click();
	}
	
	public void clickRoundTrip() {
		roundTrip.click();
	}
	
	public void setFromCity(String city) {
		fromCity.clear();
		fromCity.sendKeys(city);
	}
	
	public void setToCity(String city) {
		toCity.clear();
		toCity.sendKeys(city);
	}
	
	public void setDate(int year,String month,int date) {
		for(WebElement m:monthsBlocks) {
			String cm=m.getAttribute("data-testid");
			cm=cm.toLowerCase();
			month=month.toLowerCase();
			if(cm.contains(month)&&cm.contains(year+"")) {
				while(true) {
					if(m.isDisplayed()) {
						m.findElement(By.xpath("descendant::div[@data-testid='undefined-calendar-day-"+date+"']")).click();
					
						break;
					}else {
						next.click();
					}
				}//while
				break;
			}
		}//for
	}//method
	
	public void setDepartureDate(int year,String month,int date) {
		setDate(year, month, date);
	}
	
	
	public void setReturnDate(int year,String month,int date) throws Exception {
		returnDate.click();
		Thread.sleep(5000);
		returnDate.click();
		Thread.sleep(5000);
		setDate(year, month, date);
	}
	
	public void clickNext() {
		submit.click();
	}
	
	
	public int getDepartureFlightList() {
		return departureFlightsList.size();
	}
	
	public int getReturnFlightList() {
		return returnFlightsList.size();
	}
	
	public float getDepartureFlightFare(int index) {
		WebElement e=departureFlightsList.get(index).findElement(By.xpath("descendant::div[@data-testid='spicesaver-flight-select-radio-button-1']/following-sibling::div"));
		                                                                 //descendant::div[@data-testid='spicesaver-flight-select-radio-button-1'][1]/following-sibling::div)[1]
		
		String temp=(String) driver.executeScript("return(arguments[0].childNodes[1].textContent);", e);
		
		temp=temp.replace(",", "");
		int fare=Integer.parseInt(temp);
		return fare;
	}
	
	public float getReturnFlightFare(int index) {
		WebElement e=returnFlightsList.get(index).findElement(By.xpath("descendant::div[@data-testid='spicesaver-flight-select-radio-button-1']/following-sibling::div"));
		
		String temp =(String)driver.executeScript("return(arguments[0].childNodes[1].textContent);", e);
		
		temp=temp.replace(",", "");
		float fare=Float.parseFloat(temp);
		return fare;
	}
	
	public List<Integer> getAllDepartureFlightFares(){
		List<Integer> allFlightFares=new ArrayList<Integer>();
		
		for(WebElement flare:departureFlightsList) {
			WebElement e=flare.findElement(By.xpath("descendant::div[@data-testid='spicesaver-flight-select-radio-button-1']/following-sibling::div"));
			
			String temp =(String)driver.executeScript("return(arguments[0].childNodes[1].textContent);", e);
			
			temp=temp.replace(",", "");
			int fare=Integer.parseInt(temp);
			allFlightFares.add(fare);
		}
		return allFlightFares;
	}
	
	public List<Integer> getAllReturnFlightFares(){
		List<Integer> allReturnFlares=new ArrayList<Integer>();
		for(WebElement flare:returnFlightsList) {
			WebElement e=flare.findElement(By.xpath("descendant::div[@data-testid='spicesaver-flight-select-radio-button-1']/following-sibling::div"));
			
			String temp =(String)driver.executeScript("return(arguments[0].childNodes[1].textContent);", e);
			
			temp=temp.replace(",", "");
			int fare=Integer.parseInt(temp);
			allReturnFlares.add(fare);
		}
		return allReturnFlares;
	}
	
	public void selectLowestDepartureFare() {
		List<Integer> allDepartureFlares= getAllDepartureFlightFares();
		
		int lowestFlare=allDepartureFlares.get(0);
		int index=0;
		
		for(int i=1;i<allDepartureFlares.size();i++) {
			if(lowestFlare>allDepartureFlares.get(i)) {
				lowestFlare=allDepartureFlares.get(i);
				index=i;
			}//if
		}//for
		departureFlightsList.get(index).findElement(By.xpath("descendant::div[@data-testid='spicesaver-flight-select-radio-button-1']")).click();
	}
	
	public void selectLowestReturnFlightFare() {
      List<Integer> allreturnFlares= getAllReturnFlightFares();
		
		int lowestFlare=allreturnFlares.get(0);
		int index=0;
		
		for(int i=1;i<allreturnFlares.size();i++) {
			if(lowestFlare>allreturnFlares.get(i)) {
				lowestFlare=allreturnFlares.get(i);
				index=i;
			}//if
		}//for
		returnFlightsList.get(index).findElement(By.xpath("descendant::div[@data-testid='spicesaver-flight-select-radio-button-1']")).click();
	}
	
	public void selectHeighestDepartureFare() {
		List<Integer> allDepartureFlares= getAllDepartureFlightFares();
		
		int lowestFlare=allDepartureFlares.get(0);
		int index=0;
		
		for(int i=1;i>allDepartureFlares.size();i++) {
			if(lowestFlare>allDepartureFlares.get(i)) {
				lowestFlare=allDepartureFlares.get(i);
				index=i;
			}//if
		}//for
		departureFlightsList.get(index).findElement(By.xpath("descendant::div[@data-testid='spicesaver-flight-select-radio-button-1']")).click();
	}
	
	public void selectHeighestReturnFlightFare() {
	      List<Integer> allreturnFlares= getAllReturnFlightFares();
			
			int lowestFlare=allreturnFlares.get(0);
			int index=0;
			
			for(int i=1;i>allreturnFlares.size();i++) {
				if(lowestFlare>allreturnFlares.get(i)) {
					lowestFlare=allreturnFlares.get(i);
					index=i;
				}//if
			}//for
			returnFlightsList.get(index).findElement(By.xpath("descendant::div[@data-testid='spicesaver-flight-select-radio-button-1']")).click();
		}
}

