package com.driver.manage.logs;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GettingBrowserLogs {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter browser name::");
		String bn=sc.nextLine();
		
		RemoteWebDriver driver=null;
		if(bn.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}else if(bn.equalsIgnoreCase("opear")) {
			WebDriverManager.operadriver().setup();
			driver=new OperaDriver();
		}else if(bn.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}else {
			System.out.println("please check given browser name");
			System.exit(0);
		}
		
		driver.get("https://www.google.com");
		
		List<LogEntry> allLogs=driver.manage().logs().get("browser").getAll();
		
		for(LogEntry e:allLogs) {
			System.out.println(e.getMessage());
		}

	}

}
