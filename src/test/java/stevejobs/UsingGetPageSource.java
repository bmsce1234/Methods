package stevejobs;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UsingGetPageSource {

	public static void main(String[] args) {
		// Get Browser driver s/w for corrosponding driver
		WebDriverManager.chromedriver().setup();
		//Get ChromeDriver 
		ChromeDriver driver=new ChromeDriver();
		//open a browser and pages
		driver.get("http://www.youtube.com");
		//get page source code by using driver
		String x=driver.getPageSource();
		System.out.println(x);
		driver.close();
		

	}

}
