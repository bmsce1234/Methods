package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PFGmailCompose {
	
	private RemoteWebDriver driver;
	
	@FindBy(xpath = "//div[text()='Compose']")
	private WebElement compose;
	
	@FindBy(name = "to")
	private WebElement to;
	
	@FindBy(name = "subjectbox")
	private WebElement subject;
	
	@FindBy(xpath = "//div[@aria-label='Message Body']")
	private WebElement body;
	
	@FindBy(name = "Filedata")
	private WebElement filePath;
	
	@FindBy(xpath = "//div[text()='Send']")
	private WebElement send;
	
	public PFGmailCompose(RemoteWebDriver driver) {
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}
	
	public void clickCompose() {
		compose.click();
	}
	
	public void fillTo(String toAddress) {
		to.sendKeys(toAddress);
	}
	
	public void fillSubject(String sub) {
		subject.sendKeys(sub);
	}
	
	public void fillBody(String bodyFor) {
		body.sendKeys(bodyFor);
	}
	
	public void fillFilePath(String attchment) {
		filePath.sendKeys(attchment);
	}
	
	public void clickSend() {
		send.click();
	}

}
