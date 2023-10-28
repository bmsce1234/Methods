package com.test.fileData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.rmi.Remote;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.remote.RemoteWebDriver;

import stevejobs.WebsiteUtilities;

public class GetDataFromFileTest {

	public static void main(String[] args) throws Exception {
		String browserName,uName,pwd=null;
		List<String> allName=new ArrayList<String>();
		
		File file=new File("D:\\Testing255\\uNamePwd.txt");
		
		FileReader fr=new FileReader(file);
		
		BufferedReader br=new BufferedReader(fr);
		
		String line=null;
		
		while((line=br.readLine())!=null) {
		    allName.add(line);
		}
		browserName=allName.get(0);
		uName=allName.get(1);
		pwd=allName.get(2);
		
		
		//create websiteutility class object
		WebsiteUtilities utility=new WebsiteUtilities();
		
		RemoteWebDriver driver=utility.getBrowserName(browserName);
		
		//launch site
		utility.launchSite(driver, "http://www.gmail.com", 5000);
		
		//create page class object
		GetDataFromFilePage page =new GetDataFromFilePage(driver);
		
		//call methode
		page.fillUserName(uName);
		page.clickUNBtn();
		Thread.sleep(5000);
		
		page.fillPassword(pwd);
		page.clickPWDBtn();
		Thread.sleep(5000);
		
		//close driver
		utility.closeBrowser(driver);

	}

}
