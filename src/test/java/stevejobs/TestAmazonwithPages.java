package stevejobs;

import org.openqa.selenium.remote.RemoteWebDriver;

import pages.Page1;

public class TestAmazonwithPages {

	public static void main(String[] args) throws Exception {
		WebsiteUtilities utilities=new WebsiteUtilities();
		
		RemoteWebDriver driver=utilities.getBrowserName("chrome");
		
		utilities.launchSite(driver, "https://www.amazon.in", 5000);
		
		Page1 page=new Page1(driver);
		
		page.clickElectronics();
		
		Thread.sleep(5000);
		page.clickMobileAccessories();
		
		Thread.sleep(5000);
		page.inputTextSearch("Redmi 9i");
		
		/*Thread.sleep(5000);
		page.clickSearch();*/
		
		Thread.sleep(5000);
		utilities.closeBrowser(driver);

	}
}
