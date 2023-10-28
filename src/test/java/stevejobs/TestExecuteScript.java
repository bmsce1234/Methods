package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestExecuteScript {


	public static void main(String[] args) throws Exception {
	
		WebElement e;
		WebElement e1;
		WebElement e2;
		WebElement e3;
		String userName="info.anku527@gmail.com";
		String password="ankush9145204527";
		WebsiteUtilities utilities=new WebsiteUtilities();
		
		RemoteWebDriver driver=utilities.getBrowserName("chrome");
		
		utilities.launchSite(driver, "http://www.gmail.com", 5000);
		
		e=driver.findElement(By.name("identifier"));
		e1=driver.findElement(By.xpath("//span[text()='Next']"));
		
		
		driver.executeScript("arguments[0].setAttribute('value',"+"'"+userName+"')", e);
		driver.executeScript("arguments[0].click()", e1);
		Thread.sleep(7000);
		
		e2=driver.findElement(By.name("password"));
		e3=driver.findElement(By.xpath("//span[text()='Next']"));
		
		//driver.executeScript("arguments[0].setAttribute('value',"+"'"+password+"')", e2);
		e2.sendKeys(password);
		Thread.sleep(5000);
		driver.executeScript("arguments[0].click()", e3);
		Thread.sleep(5000);

	}
}
