package com.test.pagination;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class paginationPage {
	
	private RemoteWebDriver driver;
	
	@FindBys({
		@FindBy(xpath = "//div[@class='g']")
	})
	private List<WebElement> allEles;
	
	@FindBy(name="q")
	private WebElement ele;
	
	public paginationPage(RemoteWebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void fillAndEnterTxt(String value) {
		ele.sendKeys(value,Keys.ENTER);
	}
	
	public List<WebElement> getVisibleElements(){
		List<WebElement> visibleEles=new ArrayList<WebElement>();
		for(WebElement ele:allEles) {
			if(ele.isDisplayed()) {
				visibleEles.add(ele);
			}
		}
		return visibleEles;
	}
	
	public void clickNextPage(int pageNo) {
		driver.findElement(By.linkText(pageNo+"")).click();
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
}
