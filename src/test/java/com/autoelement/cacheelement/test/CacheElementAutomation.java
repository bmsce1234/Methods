package com.autoelement.cacheelement.test;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class CacheElementAutomation {

	private RemoteWebDriver driver;
	
	@FindBy(id = "search")
	private WebElement searchBox;
	
	@FindBys({
		@FindBy(xpath = "//ul[@role='listbox']/li")
	})
	private List<WebElement> suggestions;
	
	public CacheElementAutomation(RemoteWebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void setSearchBox(String word)throws Exception {
		searchBox.sendKeys(word);
	}
	
	public int gatCountOfAllSuggestions() {
		return suggestions.size();
	}
	
	public String getTextOfSpecificSuggestion(int index) {
		WebElement e=suggestions.get(index).findElement(By.xpath("child::div/div[2]"));
		
		return e.getText();
	}
	
	public List<String> getTextOfAllSuggestions(){
		List<String> values=new ArrayList<String>();
		
		for(int i=0;i<suggestions.size()-1;i++) {
			WebElement e1=suggestions.get(i).findElement(By.xpath("child::div/div[2]"));
				values.add(e1.getText());
		}
		return values;
	}
	
	public boolean verifyAllSuggestions(String word) {
		int flag=0;
		for(int i=0;i<suggestions.size()-1;i++) {
				WebElement e1=suggestions.get(i).findElement(By.xpath("child::div/div[2]"));
				if(!e1.getText().toLowerCase().contains(word.toLowerCase())) {
					flag=1;
					break;
			}
		}
		
		if(flag==0) {
			return true;
		}else {
			return false;
		}
	}
	
	
	public List<String> verifyUnmatchedSuggestion(String word){
		List<String> values=new ArrayList<String>();
		for(int i=0;i<suggestions.size()-1;i++) {
				WebElement e1=suggestions.get(i).findElement(By.xpath("child::div/div[2]"));
				if(!e1.getText().toLowerCase().contains(word.toLowerCase())) {
					values.add(e1.getText());
			}
		}
		return values;
	}
}
