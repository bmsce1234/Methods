package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GmailHome {
	
	//declare  variables 
	private By userNameBy,nextBy;
	private RemoteWebDriver driver;
	
	public GmailHome(RemoteWebDriver driver) {
	
		this.driver=driver;
		//locating username textbox and store in userNameBy
		userNameBy=By.name("identifier");
		
		//locating send button and store in nextBy variable
		nextBy=By.xpath("//span[text()='Next']");
	}
	
	//operational methods
	
	//find element and fill the username textbox
	public void fillUserName(String uName) {
		driver.findElement(userNameBy).sendKeys(uName);
	}
	
	//find next element click next button
	public void clickNext() {
		driver.findElement(nextBy).click();
	}
}
