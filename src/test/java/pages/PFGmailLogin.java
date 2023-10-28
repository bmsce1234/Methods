package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PFGmailLogin {

	private RemoteWebDriver driver;
	
	
	@FindBy(name="password")
	private WebElement password;
	
	
	@FindBy(xpath = "//span[text()='Next']/parent::button")
	private WebElement next;
	
	public PFGmailLogin(RemoteWebDriver driver) {
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}
	
	
	public void fillPassword(String pwd) {
	    password.sendKeys(pwd);
	}
	
	public void clickNext() {
		next.click();
	}
}
