package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class TestProjectCreateAcc {

	private RemoteWebDriver driver;
	
	@FindBy(name="first_name")
	private WebElement firstName;
	
	@FindBy(name="last_name")
	private WebElement lastName;
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(xpath="//span[text()='I agree to the']")
	private WebElement check;
	
	@FindBy(xpath = "//input[@value='Sign Up']")
	private WebElement signUp;
	
	public TestProjectCreateAcc(RemoteWebDriver driver) {
		this.driver=driver;
		
		AjaxElementLocatorFactory aFactory=new AjaxElementLocatorFactory(driver,20);
		
		PageFactory.initElements(aFactory, this);
	}
	
	
	public void fillFirstName(String val) {
		firstName.sendKeys(val,Keys.chord(Keys.CONTROL,"A"),Keys.chord(Keys.CONTROL,"C"));
	}//chord is static method in Keys class and its taken two parametersokkk just copy now  
	// given first name value i selected 
	
	public void fillLastName(String val) {
		lastName.sendKeys(val);
	}
	
	public void fillPassword(String val) {
		//password.click();
		password.sendKeys(val);
	}
	
	public void checkAgree() {
		check.click();
	}
	
	public void clickSignUp() {
		signUp.click();
	}

}
