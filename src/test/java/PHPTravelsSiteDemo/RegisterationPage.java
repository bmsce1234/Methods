package PHPTravelsSiteDemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterationPage {

	private RemoteWebDriver driver;
	
	@FindBy(xpath = "//a[contains(text(),'Account')]")
	private WebElement account;
	
	@FindBy(xpath = "//li[@menuitemname='Register']/a")
	private WebElement register;
	
	@FindBy(name = "firstname")
	private WebElement firstName;
	
	@FindBy(name = "lastname")
	private WebElement lastName;
	
	
	@FindBy(name = "email")
	private WebElement email;
	
	@FindBy(xpath = "//div[@class='selected-flag']")
	private WebElement selectFlag;
	
	@FindBy(xpath = "//ul[@class='country-list']/li[@data-dial-code='91']")
	private WebElement indianDialNo;
	
	@FindBy(name = "phonenumber")
	private WebElement mobileNumber;
	
	@FindBy(name = "address1")
	private WebElement address1;
	
	@FindBy(name = "address2")
	private WebElement address2;
	
	@FindBy(name = "city")
	private WebElement city;
	
	@FindBy(name = "state")
	private WebElement state;
	
	@FindBy(name = "postcode")
	private WebElement postCode;
	
	@FindBy(id = "customfield2")
	private WebElement wtspMo;
	
	@FindBy(xpath = "//button[contains(text(),'Generate Password')]")
	private WebElement generatePassword;
	
	@FindBy(id = "btnGeneratePasswordInsert")
	private WebElement copyGeneratedPassword;
	
	@FindBy(xpath =  "//div[@class='recaptcha-checkbox-border']")
	private WebElement clickCaptcha;
	
	@FindBy(xpath = "//input[@value='Register']")
	private WebElement regButton;
	
	
	public RegisterationPage(RemoteWebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickAccount()throws Exception {
		account.click();
		Thread.sleep(2000);
	}
	
	public void clickRegister()throws Exception {
		register.click();
		Thread.sleep(3000);
	}
	
	public void fillFirstName(String fName) {
		firstName.sendKeys(fName);
	}
	
	public void fillLastName(String lName) {
		lastName.sendKeys(lName);
	}
	
	public void fillEmail(String mail) {
		email.sendKeys(mail);
	}
	
	public void selectFlag()throws Exception {
		selectFlag.click();
		Thread.sleep(2000);
	}
	
	public void selectIndDialNo()throws Exception {
		indianDialNo.click();
		Thread.sleep(3000);
	}
	
	public void fillMobileNo(String mob) {
		mobileNumber.sendKeys(mob);
	}
	
	public void fillAddress1(String addr1) {
		address1.sendKeys(addr1);
	}
	
	public void fillAddress2(String addr2) {
		address2.sendKeys(addr2);
	}
	
	public void fillCity(String c) {
		city.sendKeys(c);
	}
	
	public void fillState(String s) {
		state.sendKeys(s);
	}
	
	public void fillPostCode(String pCode)throws Exception {
		postCode.sendKeys(pCode);
		Thread.sleep(5000);
	}
	
	public void fillWtsapMo(String mo) {
		wtspMo.sendKeys(mo);
	}
	
	public void clickGeneratePassword()throws Exception {
		generatePassword.click();
		Thread.sleep(3000);
	}
	
	public void copyGeneratedPassword()throws Exception {
		
		copyGeneratedPassword.click();
		Thread.sleep(3000);
	}
	
	public void clickCaptcha()throws Exception {
		clickCaptcha.click();
		Thread.sleep(3000);
	}
	
	
	public void clickReg()throws Exception {
		regButton.click();
		Thread.sleep(3000);
	}
}
