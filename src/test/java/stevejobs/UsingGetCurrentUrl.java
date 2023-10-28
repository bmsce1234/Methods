package stevejobs;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UsingGetCurrentUrl {

	public static void main(String[] args) {
		// Get Browser s/w for corresponding driver
		WebDriverManager.chromedriver().setup();
		//Get ChromeDriver
		RemoteWebDriver driver=new ChromeDriver();
		//open site
		//driver.get("http://www.google.com");
		driver.get("http://www.sentia.in");
		//get URL of site using getCurrentUrl()
		String x=driver.getCurrentUrl();
		
		//use credentials 
		if(x.startsWith("https")) {
			System.out.println("site is secure");
		}else {
			System.out.println("site is not secure");
		}
		//display url
		//System.out.println(x);
		//close driver
		driver.close();
	}
}
