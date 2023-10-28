package stevejobs;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test01 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver chromeDriver=new ChromeDriver();
		
		chromeDriver.get("http://www.google.com");
		chromeDriver.manage().window().maximize();
		
		//chromeDriver.close();
	}
}
