package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class FBTestScriptPage {
	
	//declare element
	private RemoteWebDriver driver;
	
	@FindBy(linkText = "English (UK)")
	private WebElement changeLang;
	
	@FindBy(name = "email")
	private WebElement userId;
	
	@FindBy(name = "pass")
	private WebElement password;
	
	@FindBy(name = "login")
	private WebElement loginBtn;
	
	/*@FindBy(xpath = "//span[starts-with(text(),'Welcome to Facebook,')]")
	private WebElement welcomeMsg;*/
	
	@FindBy(xpath = "//div[starts-with(text(),\"The email address or mobile number you entered isn't connected\")]")
	private WebElement blankUidErr;
	
	@FindBy(xpath = "//div[text()=\"The email address you entered isn't connected to an account. \"] ")
	private WebElement invalidUidErr;
	
	@FindBy(linkText = "Forgotten password?")
	private WebElement blankorInvalidpwdErr;
	
	@FindBy(xpath = "//div[@aria-label='Account']/img")
	private WebElement profilePic;
	
	@FindBy(xpath = "//span[text()='Log Out']")
	private WebElement signout;
	
	/*(linkText = "Forgotten password?")
	private WebElement invalipwdErr;*/
	
	public FBTestScriptPage(RemoteWebDriver driver) {
		this.driver=driver;
		
		AjaxElementLocatorFactory afDriver=new AjaxElementLocatorFactory(driver,20);
		
		PageFactory.initElements(afDriver, this);
	}
	
	//fill user-name
	public void fillUserName(String userName) {
		userId.sendKeys(userName);
	}
	
	//fill password
	public void fillPassword(String pwd) {
		password.sendKeys(pwd);
	}
	
	//click login button
	public void clickLogin() {
		loginBtn.click();
	}
	
	public void clickChangeLang() {
		driver.manage().window().maximize();
		changeLang.click();
	}
	
	//if both are valid 
	public boolean isValid() {
		try {
			profilePic.click();
			Thread.sleep(5000);
			return (signout.isDisplayed())?true:false;
		}catch(Exception e) {
			return false;
		}
	}
	
	//if user-id is blank
	public boolean isBlankUidErr() {
		try {
			return (blankUidErr.isDisplayed())?true:false;
		}catch(Exception e) {
			System.out.println(" catch block");
			return false;
		}
	}
	
	//if user-id is invalid
	public boolean isInvalidUidErr() {
		try {
		  return (invalidUidErr.isDisplayed())?true:false;
		}catch (Exception e) {
			return false;
		}
	}
	
	//if password is blank
	public boolean isBlankorInvalidpwdErr() {
		try {
			return (blankorInvalidpwdErr.isDisplayed())?true:false;
		}catch(Exception e) {
			return false;
		}
	}
	
	//if password is invalid
	/*public boolean isInvalidPwdErr() {
		try {
		    return (invalipwdErr.isDisplayed())?true:false;
		}catch(Exception e) {
			return false;
		}
	}*/
}