package PHPTravelsSiteDemo;

import java.io.File;

import org.openqa.selenium.remote.RemoteWebDriver;

import stevejobs.WebsiteUtilities;

public class TestRunner {

	public static void main(String[] args)throws Exception {
		WebsiteUtilities utility=new WebsiteUtilities();
	    RemoteWebDriver driver=utility.getBrowserName("chrome");
		utility.launchSite(driver, "https://phptravels.com/demo", 3000);
		
		HomePage pageObj=new HomePage(driver);
		String msg=pageObj.verifyLoginButton();

		System.out.println(msg);
		
		//working with Registeration page
		RegisterationPage page=new RegisterationPage(driver);
		page.clickAccount();
		page.clickRegister();
		
		page.fillFirstName("Ankush");
		page.fillLastName("Dongre");
		page.fillEmail("info.anku527@gmail.com");
		page.selectFlag();
		page.selectIndDialNo();
		page.fillMobileNo("9145204527");
		page.fillAddress1("Tugaon h");
		page.fillAddress2("Tugaon h");
		page.fillCity("bidar");
		page.fillState("karnataka");
		page.fillPostCode("585416");
		page.fillWtsapMo("9145204527");
		page.clickGeneratePassword();
		page.copyGeneratedPassword();
		//page.clickCaptcha();
		
		page.clickReg();
		
		
		utility.closeBrowser(driver);
	}

}
