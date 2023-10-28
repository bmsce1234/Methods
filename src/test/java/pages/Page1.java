package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Page1 {
	
	private By electronics,mobileAccessories,textSearch,search;
	private RemoteWebDriver driver;
	
	public Page1(RemoteWebDriver driver) {
		electronics=By.xpath("//a[text()=' Electronics ']");
		mobileAccessories=By.xpath("(//span[@class='nav-a-content'])[2]/parent::a");
		textSearch=By.xpath("//input[@aria-label='Search']");
		search=By.xpath("//input[@type='submit']");
		
		this.driver=driver;
	}
	
	public void clickElectronics() {
		driver.findElement(electronics).click();
	}
	
	public void clickMobileAccessories() {
		driver.findElement(mobileAccessories).click();
	}
	
	public void inputTextSearch(String search) {
		driver.findElement(textSearch).sendKeys(search,Keys.ENTER);
	}
	
	public void clickSearch() {
		driver.findElement(search).click();
	}
}
