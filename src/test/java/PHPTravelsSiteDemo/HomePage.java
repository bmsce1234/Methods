package PHPTravelsSiteDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	private RemoteWebDriver driver;

	@FindBy(linkText = "Login")
	private WebElement loginBtn;
	
	@FindBy(id = "inputEmail")
	private WebElement userName;
	
	public HomePage(RemoteWebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String verifyLoginButton()throws Exception {
		loginBtn.click();
		Thread.sleep(3000);
		
		Set<String> wHandles=driver.getWindowHandles();
		List<String> sHandles=new ArrayList<>(wHandles);
		
		driver.switchTo().window(sHandles.get(1));
		Thread.sleep(3000);
		try {
		    if(userName.isDisplayed()) {
		       return "login button test passed";
		    }else {
			   return "login button test failed";
		    }
		   }catch(Exception e) {
			 return "login button test failed";
		  }
	  }
}
