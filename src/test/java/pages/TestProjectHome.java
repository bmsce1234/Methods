package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class TestProjectHome {

	private RemoteWebDriver driver;
	
	
	@FindBy(name="your-email")
	private WebElement emailAddress;
	
	public TestProjectHome(RemoteWebDriver driver) {
		this.driver=driver;
		
		AjaxElementLocatorFactory aFactory=new AjaxElementLocatorFactory(driver,20);
		
		PageFactory.initElements(aFactory, this);
	}
	
	
	public void fillEmailAddress(String value) {
		emailAddress.sendKeys(value,Keys.ENTER);
	}
}
