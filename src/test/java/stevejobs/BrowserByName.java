package stevejobs;

import java.util.Scanner;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserByName {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter Browser Name:: ");
		String browserName=sc.nextLine();
		sc.close();
		System.out.println(browserName);
		
		RemoteWebDriver webDriver;
		
		if(browserName.equals("chrome")) {
		    WebDriverManager.chromedriver().setup();
			webDriver=new ChromeDriver();
			
		}else if(browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			webDriver=new FirefoxDriver();
			//webDriver.get("http://www.youtube.com");
		}else if(browserName.equals("opera")) {
			WebDriverManager.operadriver().setup();
			webDriver=new OperaDriver();
			//webDriver.get("http://www.pubg.com");
		}else if(browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			webDriver=new EdgeDriver();
			//webDriver.get("http://www.yahoo.com");
		}else{
			WebDriverManager.iedriver().setup();
			webDriver=new InternetExplorerDriver();
			//webDriver.get("http://mvnrepository.com");
		}
		webDriver.get("http://www.google.com");
	}
}
