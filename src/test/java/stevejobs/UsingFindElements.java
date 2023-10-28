package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class UsingFindElements {

	public static void main(String[] args) throws Exception {
		WebsiteUtilities utilities=new WebsiteUtilities();
		
		RemoteWebDriver driver=utilities.getBrowserName("chrome");
		
		utilities.launchSite(driver, "https://mail.google.com", 5000);
		driver.findElement(By.name("identifier")).sendKeys("info.anku527@gmail.com");
		
		Thread.sleep(5000);
		driver.findElement(By.className("VfPpkd-vQzf8d")).click();
		
		Thread.sleep(5000);		
		driver.findElement(By.name("password")).sendKeys("ankush9145204527");
		
		Thread.sleep(5000);
		driver.findElement(By.className("VfPpkd-vQzf8d")).click();
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[text()='Compose']")).click();
		
		Thread.sleep(5000);
		driver.findElement(By.name("to")).sendKeys("ankushd.tech527@gmail.com");
		
		Thread.sleep(5000);
		driver.findElement(By.name("subjectbox")).sendKeys("Hii, this msg comming from automation");
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@role='textbox']")).sendKeys("Hello");
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[text()='Send']")).click();
		Thread.sleep(5000);
		
		utilities.closeBrowser(driver);

	}
}