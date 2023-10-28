package stevejobs;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebsiteUtilities {
	
	public RemoteWebDriver driver;
 
	//based for given browser name it will return object of that browser
	public RemoteWebDriver getBrowserName(String browserName) {
		if(browserName.equals("chrome")) {
			//Get driver software for corresponding browser
			WebDriverManager.chromedriver().setup();
			//Get chrome driver
			driver=new ChromeDriver();

		}else if(browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			
		}else if(browserName.equals("opera")) {
			WebDriverManager.operadriver().setup();
			driver=new OperaDriver();
			
		}else if(browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			
		}else {
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
		}
		
		return (driver);
	}
	
	//method for closing the corresponding given browser
	public void closeBrowser(RemoteWebDriver driver) {
		driver.quit();
	}
	
	public void launchSite(RemoteWebDriver driver,String url,long wait) throws Exception {
		driver.manage().window().maximize();
		driver.get(url);
		Thread.sleep(wait);
	}
	
	public void closeWindowOrTab(RemoteWebDriver driver,String handle) {
		driver.switchTo().window(handle).close();
		//driver.close();
	}
	
	public List<String> getWindowHandlesList(RemoteWebDriver driver){
		Set<String> s=driver.getWindowHandles();
		List<String> l=new ArrayList<String>(s);
		return l;
	}
}
