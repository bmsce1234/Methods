package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PFGmailHome {
	
	//declaring driver for using driver object in this class
	private RemoteWebDriver driver;
	
	//declare element and initialize with annotation
	@FindBy(name="identifier")
	private WebElement userName;
	
	@FindBy(xpath = "//span[text()='Next']/parent::button")
	private WebElement next;
	
	//declaring constructor for intializing PageFactory
	
	public PFGmailHome(RemoteWebDriver driver) {
		//storing comming driver object in current class driver object
		this.driver=driver;
		
		/*sending driver obj and current class object to PageFactory 
		for locating element based on given element finder*/
		PageFactory.initElements(driver, this);
	}
	
	//define methods for doing operations on elements
	public void fillUsername(String uName) {
		userName.sendKeys(uName);
	}
	
	public void clickNext() {
		next.click();
	}
}
