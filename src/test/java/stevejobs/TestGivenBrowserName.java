package stevejobs;

import java.util.Scanner;
import java.util.Set;

import org.openqa.selenium.remote.RemoteWebDriver;

public class TestGivenBrowserName {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Browser Name::");
		String browserName=sc.nextLine();
		
		//create the obj of WebsiteUtility class
		WebsiteUtilities utility=new WebsiteUtilities();
		//call the method by giving browser name
		 RemoteWebDriver driver=utility.getBrowserName(browserName);
		 driver.get("http://www.youtube.com");
         //close the specific driver by calling method
		 utility.closeBrowser(driver);
		 
		 
		
	}
}