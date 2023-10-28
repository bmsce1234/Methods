package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class TestStaleElementException {
	
	static RemoteWebDriver driver;
	
	
	@FindBy(xpath = "//a[text()='Gmail']")
	WebElement link;
	
	public TestStaleElementException() {
		AjaxElementLocatorFactory al =new AjaxElementLocatorFactory(driver, 20);
		
		PageFactory.initElements(driver, this);
	}
	
	public  void click() {
		link.click();
		
	}

	public static void main(String[] args)throws Exception {
		
		
		WebsiteUtilities utilities=new WebsiteUtilities();
		
		 driver=utilities.getBrowserName("chrome");
		
		utilities.launchSite(driver, "http://www.google.com", 5000);
		
		/*WebElement ele=
				driver.findElement(By.name("q"));
		
		ele.sendKeys("Abdul kalam",Keys.ENTER);
		Thread.sleep(5000);
		
		//driver.findElement(By.xpath("//button[@id='search-icon-legacy']")).click();
		
		
		driver.navigate().back();
		//Thread.sleep(5000);
		ele=driver.findElement(By.name("q"));
		ele.sendKeys("Steve jobs");*/
  
		TestStaleElementException t =new TestStaleElementException();
		t.click();
		Thread.sleep(5000);
		driver.navigate().back();
		t.click();
		
	}

}
