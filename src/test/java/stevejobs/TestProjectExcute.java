package stevejobs;

import org.openqa.selenium.remote.RemoteWebDriver;

import pages.TestProjectCreateAcc;
import pages.TestProjectHome;

public class TestProjectExcute {

	public static void main(String[] args) throws Exception {
		WebsiteUtilities utilities=new WebsiteUtilities();
		
		RemoteWebDriver driver=utilities.getBrowserName("chrome");
		
		utilities.launchSite(driver, "https://testproject.io/?utm_source=google-ads&utm_campaign=testproject_june&utm_agid=103028007016&utm_term=%2Bwebsite%20%2Btesting&creative=442398275940&device=c&placement&gclid=CjwKCAjwr56IBhAvEiwA1fuqGh1w0_kg0GCH6qAd-lEEnw82c9tF4mwLymKT8H1OM-ZJTXynIBt7VxoCpjcQAvD_BwE", 5000);

		TestProjectHome home= new TestProjectHome(driver);
		home.fillEmailAddress("ankushd.tech527@gmail.com");
		Thread.sleep(5000);
		
		TestProjectCreateAcc acc=new TestProjectCreateAcc(driver);
		acc.fillFirstName("Ankush");
		/*acc.fillLastName("Dongre");
		acc.fillPassword("Ankush527");//
		Thread.sleep(5000);
		acc.checkAgree();
		Thread.sleep(5000);
		acc.clickSignUp();
		Thread.sleep(5000);*/
		
		//utilities.closeBrowser(driver);
	}
}
