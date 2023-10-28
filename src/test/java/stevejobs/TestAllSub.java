package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestAllSub {

	public static void main(String[] args) {

		WebDriverManager driver=WebDriverManager.chromedriver();
		driver.setup();
		
		ChromeDriver cdriver=new ChromeDriver();
		
		//RemoteWebDriver class Methods
		/*1)*/ cdriver.get("http://www.google.com");
		
		/*2)*/ System.out.println(cdriver.getCurrentUrl());// this is used for getting current url
		
		/*3)*/ System.out.println(cdriver.getTitle());//this is used for geting Title of current window
		
		/*4)*/ System.out.println(cdriver.getPageSource());//it will return page source
		
		/*5)*/ System.out.println(cdriver.getWindowHandle());//it is used for getting a unique id for current window
		
		/*6)*/ //cdriver.getWindowHandles();//used for getting all windows unique id's
		
		/*7)*/ cdriver.findElement(By.name("q"));//used to find specific element on a webPage
		
		/*8)*/ cdriver.close();//used for close the current tab or window
		/*9)*/ //cdriver.quit();//used for close all tab or windows
	}

}
