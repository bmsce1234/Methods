package stevejobs;

import org.openqa.selenium.opera.OperaDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test03 {

	public static void main(String[] args) {
		WebDriverManager.operadriver().setup();
		
		OperaDriver operaDriver=new OperaDriver();
		operaDriver.get("http://www.mvnrepository.com");

	}

}
