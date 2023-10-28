package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GmailCompose {
	
	//declare variables based on element on page
	private By composeBy,toBy,subjectBy,bodyBy,attachmentby,sendBy;
	private RemoteWebDriver driver;
	
	public GmailCompose(RemoteWebDriver driver) {
		
		//store parameterise driver object to current class driver object
		this.driver=driver;
		
		//store compose element to composeBy variable
		composeBy=By.xpath("//div[text()='Compose']");
		
		//store To address in toBy
		toBy=By.name("to");
		
		//store subject to subjectBy
		subjectBy=By.name("subjectbox");
		
		//store body to bodyBy
		bodyBy=By.xpath("//div[@aria-label='Message Body']");
		
		//store filepath in attachmentBy
		attachmentby=By.name("Filedata");
		
		//store send button in sendBy
		sendBy=By.xpath("//div[text()='Send']");
	}
	
	//click on compose
	public void clickCompose() {
		driver.findElement(composeBy).click();
	}
	
	//fill the To address
	public void fillTo(String to) {
		driver.findElement(toBy).sendKeys(to);
	}
	
	//fill subject 
	public void fillSubject(String subject) {
		driver.findElement(subjectBy).sendKeys(subject);
	}
	
	//fill body
	public void fillBody(String body) {
		driver.findElement(bodyBy).sendKeys(body);
	}
	
	//fill filepath attachment
	public void fillFilePath(String filpath) {
		driver.findElement(attachmentby).sendKeys(filpath);
	}
	
	//click send button
	public void clickSend() {
		driver.findElement(sendBy).click();
	}

}
