package stevejobs;

import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test02 {

	public static void main(String[] args) {
		WebDriverManager.firefoxdriver().setup();
		
		FirefoxDriver firefoxDriver=new FirefoxDriver();
		firefoxDriver.get("http://www.youtube.com");
		//firefoxDriver.manage().window().maximize();

	}

}
