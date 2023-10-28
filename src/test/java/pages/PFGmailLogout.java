package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PFGmailLogout {

	private RemoteWebDriver driver;
	
	@FindBy(xpath = "//a[starts-with(@aria-label,'Google Account:')] /child::img ")
	private WebElement profile;
	
	@FindBy(linkText = "Sign out")
	private WebElement signOut;
	
	public PFGmailLogout(RemoteWebDriver driver) {
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}
	
	public void clickProfile() {
		profile.click();
	}
	
	public void clickSignOut() {
		signOut.click();
	}
}
