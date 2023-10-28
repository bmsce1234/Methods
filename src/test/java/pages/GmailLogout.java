package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GmailLogout {
	
	//declare variables on basis of element of page
	private By profileBy,logoutBy;
	private RemoteWebDriver driver;
	
	public GmailLogout(RemoteWebDriver driver) {
		//store comming driver object to current class driver object
		this.driver=driver;
		
		//store profile in profileBy
		profileBy=By.xpath("//a[starts-with(@aria-label,'Google Account:')]/img");
		
		//click logout and store in logoutBy
		logoutBy=By.linkText("Sign out");
	}
	
	//click profile img
	public void clickProfile() {
		driver.findElement(profileBy).click();
	}
	
	//click logout
	public  void clickSignOut() {
		driver.findElement(logoutBy).click();
	}

}
