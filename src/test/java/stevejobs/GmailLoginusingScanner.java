package stevejobs;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GmailLoginusingScanner {

	public static void main(String[] args) throws Exception {
		WebsiteUtilities utilities=new WebsiteUtilities();
		RemoteWebDriver driver=null;
		
	     //create scanner object taking input from keyboard
		 Scanner sc=new Scanner(System.in);
		
		 // take browser name from input
		 System.out.println("Enter Browser Name:: ");
		 String browserName=sc.nextLine();
		 
		 //get credentials
		 System.out.println("Enter userName:: ");
		 String userName=sc.nextLine();
		 System.out.println("Enter password:: ");
		 String password=sc.nextLine();
		 
		 //  get To 
		 System.out.println("Enter mail To:: ");
		 String to=sc.nextLine();
		 
		 // get sub
		 System.out.println("Enter subject:: ");
		 String sub=sc.nextLine();
		 
		 // get body
		 System.out.println("Enter body:: ");
		 String body=sc.nextLine();
		 
		 //get attachment
		 System.out.println("Enter attachment:: ");
		 String attchmnt=sc.nextLine();
		 
		 //close the scanner
		 sc.close();
		 
		 //get browser driver software
		 driver=utilities.getBrowserName(browserName);
		 
		 //launch the browser
		 utilities.launchSite(driver, "http://www.gmail.com", 5000);
		 
		 //locate user name field and fill the user sname
		 driver.findElement(By.name("identifier")).sendKeys(userName);
		 
		 //locate next button and click on it
		 Thread.sleep(5000);
		 driver.findElement(By.xpath("//span[text()='Next']")).click();
		 
		 //locate password field and fill it
		 Thread.sleep(5000);
		 driver.findElement(By.name("password")).sendKeys(password);
		 
		 //locate next button and click on it
		 Thread.sleep(5000);
		 driver.findElement(By.xpath("//span[text()='Next']")).click();
		 
		 //click on compose
		 Thread.sleep(5000);
		 driver.findElement(By.xpath("//div[text()='Compose']")).click();
		 
		 //locate To field and fill it
		 Thread.sleep(5000);
		 driver.findElement(By.name("to")).sendKeys(to);
		 //locate subject field and fill it
		 Thread.sleep(5000);
		 driver.findElement(By.name("subjectbox")).sendKeys(sub);
		 //locate body field and fill it
		 Thread.sleep(5000);
		 driver.findElement(By.xpath("//div[@aria-label='Message Body']")).sendKeys(body);
		 
		 //click on attachment and get image update
		 Thread.sleep(5000);
		 driver.findElement(By.name("Filedata")).sendKeys(attchmnt);
		 
		 //click on send button // send email
		 Thread.sleep(5000);
		 driver.findElement(By.xpath("//div[text()='Send']")).click();
		 
		 //do logout
		 Thread.sleep(5000);
		 driver.findElement(By.xpath("//img[@class='gb_Ca gbii']")).click();
		 Thread.sleep(5000);
		 //driver.findElement(By.xpath("//a[text()='Sign out']")).click();
		 driver.findElement(By.partialLinkText("Sign out")).click();
		 
		 //close the browser
		 Thread.sleep(5000);
	     //driver.close();	
		 utilities.closeBrowser(driver);
	}
}
