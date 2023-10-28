package com.driver.switchTo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SwitchToAndNewWindow {

	public static void main(String[] args)throws Exception {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com");
		Thread.sleep(5000);
		driver.manage().window().maximize();
		
		/*Options o=driver.manage();
		Window w=o.window();
		w.maximize();*/
		
		//create a new tab
		driver.switchTo().newWindow(WindowType.TAB);
		Thread.sleep(3000);
		
		driver.switchTo().newWindow(WindowType.WINDOW);
		Thread.sleep(3000);
		
		Set<String> s=driver.getWindowHandles();
		List<String> l =new ArrayList<String>(s);
		System.out.println(l.size());
		
		//switch to 2nd tab and search email
		driver.switchTo().window(l.get(1));
		driver.get("https://www.gmail.com");
		Thread.sleep(5000);
		
		//switch to 3rd window and search yahoo
		driver.switchTo().window(l.get(2));
		driver.get("https://www.yahoogmail.com");
		Thread.sleep(5000);
		
		//close all window/tab
		driver.quit();
	}
}
