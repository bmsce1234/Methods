package stevejobs;

import java.util.Scanner;

import org.openqa.selenium.remote.RemoteWebDriver;

import pages.PFGmailCompose;
import pages.PFGmailHome;
import pages.PFGmailLogin;
import pages.PFGmailLogout;

public class PFGmailTest {

	public static void main(String[] args) throws Exception {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter Browser Name:: ");
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
		
		WebsiteUtilities utilities=new WebsiteUtilities();
		
		RemoteWebDriver driver=utilities.getBrowserName(browserName);
		
		utilities.launchSite(driver, "http://www.gmail.com", 5000);
		
		PFGmailHome gmailHome=new PFGmailHome(driver);
		gmailHome.fillUsername(uName);
		gmailHome.clickNext();
		Thread.sleep(5000);
		
		PFGmailLogin gmailLogin=new PFGmailLogin(driver);
		gmailLogin.fillPassword(password);
		gmailLogin.clickNext();
		Thread.sleep(5000);
		
		PFGmailCompose gmailCompose=new PFGmailCompose(driver);
		gmailCompose.clickCompose();
		Thread.sleep(7000);
		gmailCompose.fillTo(to);
		gmailCompose.fillSubject(subject);
		gmailCompose.fillBody(body);
		gmailCompose.fillFilePath(filepath);
		Thread.sleep(5000);
		gmailCompose.clickSend();
		Thread.sleep(5000);
		
		PFGmailLogout gmailLogout=new PFGmailLogout(driver);
		gmailLogout.clickProfile();
		Thread.sleep(5000);
		gmailLogout.clickSignOut();
		Thread.sleep(5000);
		
		
		utilities.closeBrowser(driver);
		
	}
}
