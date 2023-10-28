package stevejobs;

import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test05 {

	public static void main(String[] args) {
		WebDriverManager.edgedriver().setup();
		
		EdgeDriver edgeDriver=new EdgeDriver();
		edgeDriver.get("http://www.google.com");
	}
}
