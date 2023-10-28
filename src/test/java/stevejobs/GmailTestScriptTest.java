package stevejobs;

import java.util.Scanner;

import org.openqa.selenium.remote.RemoteWebDriver;

import pages.GmailTestScriptPage;

public class GmailTestScriptTest {

	public static void main(String[] args) throws Exception {
		//declare variables
		String browserName;
		String userId;
		String uidCrieteria;
		
		//create scanner object
		Scanner sc=new Scanner(System.in);
		//take browser name
		System.out.println("Enter Browser name:: ");
		browserName=sc.nextLine();
		
		//take userId
		System.out.println("Enter userId:: ");
		userId=sc.nextLine();
		
		//take uId crieteria
		System.out.println("Enter uIDCrieteria:: ");
		uidCrieteria=sc.nextLine();
		
		//close scanner
		sc.close();
		//create utility class object
		WebsiteUtilities utilities=new WebsiteUtilities();
		//get browser
		RemoteWebDriver driver=utilities.getBrowserName(browserName);
		
		//launch site
		utilities.launchSite(driver, "https://www.gmail.com", 5000);
		
		//create object of page class
		GmailTestScriptPage pageObj=new GmailTestScriptPage(driver);
		
		//call the method based on test data
		pageObj.fillUserId(userId);
		
		pageObj.clickNext();
		Thread.sleep(5000);
		
		if(uidCrieteria.equals("valid")) {
			if(pageObj.isUidValid()) {
				System.out.println("given uID is valid and test pass");
			}else {
				System.out.println("given UID is invalid and test failed");
			}
		}else if(uidCrieteria.equals("invalid")) {
			if(pageObj.isUidInvalid()) {
				System.out.println("given invalid uId is passed ");
			}else {
				System.out.println("given invalid uId is failed");
			}
		}else if(uidCrieteria.equals("blank")) {
			if(pageObj.isUidBlank()) {
				System.out.println("given blank uId is passed");
			}else {
				System.out.println("given blank uId is failed");
			}
		}else {
			System.out.println("please write valid crieteria");
		}
		
		utilities.closeBrowser(driver);
	}
}
