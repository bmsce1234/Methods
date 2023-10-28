package com.test.calendar;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class CalenderAutomationPage {
	
	private RemoteWebDriver driver;
	
	@FindBy(id = "datepicker")
	private WebElement datePicker;
	
	@FindBy(xpath = "//span[text()='Prev']/parent::a")
	private WebElement previous;
	
	@FindBy(xpath = "//span[text()='Next']/parent::a")
	private WebElement next;
	
	@FindBy(className = "ui-datepicker-year")
	private WebElement year;

	@FindBy(className = "ui-datepicker-month")
	private WebElement month;
	
	@FindBys({
		@FindBy(xpath = "//table[@class='ui-datepicker-calendar']/tbody//a")
	})
	private List<WebElement> datesList;
	
	public CalenderAutomationPage(RemoteWebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void selectDatePicker() {
		driver.switchTo().frame(0);
		datePicker.click();
	}
	
	public void selectDate(int yy,String mon,int dd) {
		while(true) {
			//year match
			int cYear=Integer.parseInt(year.getText());
			
			if(yy>cYear) {
				next.click();
			}else if(yy<cYear) {
				previous.click();
			}else {
				while(true) {
					String cMonth=month.getText();
					if(!cMonth.equalsIgnoreCase("January")) {
						previous.click();
					}else {
						break;
					}//else
				}//while
				
				while(true) {
					String cMonth=month.getText();
					if(!cMonth.equalsIgnoreCase(mon)) {
						next.click();
					}else {
						break;
					}//else
				}//while
				break;
			}//else
		}//while
		
		//select date
		for(WebElement date:datesList) {
			String temp=date.getText();
			int gDate=Integer.parseInt(temp);
			//int gDate=Integer.parseInt(date.getText());
			if(dd==gDate) {
				date.click();
				break;
			}//if
		}//for
	}//method
	
	//select year
	public void selectYear(int yyyy) {
		while(true) {
			int cYear=Integer.parseInt(year.getText());
			
			if(yyyy>cYear) {
				next.click();
			}else if(yyyy<cYear) {
				previous.click();
			}else {
				break;
			}
		}//while
	}//select year
	
	//select month
	public void selectMonth(String mm) {
		
		//bring to january
		while(true) {
			String cMonth=month.getText();
			
			if(!cMonth.equalsIgnoreCase("january")) {
				previous.click();
			}else {
				break;
			}
		}//while
			
		//select from january
		while(true) {
			String cMonth=month.getText();
			
			if(cMonth.equalsIgnoreCase(mm)) {
				break;
			}else {
				next.click();
			}
		}
	}//select month
	
	
	//select date
	public void selectDate(int dd) {
		for(WebElement cd:datesList) {
			int cDate=Integer.parseInt(cd.getText());
			
			if(cDate==dd) {
				cd.click();
				break;
			}
		}//for
	}//select date
	
}
