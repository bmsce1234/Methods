package stevejobs;

import java.util.Scanner;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserBySwitchCase {

	public static void main(String[] args) {
		RemoteWebDriver webDriver;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter browser name:: ");
		String browserName=sc.nextLine();
		
        switch (browserName) {
		case "chrome":
			 WebDriverManager.chromedriver().setup();
			 webDriver=new ChromeDriver();
			 webDriver.get("http://www.google.com");
			break;
			
		case "opera":
            WebDriverManager.operadriver().setup();
            webDriver=new OperaDriver();
            webDriver.get("http://www.youtube.com");
            break;
            
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			webDriver=new FirefoxDriver();
			webDriver.get("http://www.pubg.com");
			break;
			
		case "edge":
			WebDriverManager.edgedriver().setup();
			webDriver=new EdgeDriver();
			webDriver.get("http://www.yahoo.com");
			break;
			
		default :
			WebDriverManager.iedriver().setup();
			webDriver=new InternetExplorerDriver();
			webDriver.get("http://www.mvnrepository.com");
			break;
		}
	}
}
