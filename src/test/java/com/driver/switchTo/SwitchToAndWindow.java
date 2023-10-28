package com.driver.switchTo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SwitchToAndWindow {

	public static void main(String[] args)throws Exception {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		driver.get("https://www.w3schools.com/jsref/met_win_alert.asp");
		driver.manage().window().maximize();
		
		//1-in first frame click on button
		driver.findElement(By.xpath("(//a[text()='Try it Yourself »'])[1]")).click();
		Thread.sleep(3000);
		
		//2-get window handles and switch to 2nd window
		Set<String> s=driver.getWindowHandles();
		List<String> l=new ArrayList<String>(s);
		driver.switchTo().window(l.get(1));
		Thread.sleep(3000);
		
		//3-switch to frame in 2nd window/tab
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		Thread.sleep(3000);
		
		//4-switch to alert
		driver.switchTo().alert().dismiss();
		Thread.sleep(2000);
		
		//5-back to 2nd window from frame
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		//close 2nd window
		driver.close();
		
		//6-back to 1st window
		driver.switchTo().window(l.get(0));
		Thread.sleep(3000);
		//close 1st window
		driver.close();
	}
}