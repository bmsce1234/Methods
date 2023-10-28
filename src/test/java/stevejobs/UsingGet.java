package stevejobs;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UsingGet {

	public static void main(String[] args) {
		// Get  corrosponding driver software for ChromeDriver
		WebDriverManager.chromedriver().setup();
		//Get ChromeDriver
		RemoteWebDriver driver=new ChromeDriver();
		//open pages by calling get method
		driver.get("http://www.google.com");
		//close the driver
        driver.close();
        
	}

}
