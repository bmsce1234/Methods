package stevejobs;

import java.util.Scanner;

import org.openqa.selenium.remote.RemoteWebDriver;

import pages.GmailCompose;
import pages.GmailHome;
import pages.GmailLogin;
import pages.GmailLogout;

public class GmailAutoUsingPages {

	public static void main(String[] args) throws Exception {
		//taking input from keyboard
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter Browser Name::");
		String browserName=sc.nextLine();
		
		System.out.println("Enter UserName::");
		String uName=sc.nextLine();
		
		System.out.println("Enter Password::");
		String password=sc.nextLine();
		
		System.out.println("Enter To address:: ");
		String to=sc.nextLine();
		
		System.out.println("Enter subject::");
		String subject=sc.nextLine();
		
		System.out.println("Enter Body ::");
		String body=sc.nextLine();
		
		System.out.println("Enter filepath::");
		String filepath=sc.nextLine();
		
		//close Scanner
		sc.close();
		
		//create the object of WebsiteUtilities
		WebsiteUtilities utilities=new WebsiteUtilities();
		
		//get browser driver software
		RemoteWebDriver driver=utilities.getBrowserName(browserName);
		
		//launch  a site
		utilities.launchSite(driver, "http://www.gmail.com", 5000);
		
		//create GmailHome object
		GmailHome gHome=new GmailHome(driver);
		gHome.fillUserName(uName);
		gHome.clickNext();
		Thread.sleep(5000);
		
		//create GmailHome object
		GmailLogin gLogin=new GmailLogin(driver);
		gLogin.fillPassword(password);
		gLogin.clickNext();
		Thread.sleep(5000);
		
		//create GmailCompose class object and call those methods
		GmailCompose gCompose=new GmailCompose(driver);
		gCompose.clickCompose();
		Thread.sleep(5000);
		gCompose.fillTo(to);
		gCompose.fillSubject(subject);
		gCompose.fillBody(body);
		gCompose.fillFilePath(filepath);
		Thread.sleep(5000);
		gCompose.clickSend();
		Thread.sleep(5000);
		
		//create GmailLogout class object
		GmailLogout gLogout=new GmailLogout(driver);
		gLogout.clickProfile();
		Thread.sleep(5000);
		gLogout.clickSignOut();
		Thread.sleep(5000);
		
		//close browser driver
		utilities.closeBrowser(driver);

	}
}
