package stevejobs;

import java.util.Scanner;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.FBTestScriptPage;

public class FBTestScriptTest {

	public static void main(String[] args) throws Exception {
		//declare variables
		RemoteWebDriver driver;
		String browserName;
		String userId;
		String password;
		String crieteria;
		
		//create scanner class object
		Scanner sc=new Scanner(System.in);
		
		//get values from keyboard
		System.out.println("Enter browser name:: ");
		browserName=sc.nextLine();
		
		System.out.println("Enter userId:: ");
		userId=sc.nextLine();
		
		System.out.println("Enter password:: ");
		password=sc.nextLine();
		
		System.out.println("Enter crieteria:: ");
		crieteria=sc.nextLine();
	
		//close scanner
		sc.close();
		
		//create utility class object
		WebsiteUtilities utilities=new WebsiteUtilities();
		
		//get browser
		if(browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions co=new ChromeOptions();
			co.addArguments("--disable-notifications");
			driver=new ChromeDriver(co);
		}else {
		   driver=utilities.getBrowserName(browserName);
		}
	
		//launch site
		utilities.launchSite(driver, "http://www.facebook.com", 5000);
		
		//create object of page class
		FBTestScriptPage pageobj=new FBTestScriptPage(driver);
		
		//click change language link
		pageobj.clickChangeLang();
		
		//call fillUserId method
		pageobj.fillUserName(userId);
		
		//call fillPassword method
		pageobj.fillPassword(password);
		
		//call clickLogin method
		pageobj.clickLogin();
		Thread.sleep(5000);
		
		//call valid method when both are valid
		if(crieteria.equals("both_Valid")) {
			if(pageobj.isValid()) {
				System.out.println("both-valid test passed");
			}else {
				System.out.println("both-valid test failed");
			}
		}else if(crieteria.equals("blank_Uid")) {
			if(pageobj.isBlankUidErr()) {
				System.out.println("blank userId test passed");
			}else {
				System.out.println("blank userId test failed");
			}
		}else if(crieteria.equals("invalid_Uid")) {
			if(pageobj.isInvalidUidErr()) {
				System.out.println("invalid userId test passed");
			}else {
				System.out.println("Invalid userId test failed");
			}
		}else if(crieteria.equals("blank_Pwd")||crieteria.equals("invalid_Pwd")) {
			if(pageobj.isBlankorInvalidpwdErr()) {
				System.out.println("blank or invalid password test passed");
			}else {
				System.out.println("blank or invalid password test failed");
			}
		} else {
			System.out.println("enter a correct crieteria(both_Valid/blank_Uid/invalid_Uid/blank_Pwd/invali_Pwd)");
		}
		
		//close driver
		utilities.closeBrowser(driver);

	}
}
