package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GmailLogin {

	//declare variables
	private By passwordBy,nextBy;
	private RemoteWebDriver driver;
	
	public GmailLogin(RemoteWebDriver driver) {
		//storing parameter driver object in current driver object
		this.driver=driver;
		
		// store password textbox element in passwordBy variable
		passwordBy=By.name("password");
		
		//store next button element in nextBy variable
		nextBy=By.xpath("//span[text()='Next']/parent::button");
	}
	
	//find element and  fill password textbox
	public void fillPassword(String password) {
		driver.findElement(passwordBy).sendKeys(password);
	}
	
	//find next button element and click it
	public void clickNext() {
		driver.findElement(nextBy).click();
	}
}
