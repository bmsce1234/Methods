package com.test.getDomAttribute;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import stevejobs.WebsiteUtilities;

public class TestGetDomAttribute {

	RemoteWebDriver driver;
	
	
	@FindBy(name="q")
	WebElement e;
	
	public TestGetDomAttribute(RemoteWebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getDomAttribute() {
		String x=e.getDomAttribute("role");
		return x;
	}
	
	public String getDomProperty() {
		String x=e.getDomProperty("minLength");
		return x;
		
	}
	
	public String getAccessibleName() {
		String x=e.getAccessibleName();
		return x; 
	}
	
	public String getAriaName() {
		String x=e.getAriaRole();
		return x;
	}
	public static void main(String[] args) throws Exception {
		WebsiteUtilities utility=new WebsiteUtilities();
		
		RemoteWebDriver driver=utility.getBrowserName("chrome");
		
		utility.launchSite(driver, "http://www.google.com", 5000);
		
		TestGetDomAttribute page=new TestGetDomAttribute(driver);
		
		System.out.println(page.getDomAttribute());
		System.out.println(page.getDomProperty());
		System.out.println(page.getAccessibleName());
		System.out.println(page.getAriaName());
		
		utility.closeBrowser(driver);

	}

}
