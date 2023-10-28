package stevejobs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UsingGetTitle {

	public static void main(String[] args) {
		// Get Browser driver software for corrosponding driver
		WebDriverManager.chromedriver().setup();
		//Get ChromeDriver
		WebDriver driver=new ChromeDriver();
		//open site
		//driver.get("http://www.google.com");
		driver.get("https://www.amazon.in");
		//get title name of page using  GetTitle()
		String x=driver.getTitle();
		//print title of page
		System.out.println(x);
		//close driver
	

	}

}
