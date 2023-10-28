package stevejobs;

import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test04 {

	public static void main(String[] args) {
		//WebDriverManager.chromedriver().setup();
		WebDriverManager.iedriver().setup();
		
		InternetExplorerDriver ieDriver=new InternetExplorerDriver();
		//ChromeDriver ieDriver=new ChromeDriver();
		ieDriver.get("http://www.google.com");
		//ieDriver.manage().window().maximize();
		
		
	}
}
