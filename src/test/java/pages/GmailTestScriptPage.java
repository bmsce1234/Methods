package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class GmailTestScriptPage {
	
	private RemoteWebDriver driver;
	
	@FindBy(name="identifier")
	private WebElement userId;
	
	@FindBy(xpath = "//span[text()='Next']/parent::button")
	private WebElement nextBtn;
	
	@FindBy(xpath = "//div[starts-with(text(),'Enter an email')]")
	private WebElement uidBlnkErr;
	
	@FindBy(xpath = "//div[@class='o6cuMc']")
	private WebElement uidInvalidErr;
	
	@FindBy(name = "password")
	private WebElement password;
	
	public GmailTestScriptPage(RemoteWebDriver driver) {
		this.driver=driver;
		
		AjaxElementLocatorFactory aFactory=new AjaxElementLocatorFactory(driver, 20);
		
		PageFactory.initElements(aFactory, this);
	}
	
	public void fillUserId(String uId) {
		driver.manage().window().maximize();
		userId.sendKeys(uId);
	}
	
	public void clickNext() {
		nextBtn.click();
	}
	
	public boolean isUidValid() {
		try {
			if(password.isDisplayed()) {
				return true;
			}else {
				return false;
			}
		}catch(Exception e) {
			return false;
		}
	}
	
	public boolean isUidBlank() {
		try {
			if(uidBlnkErr.isDisplayed()) {
				return  true;
			}else {
				return false;
			}
		}catch(Exception e) {
			return false;
		}
	}
	
	public boolean isUidInvalid() {
		try {
			if(uidInvalidErr.isDisplayed()) {
				return true;
			}else {
				return false;
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		    return false;
		}
	}
}
