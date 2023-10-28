package com.test.WebTableAutomation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class WebTableAutomationOnGmail {

	private RemoteWebDriver driver;
	
	@FindBy(name = "identifier")
	private WebElement uesrId;
	
	@FindBy(xpath = "//span[text()='Next']/parent::button")
	private WebElement userIdNext;
	
	@FindBy(name = "password")
	private WebElement password;
	
	@FindBy(xpath = "//span[text()='Next']/parent::button")
	private WebElement passwordNext;
	
	@FindBys({
		@FindBy(xpath = "(//table[@role='grid'])[2]/tbody/tr")
	})
	private List<WebElement> mails;
	
	@FindBy(xpath = "//div[@data-tooltip='Older']")
	private WebElement next;
	
	@FindBy(xpath = "//a[contains(@aria-label,'Google Account:')]")
	private WebElement profilePic;
	
	@FindBy(linkText = "Sign out")
	private WebElement logout;
	
	public WebTableAutomationOnGmail(RemoteWebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void setUserId(String uid) {
		uesrId.sendKeys(uid);
	}
	
	public void clickUidNext() {
		userIdNext.click();
	}
	
	public void setPassword(String pass) {
		password.sendKeys(pass);
	}
	
	public void clickPassNext() {
		passwordNext.click();
	}
	
	public int getCountofAllMails()throws Exception {
		driver.navigate().refresh();
		Thread.sleep(3000);
		int allMailsCount=0;
		while(true) {
			allMailsCount=allMailsCount+mails.size();
			
			try {
				if(next.getAttribute("aria-disabled").equals("true")) {
					break;
				}
			}catch (Exception e) {
				next.click();
				Thread.sleep(3000);
			}
		}//while
		
		return allMailsCount;
	}//getAllMailsCount
	
	public int getCountofUnreadMails()throws Exception {
		driver.navigate().refresh();
		Thread.sleep(3000);
		int unreadMailsCount=0;
		while(true) {
			for(WebElement mail:mails) {
				WebElement e=mail.findElement(By.xpath("child::td[4]/div[1]"));
				String text =(String)driver.executeScript("return(arguments[0].textContent);", e);
				//System.out.println(text);
				if(text.contains("unread")) {
					unreadMailsCount++;
				}
			}//for
			try {
				if(next.getAttribute("aria-disabled").equals("true")) {
					break;
				}
			}catch(Exception e) {
				next.click();
				Thread.sleep(3000);
			}
		}//while
		return unreadMailsCount;
	}//getUnreadMailsCount
	
	public int getCountofReadMails()throws Exception {
		driver.navigate().refresh();
		Thread.sleep(3000);
		int readMailsCount=0;
		while(true) {
			for(WebElement mail:mails) {
				WebElement e=mail.findElement(By.xpath("child::td[4]/div[1]"));
				String text =(String)driver.executeScript("return(arguments[0].textContent);", e);
				//System.out.println(text);
				if(!text.contains("unread")) {
					readMailsCount++;
				}
			}//for
			try {
				if(next.getAttribute("aria-disabled").equals("true")) {
					break;
				}
			}catch(Exception e) {
				next.click();
				Thread.sleep(3000);
			}
		}//while
		return readMailsCount;
	}//getCountofReadMails
	
	public int getCountfromId(String id)throws Exception {
		driver.navigate().refresh();
		Thread.sleep(3000);
		
		int mailsFromId=0;
		
		while(true) {
			for(WebElement mail:mails) {
				WebElement e=mail.findElement(By.xpath("child::td[4]/div[2]/span/span"));
				if(e.getAttribute("email").equals(id)) {
					mailsFromId++;
				}//if
			}//for
			
			try {
				if(next.getAttribute("aria-disabled").equals("true")) {
					break;
				}
			}catch(Exception e) {
				next.click();
				Thread.sleep(3000);
			}
		}//while
		return mailsFromId;
	}//getCountFromId
	
	
	
	public int getCountOfAttachment()throws Exception {
		driver.navigate().refresh();
		Thread.sleep(3000);
		int attachmentCount=0;
		
		while(true) {
			for(WebElement mail:mails) {
				List<WebElement> e=mail.findElements(By.xpath("child::td[5]/div"));
				
				if(e.size()==2) {
					attachmentCount++;
				}
			}//for
			
			try {
				if(next.getAttribute("aria-disabled").equals("true")) {
					break;
				}
			}catch(Exception e) {
				next.click();
				Thread.sleep(3000);
			}
		}//while
		return attachmentCount;
	}//getCountofAttachment
	
	
	public int getCountOfMailOnDate(int year,String month,int day)throws Exception {
		driver.navigate().refresh();
		Thread.sleep(3000);
		
		int dateCountMails=0;
		while(true) {
			for(WebElement mail:mails) {
				WebElement e=mail.findElement(By.xpath("child::td[8]/span"));
				String date=e.getAttribute("title");
				System.out.println(date);
				//Wed, Sep 15, 2021, 6:34 PM
				String a[]=date.split(",");
				String b[]=a[1].trim().split(" ");
				int yy=Integer.parseInt(a[2].trim());
				String mm=b[0];
				int dd=Integer.parseInt(b[1]);
				month=month.toLowerCase();
				mm=mm.toLowerCase();
				if(yy==year&&month.contains(mm)&&dd==day) {
					dateCountMails++;
				}//if
			}//for
			
			try {
				if(next.getAttribute("aria-disabled").equals("true")) {
					break;
				}
			}catch(Exception e) {
				next.click();
				Thread.sleep(3000);
			}
		}//while
		
		return dateCountMails;
	}//getCountOfMailOnDate
	
	public int deleteMailOnFromId(String email)throws Exception {
		int deleteMails=0;
		while(true) {
			for(int i=0;i<mails.size();i++) {
				WebElement e=mails.get(i).findElement(By.xpath("child::td[4]/div[2]/span/span"));
				
				if(e.getAttribute("email").equals(email)) {
					mails.get(i).findElement(By.xpath("child::td[2]/div[@role='checkbox']")).click();
					Thread.sleep(3000);
					
					mails.get(i).findElement(By.xpath("child::td[9]/ul/li[2]")).click();
					Thread.sleep(3000);
					i--;
					deleteMails++;
				}//if
			}//for
			
			try {
				if(next.getAttribute("aria-disabled").equals("true")) {
					break;
				}
			}catch(Exception e) {
				next.click();
				Thread.sleep(3000);
			}
		}//while
		return deleteMails;
	}//deleteMailOnFromId
}
